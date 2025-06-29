CREATE TABLE accounts (
    acct_no  NUMBER PRIMARY KEY,
    balance  NUMBER
);
-- Insert account 1001 (from account)
INSERT INTO accounts VALUES (1001, 8000);

-- Insert account 1002 (to account)
INSERT INTO accounts VALUES (1002, 2000);

COMMIT;

CREATE OR REPLACE PROCEDURE transfer_funds (
    p_from_acct  IN NUMBER,
    p_to_acct    IN NUMBER,
    p_amount     IN NUMBER
) AS
    v_balance    NUMBER;
BEGIN
    -- Check if from account exists and get balance
    SELECT balance INTO v_balance
    FROM accounts
    WHERE acct_no = p_from_acct;

    -- Check for sufficient balance
    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('❌ Insufficient funds.');
        RETURN;
    END IF;

    -- Perform fund transfer
    UPDATE accounts SET balance = balance - p_amount WHERE acct_no = p_from_acct;
    UPDATE accounts SET balance = balance + p_amount WHERE acct_no = p_to_acct;

    DBMS_OUTPUT.PUT_LINE('✅ Rs. ' || p_amount || ' transferred successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ One of the accounts not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❌ Transfer failed: ' || SQLERRM);
END;
/
SHOW ERRORS;
SET SERVEROUTPUT ON;
EXEC transfer_funds(1001, 1002, 3000);
SELECT * FROM accounts;


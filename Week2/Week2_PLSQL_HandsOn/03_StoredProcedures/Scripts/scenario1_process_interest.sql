CREATE TABLE loans (
    loan_id   NUMBER PRIMARY KEY,
    amount    NUMBER,
    interest  NUMBER
);
INSERT INTO loans VALUES (2001, 100000, NULL);
COMMIT;
CREATE OR REPLACE PROCEDURE calculate_interest (
    p_loan_id    IN NUMBER,
    p_rate       IN NUMBER
) AS
    v_amount     NUMBER;
    v_interest   NUMBER;
BEGIN
    SELECT amount INTO v_amount
    FROM loans
    WHERE loan_id = p_loan_id;

    v_interest := v_amount * (p_rate / 100);

    UPDATE loans
    SET interest = v_interest
    WHERE loan_id = p_loan_id;

    DBMS_OUTPUT.PUT_LINE('✅ Interest updated to: ' || TO_CHAR(v_interest));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Loan ID not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/
SHOW ERRORS;
SET SERVEROUTPUT ON;
EXEC calculate_interest(2001, 7.5);


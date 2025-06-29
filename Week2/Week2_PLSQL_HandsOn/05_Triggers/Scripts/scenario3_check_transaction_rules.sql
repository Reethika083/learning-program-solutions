-- Scenario 3: Block invalid transactions
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.transaction_type = 'withdrawal' THEN
        SELECT balance INTO v_balance
        FROM accounts
        WHERE acct_no = :NEW.acct_no;

        IF :NEW.amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, '❌ Withdrawal exceeds balance.');
        END IF;

    ELSIF :NEW.transaction_type = 'deposit' THEN
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, '❌ Deposit amount must be positive.');
        END IF;
    END IF;
END;
/

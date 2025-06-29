CREATE TABLE accounts (
    acct_no NUMBER PRIMARY KEY,
    balance NUMBER
);

INSERT INTO accounts VALUES (12345, 10000);
INSERT INTO accounts VALUES (23456, 8000);
INSERT INTO accounts VALUES (34567, 12000);
COMMIT;
SELECT * FROM accounts;

SET SERVEROUTPUT ON;

DECLARE
    CURSOR acct_cursor IS
        SELECT acct_no, balance FROM accounts;

    v_acct acct_cursor%ROWTYPE;
    v_fee NUMBER := 250;
BEGIN
    OPEN acct_cursor;

    LOOP
        FETCH acct_cursor INTO v_acct;
        EXIT WHEN acct_cursor%NOTFOUND;

        UPDATE accounts
        SET balance = balance - v_fee
        WHERE acct_no = v_acct.acct_no;

        DBMS_OUTPUT.PUT_LINE('Rs. ' || v_fee || ' deducted from Account: ' || v_acct.acct_no);
    END LOOP;

    CLOSE acct_cursor;

    COMMIT;
END;
/

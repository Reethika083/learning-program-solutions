CREATE TABLE transactions (
  transaction_id NUMBER,
  acct_no NUMBER,
  amount NUMBER,
  transaction_type VARCHAR2(20),
  transaction_date DATE
);
SELECT object_name, object_type 
FROM user_objects 
WHERE object_name = 'TRANSACTIONS';
SELECT * FROM transactions;

SET SERVEROUTPUT ON;

DECLARE
    CURSOR txn_cursor IS
        SELECT t.transaction_id, t.acct_no, t.amount, t.transaction_type, t.transaction_date
        FROM transactions t
        WHERE EXTRACT(MONTH FROM t.transaction_date) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.transaction_date) = EXTRACT(YEAR FROM SYSDATE);

    v_txn txn_cursor%ROWTYPE;
BEGIN
    OPEN txn_cursor;

    LOOP
        FETCH txn_cursor INTO v_txn;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Txn ID: ' || v_txn.transaction_id || 
                             ', Account: ' || v_txn.acct_no ||
                             ', Type: ' || v_txn.transaction_type ||
                             ', Amount: Rs. ' || v_txn.amount ||
                             ', Date: ' || TO_CHAR(v_txn.transaction_date, 'DD-MON-YYYY'));
    END LOOP;

    CLOSE txn_cursor;
END;
/
INSERT INTO transactions VALUES (101, 12345, 5000, 'DEPOSIT', SYSDATE - 1);
INSERT INTO transactions VALUES (102, 12345, 2000, 'WITHDRAWAL', SYSDATE - 2);
COMMIT;


SELECT transaction_id, transaction_date FROM transactions;
DELETE FROM transactions;

INSERT INTO transactions VALUES (101, 12345, 5000, 'DEPOSIT', SYSDATE);
INSERT INTO transactions VALUES (102, 12345, 2000, 'WITHDRAWAL', SYSDATE);
COMMIT;

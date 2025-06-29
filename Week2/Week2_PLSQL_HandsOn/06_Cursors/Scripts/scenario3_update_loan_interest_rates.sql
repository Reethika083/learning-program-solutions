CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    amount NUMBER,
    interest_rate NUMBER
);

INSERT INTO loans VALUES (101, 450000, NULL);
INSERT INTO loans VALUES (102, 750000, NULL);
INSERT INTO loans VALUES (103, 200000, NULL);
COMMIT;
SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT loan_id, amount FROM loans;

    v_loan loan_cursor%ROWTYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN loan_cursor;

    LOOP
        FETCH loan_cursor INTO v_loan;
        EXIT WHEN loan_cursor%NOTFOUND;

        -- Apply policy: > 5L → 9%, else 7.5%
        IF v_loan.amount > 500000 THEN
            v_new_rate := 9;
        ELSE
            v_new_rate := 7.5;
        END IF;

        UPDATE loans
        SET interest_rate = v_new_rate
        WHERE loan_id = v_loan.loan_id;

        DBMS_OUTPUT.PUT_LINE('Loan ' || v_loan.loan_id || ' interest updated to ' || v_new_rate || '%');
    END LOOP;

    CLOSE loan_cursor;

    COMMIT;
END;
/

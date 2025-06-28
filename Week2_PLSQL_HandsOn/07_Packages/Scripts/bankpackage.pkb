-- Package Body
CREATE OR REPLACE PACKAGE BODY BankPackage AS

    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER) IS
    BEGIN
        INSERT INTO customers (cust_id, cust_name, age)
        VALUES (p_id, p_name, p_age);
        DBMS_OUTPUT.PUT_LINE('👤 New customer added: ' || p_name);
    END;

    FUNCTION GetAgeGroup(p_age NUMBER) RETURN VARCHAR2 IS
    BEGIN
        IF p_age < 18 THEN
            RETURN 'Minor';
        ELSIF p_age BETWEEN 18 AND 60 THEN
            RETURN 'Adult';
        ELSE
            RETURN 'Senior';
        END IF;
    END;

    PROCEDURE Credit(p_acct_no NUMBER, p_amt NUMBER) IS
    BEGIN
        UPDATE accounts
        SET balance = balance + p_amt
        WHERE acct_no = p_acct_no;
        DBMS_OUTPUT.PUT_LINE('💰 Credited Rs. ' || p_amt || ' to account: ' || p_acct_no);
    END;

    PROCEDURE Debit(p_acct_no NUMBER, p_amt NUMBER) IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance FROM accounts WHERE acct_no = p_acct_no;
        IF v_balance >= p_amt THEN
            UPDATE accounts
            SET balance = balance - p_amt
            WHERE acct_no = p_acct_no;
            DBMS_OUTPUT.PUT_LINE('💸 Debited Rs. ' || p_amt || ' from account: ' || p_acct_no);
        ELSE
            DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance.');
        END IF;
    END;

    FUNCTION CalculateLoanInterest(p_loan_id NUMBER) RETURN NUMBER IS
        v_amount NUMBER;
        v_rate   NUMBER := 8.5;
    BEGIN
        SELECT amount INTO v_amount FROM loans WHERE loan_id = p_loan_id;
        RETURN ROUND(v_amount * (v_rate / 100), 2);
    END;

END BankPackage;
/

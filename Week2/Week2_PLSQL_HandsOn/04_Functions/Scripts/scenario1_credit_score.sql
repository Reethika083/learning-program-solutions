-- Customers table
CREATE TABLE customers (
    cust_id   NUMBER PRIMARY KEY,
    cust_name VARCHAR2(100),
    age       NUMBER
);

-- Loans table
CREATE TABLE loans (
    loan_id   NUMBER PRIMARY KEY,
    cust_id   NUMBER,
    amount    NUMBER,
    interest  NUMBER
);
-- Insert one customer
INSERT INTO customers VALUES (105, 'Neha Menon', 29);

-- Insert two loans for that customer
INSERT INTO loans VALUES (3001, 105, 100000, 7500);
INSERT INTO loans VALUES (3002, 105, 50000, 3500);

COMMIT;
CREATE OR REPLACE FUNCTION get_credit_score (
    p_cust_id IN NUMBER
) RETURN NUMBER AS
    v_age        NUMBER;
    v_loan_count NUMBER;
    v_score      NUMBER;
BEGIN
    SELECT age INTO v_age
    FROM customers
    WHERE cust_id = p_cust_id;

    SELECT COUNT(*) INTO v_loan_count
    FROM loans
    WHERE cust_id = p_cust_id;

    v_score := 600 + (v_age / 10) + (v_loan_count * 15);

    RETURN v_score;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END;
/
SHOW ERRORS;
SET SERVEROUTPUT ON;

DECLARE
    v_score NUMBER;
BEGIN
    v_score := get_credit_score(105);
    DBMS_OUTPUT.PUT_LINE('Credit score: ' || v_score);
END;
/


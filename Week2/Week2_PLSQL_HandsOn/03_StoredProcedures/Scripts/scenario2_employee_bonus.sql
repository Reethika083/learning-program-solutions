CREATE TABLE employees (
    emp_id   NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    salary   NUMBER
);
INSERT INTO employees VALUES (102, 'Aarav Sharma', 50000);
COMMIT;
CREATE OR REPLACE PROCEDURE give_bonus (
    p_emp_id     IN NUMBER,
    p_bonus_pct  IN NUMBER
) AS
    v_salary     NUMBER;
    v_bonus      NUMBER;
BEGIN
    SELECT salary INTO v_salary
    FROM employees
    WHERE emp_id = p_emp_id;

    v_bonus := v_salary * (p_bonus_pct / 100);

    UPDATE employees
    SET salary = salary + v_bonus
    WHERE emp_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('🎁 Bonus of Rs. ' || TO_CHAR(v_bonus) || ' added!');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Employee not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/
SHOW ERRORS;
SET SERVEROUTPUT ON;
EXEC give_bonus(102, 10);
SELECT * FROM employees WHERE emp_id = 102;

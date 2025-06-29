-- Scenario 2: Update Employee Salary
SET SERVEROUTPUT ON;

DECLARE
    v_emp_id NUMBER := 102;
    v_new_salary NUMBER := 60000;
BEGIN
    UPDATE employees
    SET salary = v_new_salary
    WHERE emp_id = v_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    ELSE
        DBMS_OUTPUT.PUT_LINE('💼 Salary updated successfully.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Employee not found. Please check the ID.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❗Unexpected Error: ' || SQLERRM);
END;
/

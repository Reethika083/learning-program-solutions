-- Scenario 3: Insert New Customer
SET SERVEROUTPUT ON;

BEGIN
    INSERT INTO customers (cust_id, cust_name, age)
    VALUES (105, 'Neha Menon', 29);

    DBMS_OUTPUT.PUT_LINE('✅ New customer added!');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Customer already exists (duplicate ID).');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❌ Insertion failed: ' || SQLERRM);
END;
/

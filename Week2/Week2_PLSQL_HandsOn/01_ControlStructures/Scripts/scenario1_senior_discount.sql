-- Scenario 1: Apply Senior Discount
SET SERVEROUTPUT ON;

DECLARE
    v_customer_name VARCHAR2(50) := 'Ravi';
    v_age NUMBER := 65;
    v_processing_fee NUMBER := 500;
    v_discounted_fee NUMBER;
BEGIN
    IF v_age > 60 THEN
        v_discounted_fee := v_processing_fee * 0.9;
        DBMS_OUTPUT.PUT_LINE('🎉 Senior Citizen Discount Applied!');
        DBMS_OUTPUT.PUT_LINE('💰 Final Fee: Rs. ' || v_discounted_fee);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No Discount Applied. Fee: Rs. ' || v_processing_fee);
    END IF;
END;
/

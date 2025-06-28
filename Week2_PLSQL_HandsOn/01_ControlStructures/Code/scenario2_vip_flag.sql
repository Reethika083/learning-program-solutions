-- Scenario 2: VIP Flag Based on Balance
SET SERVEROUTPUT ON;

DECLARE
    v_balance NUMBER := 125000;
    v_is_vip VARCHAR2(5);
BEGIN
    IF v_balance > 100000 THEN
        v_is_vip := 'Yes';
    ELSE
        v_is_vip := 'No';
    END IF;

    DBMS_OUTPUT.PUT_LINE('🏦 Balance: Rs. ' || v_balance);
    DBMS_OUTPUT.PUT_LINE('🌟 VIP Customer: ' || v_is_vip);
END;
/

-- File: withdrawal_check.sql

SET SERVEROUTPUT ON;

DECLARE
    v_acct_no     NUMBER := 1001;
    v_withdraw    NUMBER := 3000;
    v_balance     NUMBER;
BEGIN
    -- Fetch balance from the table
    SELECT balance INTO v_balance
    FROM accounts
    WHERE acct_no = v_acct_no;

    -- Check if withdrawal is possible
    IF v_balance >= v_withdraw THEN
        DBMS_OUTPUT.PUT_LINE('✅ Withdrawal of Rs. ' || v_withdraw || ' is approved.');
        DBMS_OUTPUT.PUT_LINE('💰 Remaining Balance: Rs. ' || (v_balance - v_withdraw));
    ELSE
        DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance! Withdrawal denied.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Account number not found!');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('🔴 Error: ' || SQLERRM);
END;
/

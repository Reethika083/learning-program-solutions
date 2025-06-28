SET SERVEROUTPUT ON;

DECLARE
    v_from_acct NUMBER := 1001;
    v_to_acct   NUMBER := 1002;
    v_amount    NUMBER := 3000;
    v_from_balance NUMBER;
BEGIN
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE acct_no = v_from_acct;

    IF v_from_balance < v_amount THEN
        DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance!');
    ELSE
        DBMS_OUTPUT.PUT_LINE('✅ Transfer of Rs.' || v_amount || ' successful.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Account not found!');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('🚨 Unexpected error: ' || SQLERRM);
END;
/

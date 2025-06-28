-- Scenario 3: Loan Payment Reminder
SET SERVEROUTPUT ON;

DECLARE
    v_due_days NUMBER := 8;
    v_message VARCHAR2(100);
BEGIN
    IF v_due_days < 5 THEN
        v_message := 'Gentle Reminder: Please pay your EMI soon.';
    ELSIF v_due_days < 10 THEN
        v_message := '⚠️ Urgent: EMI due in less than 10 days.';
    ELSE
        v_message := '🚨 Default Warning: Your EMI is overdue!';
    END IF;

    DBMS_OUTPUT.PUT_LINE(v_message);
END;
/

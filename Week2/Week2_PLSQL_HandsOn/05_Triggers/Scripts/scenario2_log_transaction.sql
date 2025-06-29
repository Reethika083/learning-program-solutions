-- Scenario 2: Log insert activity into AuditLog
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (log_id, transaction_id, log_date, action)
    VALUES (
        audit_seq.NEXTVAL,
        :NEW.transaction_id,
        SYSDATE,
        'INSERT'
    );
END;
/

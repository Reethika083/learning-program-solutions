CREATE TABLE customers (
    cust_id      NUMBER PRIMARY KEY,
    cust_name    VARCHAR2(100),
    age          NUMBER,
    LastModified DATE
);
INSERT INTO customers VALUES (105, 'Neha Menon', 29, NULL);
COMMIT;
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
-- Perform an update to trigger it
UPDATE customers SET cust_name = 'Neha M. Updated' WHERE cust_id = 105;

-- Check the LastModified timestamp
SELECT * FROM customers WHERE cust_id = 105;

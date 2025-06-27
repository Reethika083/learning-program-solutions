-- File: create_accounts.sql

CREATE TABLE accounts (
    acct_no     NUMBER PRIMARY KEY,
    cust_name   VARCHAR2(50),
    balance     NUMBER
);

INSERT INTO accounts VALUES (1001, 'Riya Sharma', 5000);
INSERT INTO accounts VALUES (1002, 'Arjun Mehta', 1200);
COMMIT;

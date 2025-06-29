-- Package Specification
CREATE OR REPLACE PACKAGE BankPackage AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER);
    FUNCTION GetAgeGroup(p_age NUMBER) RETURN VARCHAR2;
    
    PROCEDURE Credit(p_acct_no NUMBER, p_amt NUMBER);
    PROCEDURE Debit(p_acct_no NUMBER, p_amt NUMBER);
    
    FUNCTION CalculateLoanInterest(p_loan_id NUMBER) RETURN NUMBER;
END BankPackage;
/

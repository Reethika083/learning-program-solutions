CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years       IN NUMBER
) RETURN NUMBER AS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / (12 * 100); -- monthly interest rate
    v_months := p_years * 12;                     -- total number of months

    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) /
             (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/
SHOW ERRORS;
SET SERVEROUTPUT ON;

DECLARE
    v_emi NUMBER;
BEGIN
    v_emi := CalculateMonthlyInstallment(500000, 7.5, 10);
    DBMS_OUTPUT.PUT_LINE('EMI is: Rs. ' || v_emi);
END;
/

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT t.TransactionID, t.AccountID, t.TransactionType,
               t.Amount, t.TransactionDate,
               c.CustomerID, c.Name
        FROM   Transactions t
        JOIN   Accounts a ON t.AccountID = a.AccountID
        JOIN   Customers c ON a.CustomerID = c.CustomerID
        WHERE  EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND    EXTRACT(YEAR  FROM t.TransactionDate) = EXTRACT(YEAR  FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;

BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || rec.Name ||
            '  AccountID: ' || rec.AccountID ||
            '  Type: ' || rec.TransactionType ||
            '  Amount: $' || TO_CHAR(rec.Amount, '999,999.00') ||
            '  Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY')
        );
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM   Accounts
        FOR UPDATE;

    v_annual_fee NUMBER := 50;

BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET    Balance = Balance - v_annual_fee, LastModified = SYSDATE
        WHERE  AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee deducted -> AccountID: ' || rec.AccountID ||
            '  Old Balance: $' || TO_CHAR(rec.Balance, '999,999.00') ||
            '  New Balance: $' || TO_CHAR(rec.Balance - v_annual_fee, '999,999.00')
        );
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM   Loans
        FOR UPDATE;

    v_new_rate NUMBER;

BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        IF rec.LoanAmount > 50000 THEN
            v_new_rate := rec.InterestRate - 1;
        ELSIF rec.LoanAmount BETWEEN 10000 AND 50000 THEN
            v_new_rate := rec.InterestRate + 0.5;
        ELSE
            v_new_rate := rec.InterestRate + 1;
        END IF;

        UPDATE Loans
        SET    InterestRate = v_new_rate
        WHERE  LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'LoanID: ' || rec.LoanID ||
            '  LoanAmount: $' || TO_CHAR(rec.LoanAmount, '999,999.00') ||
            '  Old Rate: ' || rec.InterestRate || '%' ||
            '  New Rate: ' || v_new_rate || '%'
        );
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

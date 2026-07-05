DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, c.Name,
               TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age,
               l.LoanID, l.InterestRate
        FROM   Customers c
        JOIN   Loans l ON c.CustomerID = l.CustomerID;

    v_new_rate Loans.InterestRate%TYPE;

BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Age > 60 THEN
            v_new_rate := rec.InterestRate - 1;
            UPDATE Loans
            SET    InterestRate = v_new_rate
            WHERE  LoanID = rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied -> ' || rec.Name || '  Old rate: ' || rec.InterestRate || '%  New rate: ' || v_new_rate || '%');
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate update complete.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance
        FROM   Customers;

    v_vip_count NUMBER := 0;

BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            DBMS_OUTPUT.PUT_LINE('VIP status granted -> ' || rec.Name || '  Balance: $' || TO_CHAR(rec.Balance, '999,999.00'));
            v_vip_count := v_vip_count + 1;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Total VIP customers: ' || v_vip_count);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID,
               l.EndDate,
               l.LoanAmount,
               c.CustomerID,
               c.Name,
               TRUNC(l.EndDate - SYSDATE) AS DaysRemaining
        FROM   Loans     l
        JOIN   Customers c ON l.CustomerID = c.CustomerID
        WHERE  l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.EndDate;

    v_reminder_count NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('===== LOAN DUE-DATE REMINDERS (next 30 days) =====');
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder -> Customer: ' || rec.Name || '  LoanID: ' || rec.LoanID || '  Amount: $' || TO_CHAR(rec.LoanAmount, '999,999.00') || '  Due: ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') || '  Days left: ' || rec.DaysRemaining);
        v_reminder_count := v_reminder_count + 1;
    END LOOP;
    IF v_reminder_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_reminder_count);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

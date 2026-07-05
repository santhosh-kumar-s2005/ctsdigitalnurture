CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance          NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_balance
    FROM   Accounts
    WHERE  AccountID = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET    Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE  AccountID = p_from_account;

    UPDATE Accounts
    SET    Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE  AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful. Amount: $' || p_amount);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id  IN NUMBER,
    p_percentage   IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM   Employees
    WHERE  EmployeeID = p_employee_id;

    IF v_count = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    UPDATE Employees
    SET    Salary = Salary + (Salary * p_percentage / 100)
    WHERE  EmployeeID = p_employee_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for EmployeeID: ' || p_employee_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id  IN NUMBER,
    p_name         IN VARCHAR2,
    p_dob          IN DATE,
    p_balance      IN NUMBER
) AS
    v_count NUMBER;
    customer_exists EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM   Customers
    WHERE  CustomerID = p_customer_id;

    IF v_count > 0 THEN
        RAISE customer_exists;
    END IF;

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully. ID: ' || p_customer_id);

EXCEPTION
    WHEN customer_exists THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/

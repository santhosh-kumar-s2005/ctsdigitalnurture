CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/

CREATE TABLE IF NOT EXISTS AuditLog (
    AuditID       NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID     NUMBER,
    TransactionType VARCHAR2(10),
    Amount        NUMBER,
    TransactionDate DATE,
    LogDate       DATE
);

CREATE SEQUENCE AuditLog_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AuditID,
        TransactionID,
        AccountID,
        TransactionType,
        Amount,
        TransactionDate,
        LogDate
    ) VALUES (
        AuditLog_SEQ.NEXTVAL,
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionType,
        :NEW.Amount,
        :NEW.TransactionDate,
        SYSDATE
    );
END LogTransaction;
/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance          NUMBER;
    invalid_amount     EXCEPTION;
    insufficient_funds EXCEPTION;
BEGIN
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE invalid_amount;
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM   Accounts
        WHERE  AccountID = :NEW.AccountID;

        IF v_balance < :NEW.Amount THEN
            RAISE insufficient_funds;
        END IF;
    END IF;

EXCEPTION
    WHEN invalid_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Error: Deposit amount must be positive.');
    WHEN insufficient_funds THEN
        RAISE_APPLICATION_ERROR(-20002, 'Error: Withdrawal amount exceeds account balance.');
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20003, 'Error: Account ID ' || :NEW.AccountID || ' not found.');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20004, 'Error: ' || SQLERRM);
END CheckTransactionRules;
/

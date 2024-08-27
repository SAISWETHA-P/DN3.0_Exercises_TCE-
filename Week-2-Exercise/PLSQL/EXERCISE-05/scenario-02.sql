-- First, create the AuditLog table
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AuditDate DATE,
    Action VARCHAR2(100),
    FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID)
);

-- Then create the trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (AuditID, TransactionID, AuditDate, Action)
  VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, SYSDATE, 'Transaction inserted');
END;
/

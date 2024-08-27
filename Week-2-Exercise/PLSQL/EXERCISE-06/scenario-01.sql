DECLARE
  CURSOR c_transactions IS
    SELECT t.AccountID, a.CustomerID, a.Balance, t.TransactionDate, t.Amount, t.TransactionType
    FROM Transactions t
    JOIN Accounts a ON t.AccountID = a.AccountID
    WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
      AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

  v_statement VARCHAR2(400);
BEGIN
  FOR rec IN c_transactions LOOP
    v_statement := 'Statement for Customer ' || rec.CustomerID || ': ' ||
                   'Account Balance: ' || rec.Balance || ', ' ||
                   'Transaction Date: ' || rec.TransactionDate || ', ' ||
                   'Amount: ' || rec.Amount || ', ' ||
                   'Type: ' || rec.TransactionType;
    DBMS_OUTPUT.PUT_LINE(v_statement);
  END LOOP;
END;
/

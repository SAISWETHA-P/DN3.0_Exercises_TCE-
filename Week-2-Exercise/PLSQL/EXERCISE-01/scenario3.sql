DECLARE
  CURSOR c_due_loans IS
    SELECT l.CustomerID, c.Name, l.LoanID
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    
  v_message VARCHAR2(400);
BEGIN
  FOR rec IN c_due_loans LOOP
    v_message := 'Reminder: Loan ' || rec.LoanID || ' for customer ' || rec.Name || ' is due soon.';
    DBMS_OUTPUT.PUT_LINE(v_message);
  END LOOP;
END;
/

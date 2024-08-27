DECLARE
  CURSOR c_customers IS
    SELECT CustomerID, DOB
    FROM Customers;
    
  v_age NUMBER;
BEGIN
  FOR rec IN c_customers LOOP
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
    IF v_age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

DECLARE
  CURSOR c_loans IS
    SELECT LoanID, InterestRate
    FROM Loans;
    
  v_new_interest_rate NUMBER := 0.5; -- Example new interest rate increment
BEGIN
  FOR rec IN c_loans LOOP
    UPDATE Loans
    SET InterestRate = InterestRate + v_new_interest_rate
    WHERE LoanID = rec.LoanID;
  END LOOP;
  COMMIT;
END;
/

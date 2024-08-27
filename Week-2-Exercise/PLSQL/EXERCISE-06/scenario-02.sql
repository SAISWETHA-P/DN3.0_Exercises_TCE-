DECLARE
  CURSOR c_accounts IS
    SELECT AccountID, Balance
    FROM Accounts;

  v_annual_fee NUMBER := 50; -- Example annual fee
BEGIN
  FOR rec IN c_accounts LOOP
    UPDATE Accounts
    SET Balance = Balance - v_annual_fee
    WHERE AccountID = rec.AccountID;
  END LOOP;
  COMMIT;
END;
/

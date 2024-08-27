CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  -- Check if the source account has sufficient balance
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
  END IF;
  
  -- Transfer the funds
  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
  
  COMMIT;
  
EXCEPTION
  WHEN OTHERS THEN
    -- Rollback in case of an error
    ROLLBACK;
    -- Log the error message
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

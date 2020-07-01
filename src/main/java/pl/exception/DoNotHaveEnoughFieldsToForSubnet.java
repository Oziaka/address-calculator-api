package pl.exception;

public class DoNotHaveEnoughFieldsToForSubnet extends RuntimeException {
  public DoNotHaveEnoughFieldsToForSubnet () {
    super("Do not have enough fields for subnet");
  }
}

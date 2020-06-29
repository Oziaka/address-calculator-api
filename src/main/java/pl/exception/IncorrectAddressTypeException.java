package pl.exception;

public class IncorrectAddressTypeException extends RuntimeException {
  public IncorrectAddressTypeException () {
    super("Incorrect address type");
  }
}

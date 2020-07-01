package pl.exception;

public class UndefinedTypeException extends RuntimeException {
  public UndefinedTypeException () {
    super("Undefined type");
  }
}

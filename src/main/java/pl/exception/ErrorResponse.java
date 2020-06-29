package pl.exception;

import java.util.List;
import java.util.Map;

public class ErrorResponse {
  private Map<String, List<String>> errorMap;

  public ErrorResponse (Map<String, List<String>> errorMap) {
    this.errorMap = errorMap;
  }

  public Map<String, List<String>> getErrors () {
    return errorMap;
  }
}

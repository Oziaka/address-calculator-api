package pl.validator.network_mask;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberOfOnesNetworkMaskValidator implements ConstraintValidator<NumberOfOnesNetworkMask, String> {
  public void initialize (NumberOfOnesNetworkMask constraint) {
  }

  public boolean isValid (String obj, ConstraintValidatorContext context) {
    try {
      int numberOfOnes = Integer.parseInt(obj);
      if(numberOfOnes < 0 || numberOfOnes > 24) return false;
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}

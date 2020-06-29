package pl.validator.network_mask;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BinaryNetworkMaskValidator implements ConstraintValidator<BinaryNetworkMask, String> {
  public void initialize (BinaryNetworkMask constraint) {
  }

  public boolean isValid (String obj, ConstraintValidatorContext context) {
    return false;
  }
}

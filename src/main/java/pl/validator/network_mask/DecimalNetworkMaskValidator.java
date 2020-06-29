package pl.validator.network_mask;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalNetworkMaskValidator implements ConstraintValidator<DecimalNetworkMask, String> {
  public void initialize (DecimalNetworkMask constraint) {
  }

  public boolean isValid (String obj, ConstraintValidatorContext context) {
    return false;
  }
}

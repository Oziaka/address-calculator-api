package pl.validator.address;

import pl.tool.ValidatorTool;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalAddressValidator implements ConstraintValidator<DecimalAddress, String> {
  @Override
  public void initialize (DecimalAddress constraintAnnotation) {

  }

  @Override
  public boolean isValid (String obj, ConstraintValidatorContext context) {
    return ValidatorTool.validDecimalAddress(obj);
  }
}

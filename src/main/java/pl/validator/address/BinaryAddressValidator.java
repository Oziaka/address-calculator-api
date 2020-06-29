package pl.validator.address;

import pl.tool.ValidatorTool;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BinaryAddressValidator implements ConstraintValidator<BinaryAddress, String> {
  public void initialize (BinaryAddress constraint) {
  }

  public boolean isValid (String obj, ConstraintValidatorContext context) {
    return ValidatorTool.validBinaryAddress(obj);
  }
}

package pl.validator.address;

import pl.address.Type;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressTypeValidator implements ConstraintValidator<AddressType, Type> {
  public void initialize (AddressType constraint) {
  }

  public boolean isValid (Type obj, ConstraintValidatorContext context) {
    return obj.equals(Type.BINARY) || obj.equals(Type.DECIMAL);
  }
}

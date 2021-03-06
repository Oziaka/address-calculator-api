package pl.validator.address;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = AddressTypeValidator.class)
@Retention(RUNTIME)
public @interface AddressType {
  String message () default "{error.address_type}";

  Class<?>[] groups () default {};

  Class<? extends Payload>[] payload () default {};
}

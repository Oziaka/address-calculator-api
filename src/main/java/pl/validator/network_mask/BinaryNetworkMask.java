package pl.validator.network_mask;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(ElementType.PARAMETER)
@Constraint(validatedBy = BinaryNetworkMaskValidator.class)
@Retention(RUNTIME)
public @interface BinaryNetworkMask {
  String message ();

  Class<?>[] groups () default {};

  Class<? extends Payload>[] payload () default {};
}
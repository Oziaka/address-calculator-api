package pl.validator.network_mask;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(ElementType.TYPE)
@Constraint(validatedBy = NetworkMaskValidator.class)
@Retention(RUNTIME)
public @interface NetworkMask {
  String message () default "{error.network_mask}";

  Class<?>[] groups () default {};

  Class<? extends Payload>[] payload () default {};
}

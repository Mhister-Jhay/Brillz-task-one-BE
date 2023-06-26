package org.jhay.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String message() default "Date of Birth must be 16 years or greater";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


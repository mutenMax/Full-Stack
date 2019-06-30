package com.infinity.application.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CreditCardValidator.class)
@Documented
public @interface CreditCard {

    String message() default "Invalid Credit Card.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
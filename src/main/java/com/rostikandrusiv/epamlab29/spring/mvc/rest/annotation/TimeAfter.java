package com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.handler.TimeAfterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= TimeAfterValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeAfter {
    String message() default "must be after {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value();
}

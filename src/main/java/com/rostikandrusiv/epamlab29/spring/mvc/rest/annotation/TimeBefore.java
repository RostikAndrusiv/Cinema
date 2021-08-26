package com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.handler.TimeAfterValidator;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.handler.TimeBeforeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= TimeBeforeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeBefore {
    String message() default "must be before {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value();
}

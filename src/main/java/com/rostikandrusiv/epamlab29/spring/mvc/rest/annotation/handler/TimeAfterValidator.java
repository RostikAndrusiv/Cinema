package com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.handler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeAfter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class TimeAfterValidator implements ConstraintValidator<TimeAfter, LocalTime> {

    private LocalTime time;

    public void initialize(TimeAfter annotation) {
        time = LocalTime.parse(annotation.value());
    }

    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            if (!value.isAfter(time.minusNanos(1))) {
                valid = false;
            }
        }
        return valid;
    }
}

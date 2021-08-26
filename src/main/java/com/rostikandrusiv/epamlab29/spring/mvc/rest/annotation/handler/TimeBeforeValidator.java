package com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.handler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeBefore;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class TimeBeforeValidator implements ConstraintValidator<TimeBefore, LocalTime> {

    private LocalTime time;

    public void initialize(TimeBefore annotation) {
        time = LocalTime.parse(annotation.value());
    }

    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            if (!value.isBefore(time.plusNanos(1))) {
                valid = false;
            }
        }
        return valid;
    }
}
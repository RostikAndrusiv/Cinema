package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class SessionNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Session is not found!";

    public SessionNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}

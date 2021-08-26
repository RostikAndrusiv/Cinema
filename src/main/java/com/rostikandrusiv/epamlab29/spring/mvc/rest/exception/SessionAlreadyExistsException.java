package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class SessionAlreadyExistsException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Session at this time already already exists!";

    public SessionAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}


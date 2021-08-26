package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class EmailAlreadyUsedException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Email is already used by someone!";

    public EmailAlreadyUsedException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}

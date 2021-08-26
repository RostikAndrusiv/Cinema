package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class LoginAlreadyUsedException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "User with this login already exists!";

    public LoginAlreadyUsedException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}

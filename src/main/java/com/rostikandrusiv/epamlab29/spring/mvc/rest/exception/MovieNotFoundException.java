package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class MovieNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Movie with this name is not found!";

    public MovieNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
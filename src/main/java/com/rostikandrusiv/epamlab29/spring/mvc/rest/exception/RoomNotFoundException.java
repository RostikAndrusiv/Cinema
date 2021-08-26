package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class RoomNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Room with this name is not found!";

    public RoomNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
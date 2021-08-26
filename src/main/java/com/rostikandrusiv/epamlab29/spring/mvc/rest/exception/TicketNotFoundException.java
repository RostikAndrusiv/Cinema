package com.rostikandrusiv.epamlab29.spring.mvc.rest.exception;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;

public class TicketNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Ticket is not found!";

    public TicketNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}

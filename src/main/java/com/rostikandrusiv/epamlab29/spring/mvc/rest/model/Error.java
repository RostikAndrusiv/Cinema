package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import java.time.LocalDateTime;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

    private String message;

    private ErrorType errorType;

    private LocalDateTime timeStamp;

}

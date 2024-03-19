package com.demov2.apisablon.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ApiException class is a custom exception class for handling exceptions.
 * It is used to return a response with a specific status code and body.
 */
@Getter
public final class ApiException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ApiException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}


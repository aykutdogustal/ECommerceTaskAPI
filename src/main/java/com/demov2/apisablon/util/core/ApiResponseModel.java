package com.demov2.apisablon.util.core;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ApiResponseModel {
    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    private String message;
    private boolean hasError;
    private Object data;
    private List<ValidationError> validationErrors;
}

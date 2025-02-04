package com.ecom.sb_ecom_application.exception;

public class APIException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public APIException(String message) {
        super(message);
    }
}

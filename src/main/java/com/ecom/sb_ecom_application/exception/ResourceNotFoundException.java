package com.ecom.sb_ecom_application.exception;

public class ResourceNotFoundException extends RuntimeException {
    String fieldName;
    String resoureceName;
    long fieldId;
    public ResourceNotFoundException(String resoureceName, String fieldName, long fieldId) {
        super("Resource not found " + resoureceName + " with " + fieldName + " with field Id : " + fieldId);
        this.fieldName = fieldName;
        this.resoureceName = resoureceName;
        this.fieldId = fieldId;
    }
    public ResourceNotFoundException() {
    }
}

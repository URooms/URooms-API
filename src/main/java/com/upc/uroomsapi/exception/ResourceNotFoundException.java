package com.upc.uroomsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase para manejar excepciones (errores) de tipo NOT FOUND (404)
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String ResourceName;
    private String FieldName;
    private long FieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s with %s='%s' not found", resourceName, fieldName, fieldValue));
        ResourceName = resourceName;
        FieldName = fieldName;
        FieldValue = fieldValue;
    }

    public String getResourceName() {
        return ResourceName;
    }
    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    public String getFieldName() {
        return FieldName;
    }
    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public long getFieldValue() {
        return FieldValue;
    }
    public void setFieldValue(long fieldValue) {
        FieldValue = fieldValue;
    }
}

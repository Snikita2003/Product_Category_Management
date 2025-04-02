package com.prod.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    private Long resourceId;
    private String message;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
        this.message = message;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public String getMessage() {
        return message;
    }
}


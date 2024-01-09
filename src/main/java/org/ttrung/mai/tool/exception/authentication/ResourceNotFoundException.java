package org.ttrung.mai.tool.exception.authentication;

import org.ttrung.mai.tool.exception.GeneralException;

public class ResourceNotFoundException extends GeneralException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Class<?> clazz, Object id) {
        super("0004", 404, "Resource " + clazz + " with ID " + id + " is not found");
    }

    public ResourceNotFoundException(String domain, Object id) {
        super("0004", 404, "Resource " + domain + " with ID " + id + " is not found");
    }

}

package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.DuplicateCommandContainerException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException
 */
public class EapDuplicateCommandContainerExceptionHandler extends ExceptionHandler<DuplicateCommandContainerException> {
    public EapDuplicateCommandContainerExceptionHandler() {
        super(DuplicateCommandContainerException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

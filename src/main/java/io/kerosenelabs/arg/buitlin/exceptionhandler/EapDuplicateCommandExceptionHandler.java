package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.DuplicateCommandException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapDuplicateCommandException
 */
public class EapDuplicateCommandExceptionHandler extends ExceptionHandler<DuplicateCommandException> {
    public EapDuplicateCommandExceptionHandler() {
        super(DuplicateCommandException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

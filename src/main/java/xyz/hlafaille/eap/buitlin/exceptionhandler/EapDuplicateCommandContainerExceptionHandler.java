package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException;
import xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException;
import xyz.hlafaille.eap.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException
 */
public class EapDuplicateCommandContainerExceptionHandler extends ExceptionHandler<EapDuplicateCommandContainerException> {
    public EapDuplicateCommandContainerExceptionHandler() {
        super(EapDuplicateCommandContainerException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

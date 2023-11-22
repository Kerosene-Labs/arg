package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException;
import xyz.hlafaille.eap.exception.EapDuplicateCommandException;
import xyz.hlafaille.eap.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapDuplicateCommandException
 */
public class EapDuplicateCommandExceptionHandler extends ExceptionHandler<EapDuplicateCommandException> {
    public EapDuplicateCommandExceptionHandler() {
        super(EapDuplicateCommandException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

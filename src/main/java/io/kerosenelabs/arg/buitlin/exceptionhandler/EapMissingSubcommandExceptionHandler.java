package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.EapMissingSubcommandException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapMissingSubcommandException
 */
public class EapMissingSubcommandExceptionHandler extends ExceptionHandler<EapMissingSubcommandException> {
    public EapMissingSubcommandExceptionHandler() {
        super(EapMissingSubcommandException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

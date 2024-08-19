package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.CommandNotFoundException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapCommandNotFoundExceptionHandler
 */
public class EapCommandNotFoundExceptionHandler extends ExceptionHandler<CommandNotFoundException> {
    public EapCommandNotFoundExceptionHandler() {
        super(CommandNotFoundException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

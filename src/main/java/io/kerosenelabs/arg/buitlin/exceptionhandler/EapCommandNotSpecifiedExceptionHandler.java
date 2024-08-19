package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.CommandNotSpecifiedException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException
 */
public class EapCommandNotSpecifiedExceptionHandler extends ExceptionHandler<CommandNotSpecifiedException> {
    public EapCommandNotSpecifiedExceptionHandler() {
        super(CommandNotSpecifiedException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException;
import xyz.hlafaille.eap.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException
 */
public class EapCommandModifierNotFoundExceptionHandler extends ExceptionHandler<EapCommandNotSpecifiedException> {
    public EapCommandModifierNotFoundExceptionHandler() {
        super(EapCommandNotSpecifiedException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}

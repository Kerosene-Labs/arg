package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException
 */
public class EapCommandModifierNotFoundExceptionHandler extends ExceptionHandler<EapCommandNotSpecifiedException> {
    public EapCommandModifierNotFoundExceptionHandler() {
        super(EapCommandNotSpecifiedException.class);
    }

    @Override
    public void execute(Exception exception) {
        System.out.println("HANDLED %s".formatted(exception.getClass().getName()));
    }
}

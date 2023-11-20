package xyz.hlafaille.eap;

abstract class ExceptionHandler {
    public ExceptionHandler(Class<Exception> exceptionClass) {

    }

    abstract void execute(Exception exception);
}

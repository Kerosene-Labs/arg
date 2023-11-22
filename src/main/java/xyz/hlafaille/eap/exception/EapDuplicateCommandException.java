package xyz.hlafaille.eap.exception;

public class EapDuplicateCommandException extends Exception{
    public EapDuplicateCommandException() {
        super("Duplicate commands are not allowed");
    }
}

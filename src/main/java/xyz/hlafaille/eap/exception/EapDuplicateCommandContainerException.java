package xyz.hlafaille.eap.exception;

public class EapDuplicateCommandContainerException extends Exception{
    public EapDuplicateCommandContainerException() {
        super("Duplicates under command containers are not allowed");
    }
}

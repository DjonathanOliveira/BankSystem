package Entities.Exceptions;

public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}

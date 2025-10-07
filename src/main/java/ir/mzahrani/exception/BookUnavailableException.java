package ir.mzahrani.exception;

public class BookUnavailableException extends RuntimeException {
    public BookUnavailableException() {
        super("Book is not available. You've been added to the waiting list.");
    }
}

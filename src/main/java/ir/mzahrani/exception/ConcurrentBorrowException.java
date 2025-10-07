package ir.mzahrani.exception;

public class ConcurrentBorrowException extends RuntimeException {
    public ConcurrentBorrowException() {
        super("Concurrent request detected. Try again later.");
    }
}

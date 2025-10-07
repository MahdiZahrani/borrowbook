package ir.mzahrani.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance to borrow a book.");
    }
}

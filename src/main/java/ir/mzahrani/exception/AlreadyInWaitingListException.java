package ir.mzahrani.exception;


public class AlreadyInWaitingListException extends RuntimeException {
    public AlreadyInWaitingListException() {
        super("You are already in the waiting list for this book.");
    }
}
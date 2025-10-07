package ir.mzahrani.exception;

import ir.mzahrani.entity.ErrorDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorDetails> handleAuthenticationException(AuthenticationException ex, HttpServletRequest request) {
        return createErrorResponse(new Exception("Invalid username or password"),request,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex, HttpServletRequest request) {
        logger.error("Unexpected error occurred: ", ex);
        return  createErrorResponse(ex,request,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            BookNotFoundException.class,
            MemberNotFoundException.class,
            InsufficientBalanceException.class,
            BookUnavailableException.class,
            AlreadyInWaitingListException.class,
            ConcurrentBorrowException.class
    })
    public ResponseEntity<ErrorDetails> handleBusinessExceptions(Exception ex, HttpServletRequest request) {
        return createErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDetails> createErrorResponse(
            Exception e,
            HttpServletRequest request,
            HttpStatus status){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(status.value());
        errorDetails.setErrorMessage(e.getMessage());
        errorDetails.setPath(request.getRequestURI());
        errorDetails.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, status);
    }



}
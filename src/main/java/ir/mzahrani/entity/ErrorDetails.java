package ir.mzahrani.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private int errorCode;
    private String errorMessage;
    private String path;
    private LocalDateTime timestamp;
}

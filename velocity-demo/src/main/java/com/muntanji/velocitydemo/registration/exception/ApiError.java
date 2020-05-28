package com.muntanji.velocitydemo.registration.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp=LocalDateTime.now();
    private String message;
    private HttpStatus status;
    private String error;
    private List<String> errors;

    public ApiError( String message , HttpStatus status , String error ) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public ApiError( String message , HttpStatus status , List<String> errors ) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }
}

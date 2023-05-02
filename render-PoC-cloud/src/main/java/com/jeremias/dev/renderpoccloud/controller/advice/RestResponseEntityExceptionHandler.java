package com.jeremias.dev.renderpoccloud.controller.advice;

import com.jeremias.dev.renderpoccloud.model.exception.TransactionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
@RestControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler({TransactionException.class, IllegalArgumentException.class})
    protected ResponseEntity<Object> handleBadRequestException(final Exception ex, final WebRequest request) {
        return handleExceptionInternal(ex,
                new ErrorResponse(LocalDateTime.now(), BAD_REQUEST.getReasonPhrase(), ex.getMessage()),
                new HttpHeaders(), BAD_REQUEST, request);
    }
}

package com.jeremias.dev.renderpoccloud.controller.advice;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorResponse implements Serializable {
    private LocalDateTime dateTime;
    private String httpStatus;
    private String message;

    private static final long serialVersionUID = -8478801551741466606L;

    public ErrorResponse(LocalDateTime dateTime, String httpStatus, String message) {
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

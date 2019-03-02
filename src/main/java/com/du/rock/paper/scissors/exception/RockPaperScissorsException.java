package com.du.rock.paper.scissors.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RockPaperScissorsException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public RockPaperScissorsException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public RockPaperScissorsException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }
}

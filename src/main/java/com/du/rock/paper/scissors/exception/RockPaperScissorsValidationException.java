package com.du.rock.paper.scissors.exception;

import org.springframework.http.HttpStatus;

public class RockPaperScissorsValidationException extends RockPaperScissorsException {

    public RockPaperScissorsValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

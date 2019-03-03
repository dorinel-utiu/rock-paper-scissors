package com.du.rock.paper.scissors.exception;

import org.springframework.http.HttpStatus;

public class GameNotFoundException extends RockPaperScissorsException {

    public GameNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

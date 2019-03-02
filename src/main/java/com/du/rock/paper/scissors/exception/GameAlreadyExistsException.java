package com.du.rock.paper.scissors.exception;

import org.springframework.http.HttpStatus;

public class GameAlreadyExistsException extends RockPaperScissorsException {

    public GameAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}

package com.du.rock.paper.scissors.model;

import com.du.rock.paper.scissors.exception.RockPaperScissorsValidationException;

public enum RockPaperScissorsType {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private String value;

    RockPaperScissorsType(String value) {
        this.value = value;
    }

    public static RockPaperScissorsType getRockPaperScissors(String value) {
        for (RockPaperScissorsType rockPaperScissors: RockPaperScissorsType.values()) {
            if (rockPaperScissors.value.equalsIgnoreCase(value)) return rockPaperScissors;
        }

        throw new RockPaperScissorsValidationException("User option not recognized");
    }

    public String getValue() {
        return value;
    }
}

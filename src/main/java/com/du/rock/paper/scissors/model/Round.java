package com.du.rock.paper.scissors.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.du.rock.paper.scissors.model.RoundResultLabel.*;

@EqualsAndHashCode
@ToString
public class Round {

    @Getter
    @Setter
    private RockPaperScissorsType player1Option;
    @Getter
    @Setter
    private RockPaperScissorsType player2Option;
    @Getter
    @Setter
    private String roundResult;

    public Round(RockPaperScissorsType player1Option, RockPaperScissorsType player2Option) {
        this.player1Option = player1Option;
        this.player2Option = player2Option;
        this.roundResult = getRoundResult(player1Option, player2Option);
    }

    private String getRoundResult(RockPaperScissorsType player1Option, RockPaperScissorsType player2Option) {
        if (player1Option == player2Option) {
            return DRAW;
        }

        if (player1Option == RockPaperScissorsType.ROCK) {
            if (player2Option == RockPaperScissorsType.PAPER) {
                return PLAYER_2_WINS;
            }

            if (player2Option == RockPaperScissorsType.SCISSORS) {
                return PLAYER_1_WINS;
            }
        }

        if (player1Option == RockPaperScissorsType.PAPER) {
            if (player2Option == RockPaperScissorsType.ROCK) {
                return PLAYER_1_WINS;
            }

            if (player2Option == RockPaperScissorsType.SCISSORS) {
                return PLAYER_2_WINS;
            }
        }

        if (player1Option == RockPaperScissorsType.SCISSORS) {
            if (player2Option == RockPaperScissorsType.PAPER) {
                return PLAYER_1_WINS;
            }

            if (player2Option == RockPaperScissorsType.ROCK) {
                return PLAYER_2_WINS;
            }
        }

        return DRAW;
    }

}

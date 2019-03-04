package com.du.rock.paper.scissors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OverAllGameStatus {
    int totalRounds;
    int playerOneWins;
    int playerTwoWins;
    int totalDraws;
}

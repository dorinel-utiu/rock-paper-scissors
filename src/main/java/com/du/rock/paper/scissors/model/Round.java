package com.du.rock.paper.scissors.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Round {

    private RockPaperScissorsType user1Option;
    private RockPaperScissorsType user2Option;
    private String gameResult;
}

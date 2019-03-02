package com.du.rock.paper.scissors.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Game {

    private String id;
    private List<Round> rounds;

    public Game(String id) {
        this.id = id;
        rounds = new ArrayList<>();
    }
}

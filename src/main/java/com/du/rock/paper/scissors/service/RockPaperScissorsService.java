package com.du.rock.paper.scissors.service;

import com.du.rock.paper.scissors.exception.GameAlreadyExistsException;
import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.storage.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsService {

    private String player1 = "Player1";
    private String player2 = "Player2";
    private String wins = "wins";
    private String draw = "draw";

    private final GameRepository gameRepository;

    @Autowired
    public RockPaperScissorsService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void createGame(String gameId) {
        if (gameRepository.getGame(gameId) == null) {
            Game game = new Game(gameId);
            gameRepository.addGame(game);
        } else {
            throw new GameAlreadyExistsException("Game with " + gameId + " already exists");
        }
    }
}

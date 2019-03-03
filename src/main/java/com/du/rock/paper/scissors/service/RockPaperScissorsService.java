package com.du.rock.paper.scissors.service;

import com.du.rock.paper.scissors.exception.GameAlreadyExistsException;
import com.du.rock.paper.scissors.exception.GameNotFoundException;
import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.model.RockPaperScissorsType;
import com.du.rock.paper.scissors.model.Round;
import com.du.rock.paper.scissors.storage.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsService {

    private RockPaperScissorsType PLAYER_2_OPTION = RockPaperScissorsType.ROCK;

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

    public void userOption(String gameId, String option) {
        Game game = validateAndReturnIfGameExists(gameId);

        RockPaperScissorsType player1Option = RockPaperScissorsType.getRockPaperScissors(option);

        Round round = new Round(player1Option, PLAYER_2_OPTION);
        game.addRound(round);
        gameRepository.updateGame(game);
    }

    private Game validateAndReturnIfGameExists(String gameId) {
        Game game = gameRepository.getGame(gameId);
        if (game == null) {
            throw new GameNotFoundException("Game with " + gameId + " does not exist");
        }
        return game;
    }

    public Game getGameStatus(String gameId) {
        Game game = validateAndReturnIfGameExists(gameId);
        return gameRepository.getGame(game.getId());
    }


}

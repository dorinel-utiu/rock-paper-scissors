package com.du.rock.paper.scissors.storage;

import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.model.OverAllGameStatus;
import com.du.rock.paper.scissors.model.RoundResultLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GameRepository {

    private Logger logger = LoggerFactory.getLogger(GameRepository.class);

    private Map<String, Game> gameStorage;

    public GameRepository() {
        gameStorage = new ConcurrentHashMap<>();
    }

    public void addGame(Game game) {
        logger.info("Add game: " + game);
        gameStorage.put(game.getId(), game);
    }

    public Game getGame(String id) {
        logger.info("Get game with id" + id);
        return gameStorage.get(id);
    }

    public void updateGame(Game game) {
        logger.info("Update game: " + game);
        gameStorage.put(game.getId(), game);
    }

    public OverAllGameStatus getGameOverAllStatus() {
        int totalRounds = 0;
        int playerOneWins = 0;
        int playerTwoWins = 0;
        int totalDraws = 0;
        for(Game game: gameStorage.values()) {
            totalRounds += game.getRounds().size();
            playerOneWins += game.getRounds().stream()
                    .filter(round -> round.getRoundResult().equalsIgnoreCase(RoundResultLabel.PLAYER_1_WINS))
                    .count();
            playerTwoWins += game.getRounds().stream()
                    .filter(round -> round.getRoundResult().equalsIgnoreCase(RoundResultLabel.PLAYER_2_WINS))
                    .count();
            totalDraws += game.getRounds().stream()
                    .filter(round -> round.getRoundResult().equalsIgnoreCase(RoundResultLabel.DRAW))
                    .count();

        }
        OverAllGameStatus overAllGameStatus = new OverAllGameStatus(totalRounds, playerOneWins, playerTwoWins, totalDraws);
        logger.info("OverAll game : " + overAllGameStatus);
        return overAllGameStatus;


    }
}

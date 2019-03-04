package com.du.rock.paper.scissors.storage;

import com.du.rock.paper.scissors.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameRepository {

    private Logger logger = LoggerFactory.getLogger(GameRepository.class);

    private Map<String, Game> gameStorage;

    public GameRepository() {
        gameStorage = new HashMap<>();
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
}

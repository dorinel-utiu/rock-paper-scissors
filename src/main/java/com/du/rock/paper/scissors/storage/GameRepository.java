package com.du.rock.paper.scissors.storage;

import com.du.rock.paper.scissors.model.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameRepository {

    private Map<String, Game> gameStorage;

    public GameRepository() {
        gameStorage = new HashMap<>();
    }

    public void addGame(Game game) {
        gameStorage.put(game.getId(), game);
    }

    public Game getGame(String id) {
        return gameStorage.get(id);
    }

    public void updateGame(Game game) {
        gameStorage.put(game.getId(), game);
    }
}

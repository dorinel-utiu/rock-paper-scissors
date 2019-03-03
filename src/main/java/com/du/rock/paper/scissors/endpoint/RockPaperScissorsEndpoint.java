package com.du.rock.paper.scissors.endpoint;

import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.service.RockPaperScissorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class RockPaperScissorsEndpoint {

    private final RockPaperScissorsService service;

    @Autowired
    public RockPaperScissorsEndpoint(RockPaperScissorsService service) {
        this.service = service;
    }

    @PostMapping("/game-start/{gameId}")
    public ResponseEntity<Void> gameStart(@PathVariable String gameId) {
        service.createGame(gameId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/user-option/{gameId}/{option}")
    public ResponseEntity<Void> userOption(@PathVariable String gameId, @PathVariable String option) {
        service.userOption(gameId, option);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/game-status/{gameId}")
    public ResponseEntity<Game> gameStatus(@PathVariable String gameId) {
        Game game = service.getGameStatus(gameId);
        if (game.getRounds().size() == 0) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

}

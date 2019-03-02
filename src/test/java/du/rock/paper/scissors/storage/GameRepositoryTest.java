package du.rock.paper.scissors.storage;

import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.storage.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameRepositoryTest {

    @InjectMocks
    private GameRepository gameRepository;

    @Test
    public void test_whenPutANewGame_ShouldBeSuccessful() {
        Game game = new Game("gameId");
        gameRepository.addGame(game);

        assertEquals(game, gameRepository.getGame("gameId"));
    }
}

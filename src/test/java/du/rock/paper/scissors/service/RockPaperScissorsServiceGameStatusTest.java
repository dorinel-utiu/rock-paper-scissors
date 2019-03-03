package du.rock.paper.scissors.service;

import com.du.rock.paper.scissors.exception.GameNotFoundException;
import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.service.RockPaperScissorsService;
import com.du.rock.paper.scissors.storage.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsServiceGameStatusTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private RockPaperScissorsService service;

    @Test
    public void test_WhenGameExists_ShouldBeSuccessful() {
        String gameId = "gameId";
        Game game = mock(Game.class);
        when(gameRepository.getGame(gameId)).thenReturn(game);
        when(game.getId()).thenReturn(gameId);

        service.getGameStatus(gameId);

        verify(gameRepository, times(2)).getGame(eq(gameId));
    }

    @Test(expected = GameNotFoundException.class)
    public void test_WhenGameNotExists_ShouldFailWithGameNotFoundException() {
        String gameId = "gameId";
        when(gameRepository.getGame(gameId)).thenReturn(null);

        service.getGameStatus(gameId);
    }

}

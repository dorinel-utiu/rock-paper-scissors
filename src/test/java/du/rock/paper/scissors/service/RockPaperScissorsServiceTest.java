package du.rock.paper.scissors.service;

import com.du.rock.paper.scissors.exception.GameAlreadyExistsException;
import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.service.RockPaperScissorsService;
import com.du.rock.paper.scissors.storage.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private RockPaperScissorsService service;

    @Test
    public void test_WhenGameNotExists_ShouldBeCreatedANewGameSuccessfully() {
        String gameId = "gameId";
        when(gameRepository.getGame(gameId)).thenReturn(null);
        doNothing().when(gameRepository).addGame(any(Game.class));

        service.createGame(gameId);
        verify(gameRepository).getGame(eq(gameId));
        verify(gameRepository).addGame(any(Game.class));
    }


    @Test(expected = GameAlreadyExistsException.class)
    public void test_WhenGameExists_ShouldFailWithGameAlreadyExistsException() {
        String gameId = "gameId";
        when(gameRepository.getGame(gameId)).thenReturn(new Game(gameId));

        service.createGame(gameId);
    }
}

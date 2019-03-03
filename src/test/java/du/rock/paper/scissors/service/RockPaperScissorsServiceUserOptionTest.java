package du.rock.paper.scissors.service;

import com.du.rock.paper.scissors.exception.GameNotFoundException;
import com.du.rock.paper.scissors.exception.RockPaperScissorsValidationException;
import com.du.rock.paper.scissors.model.Game;
import com.du.rock.paper.scissors.model.Round;
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
public class RockPaperScissorsServiceUserOptionTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private RockPaperScissorsService service;

    @Test
    public void test_WhenGameExistsAndUserOptionIsValid_ShouldBeSuccessful() {
        String gameId = "gameId";
        Game game = mock(Game.class);
        when(gameRepository.getGame(gameId)).thenReturn(game);
        doNothing().when(game).addRound(any(Round.class));
        doNothing().when(gameRepository).updateGame(game);

        service.userOption(gameId, "paper");

        verify(game).addRound(any(Round.class));
        verify(gameRepository).getGame(eq(gameId));
        verify(gameRepository).updateGame(eq(game));
    }

    @Test(expected = GameNotFoundException.class)
    public void test_WhenGameNotExists_ShouldFailWithGameNotFoundException() {
        String gameId = "gameId";
        when(gameRepository.getGame(gameId)).thenReturn(null);

        service.userOption(gameId, "paper");
    }

    @Test(expected = RockPaperScissorsValidationException.class)
    public void test_WhenGameExistsAndUserOptionIsNotValid_ShouldFailWithRockPaperScissorsValidationException() {
        String gameId = "gameId";
        Game game = mock(Game.class);
        when(gameRepository.getGame(gameId)).thenReturn(game);

        service.userOption(gameId, "invalidOption");
    }

}

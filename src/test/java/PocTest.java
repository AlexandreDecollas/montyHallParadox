import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PocImplTest {

    @DisplayName("Test presenter show 3 doors with 2 goats and one car")
    @ParameterizedTest(name = "Door number {0} is the winner")
    @ValueSource(ints = {0, 1, 2})
    void TestDoorsPresenter(final Integer mockRandom) {

        Random randomMocked = mock(Random.class);
        when(randomMocked.nextInt(3)).thenReturn(mockRandom);

        TVPresenter presenter = new TVPresenter(randomMocked);

        Door[] doors = presenter.showDoors();

        assertTrue(doors[mockRandom].isCarDoor());
    }

    @Test
    @DisplayName("test candidate makes his choice")
    void TestCandidateMakesChoice() {
        Random randomMocked = mock(Random.class);
        when(randomMocked.nextInt(3)).thenReturn(0);

        Candidate candidate = new Candidate(randomMocked);
        Door[] doors = {new Door(), new Door(), new Door()};

        doors[0].setWinner();

        Door[] notChoosenDoors = candidate.getNotChoosenDoors(doors);

        assertEquals(2, notChoosenDoors.length);
        assertEquals(notChoosenDoors[0], doors[1]);
        assertEquals(notChoosenDoors[1], doors[2]);
    }

    @Test
    @DisplayName("test presenter choose one of the 2 remaining doors")
    void TestPresenterMakesChoice() {
        Random randomMocked = mock(Random.class);
        when(randomMocked.nextInt(2)).thenReturn(0);

        TVPresenter presenter = new TVPresenter(randomMocked);

        Door[] doors = {new Door(), new Door()};
        doors[0].setWinner();

        Door choosenDoor = presenter.getRemainingClosedDoor(doors);

        assertTrue(choosenDoor.equals(doors[0]) || choosenDoor.equals(doors[1]));
    }

    @DisplayName("test presenter does not choose a goat")
    @ParameterizedTest(name = "Door number {0} is the winner")
    @ValueSource(ints = {0, 1})
    void TestPresenterDoNotChooseGoat(final Integer winnerDoorIndex) {
        TVPresenter presenter = new TVPresenter();

        Door[] doors = {new Door(), new Door()};
        doors[winnerDoorIndex].setWinner();

        Door remainingClosedDoor = presenter.getRemainingClosedDoor(doors);

        assertTrue(remainingClosedDoor.isCarDoor());
    }

    @Test
    @DisplayName("test presenter choose randomly in a 2 looser doors choice")
    void TestPresenterChooseARandomDoorIfNoWinnerDoor() {
        Random randomMocked = mock(Random.class);

        TVPresenter presenter = new TVPresenter(randomMocked);
        Door[] doors = {new Door(), new Door()};

        presenter.getRemainingClosedDoor(doors);
        verify(randomMocked).nextInt(2);
    }
}


















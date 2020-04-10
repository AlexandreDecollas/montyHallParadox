import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidateTest {

    @DisplayName("Candidate should get the presenter door if changeDoor strategy is true")
    @ParameterizedTest(name = "Is strategy about change initial door choosen for the new one? {0}")
    @ValueSource(booleans = {true, false})
    void TestCandidateKeepOrChangeDoor(Boolean changeDoorStrategy) {
        Candidate candidate = new Candidate();
        Door[] presentedDoors = {new Door(), new Door(), new Door()};
        Door[] notChoosenDoors = candidate.getNotChoosenDoors(presentedDoors);
        Door presentedRemainingClosedDoor = notChoosenDoors[0];
        Door candidateFinalChoosenDoor = candidate.getFinalChoice(presentedRemainingClosedDoor, changeDoorStrategy);

        assertEquals(candidateFinalChoosenDoor.equals(presentedRemainingClosedDoor), changeDoorStrategy);
    }

}

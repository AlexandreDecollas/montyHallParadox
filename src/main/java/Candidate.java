import java.util.Random;

public class Candidate {
    private final Random random;
    private Door initialDoorChoosen;

    public Candidate(Random random) {
        this.random = random;
    }

    public Candidate() {
        this.random = new Random();
    }

    public Door[] getNotChoosenDoors(Door[] doors) {
        int choice = this.random.nextInt(3);
        this.initialDoorChoosen = doors[choice];
        return new Door[]{doors[(choice + 1) % 3], doors[(choice + 2) % 3]};
    }

    public Door getFinalChoice(Door presentedRemainingClosedDoor, Boolean changeDoorStrategy) {
        if (changeDoorStrategy) {
            return presentedRemainingClosedDoor;
        }
        return this.initialDoorChoosen;
    }
}

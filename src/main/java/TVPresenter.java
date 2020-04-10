import java.util.Random;

public class TVPresenter {

    private final Random random;

    public TVPresenter() {
        this.random = new Random();
    }

    public TVPresenter(Random random) {
        this.random = random;
    }

    public Door[] showDoors() {
        Door[] doors = {new Door(), new Door(), new Door()};
        Integer winnerDoorIndex = this.getRandomWinnerDoorIndex();

        doors[winnerDoorIndex].setWinner();
        return doors;
    }

    // Need this to be able to mock Random
    public Integer getRandomWinnerDoorIndex() {
        return this.random.nextInt(3);
    }

    public Integer getRandomLooserDoorIndex() {
        Integer randomizedIndex = this.random.nextInt(2);
        return randomizedIndex;
    }

    public Door getRemainingClosedDoor(Door[] notChoosenByCandidateDoors) {
        if (!(notChoosenByCandidateDoors[0].isCarDoor() || notChoosenByCandidateDoors[1].isCarDoor())) {
            return notChoosenByCandidateDoors[this.getRandomLooserDoorIndex()];
        }
        return notChoosenByCandidateDoors[0].isCarDoor() ?
                notChoosenByCandidateDoors[0] :
                notChoosenByCandidateDoors[1];
    }
}

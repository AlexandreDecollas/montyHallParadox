public class Poc {
    public static Door runARound(Boolean changeDoor) {
        TVPresenter presenter = new TVPresenter();
        Candidate candidate = new Candidate();

        Door[] initial3doors = presenter.showDoors();
        Door[] notChoosenDoors = candidate.getNotChoosenDoors(initial3doors);
        Door ramainingClosedDoor = presenter.getRemainingClosedDoor(notChoosenDoors);

        return candidate.getFinalChoice(ramainingClosedDoor, changeDoor);
    }

    public static void main(String[] args) {
        Boolean alwaysChooseOtherDoor = args.length > 0 && args[0].equals("change");
        String presentation = "Pure strategy to always choose ";
        presentation += alwaysChooseOtherDoor ? "the other door" : "the initial door";

        System.out.println(presentation);

        int numberIterations = 1000000;
        int winnerCpt = 0;
        int looserCpt = 0;
        for (int i = 0; i < numberIterations; i++) {
            Door door = Poc.runARound(alwaysChooseOtherDoor);
            if (door.isCarDoor()) {
                winnerCpt++;
            } else {
                looserCpt++;
            }
        }
        System.out.print("Winner choice " + winnerCpt * 100 / numberIterations);
        System.out.println("% of the time");
        System.out.print("Loosers choice " + looserCpt * 100 / numberIterations);
        System.out.println("% of the time");
    }
}

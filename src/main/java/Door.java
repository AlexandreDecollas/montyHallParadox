public class Door {
    private Boolean isWinner = false;

    public Boolean isCarDoor() {
        return this.isWinner;
    }

    public void setWinner() {
        isWinner = true;
    }

    @Override
    public String toString() {
        return this.isWinner ? "WIN" : "FAIL";
    }
}

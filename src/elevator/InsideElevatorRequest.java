package elevator;

/**
 * This class process the external request of the user (in side the elevator)
 * the moment when the user enters the elevator, the user can choose the floor number to
 * which he wants to go...
 */
public class InsideElevatorRequest {
    private int dstFloor;

    public InsideElevatorRequest(int dstFloor) {
        this.dstFloor = dstFloor;
    }

    public int getDstFloor() {
        return dstFloor;
    }

    public void setDstFloor(int dstFloor) {
        this.dstFloor = dstFloor;
    }
}

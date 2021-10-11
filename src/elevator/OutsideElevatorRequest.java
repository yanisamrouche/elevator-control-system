package elevator;

/**
 * This class process the external request of the user (out side the elevator)
 * the user can press the UP or DOWN button.
 */
public class OutsideElevatorRequest {
    private Direction directionTo;
    private int srcFloor;

    public OutsideElevatorRequest(Direction directionTo, int srcFloor) {
        this.directionTo = directionTo;
        this.srcFloor = srcFloor;
    }

    public Direction getDirectionTo() {
        return directionTo;
    }

    public void setDirectionTo(Direction directionTo) {
        this.directionTo = directionTo;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }


    @Override
    public String toString() {
        return " l'ascenseur a reçu une demande à l'étage " + srcFloor + " et l'usager veut aller vers - "
                + directionTo;
    }
}

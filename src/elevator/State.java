package elevator;

/**
 * This enum represent the different states of the elevator
 * MOVE : when the elevator is moving up or down
 * STOP : when the elevator stops in a one of the floors
 * STOP_EMERGENCY : the elevator is not in service
 */
public enum State {
    MOVE, STOP, STOP_EMERGENCY;
}

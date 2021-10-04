package elevator;

import java.util.Set;
import java.util.TreeSet;

import static elevator.Direction.*;

/**
 * This class represent the Elevator in general
 */
public class Elevator {
    private int HIGHER_FLOOR = 9;
    private int LOWER_FLOOR = 0;
    private int currentFloor = 0;
    private Direction currentDirection = UP;
    private State currentState = State.STOP;

    /**
     * requests which are being processed
     */
    TreeSet<ElevatorRequest> currentRequests = new TreeSet<>();

    /**
     * saving the up requests
     */
    TreeSet<ElevatorRequest> upRequests = new TreeSet<>();
    /**
     * saving the down requests
     */
    TreeSet<ElevatorRequest> downRequests = new TreeSet<>();



    public void upRequest(ElevatorRequest request) throws InterruptedException {
        int startFloor = currentFloor;
        if(startFloor < request.getOutsideElevatorRequest().getSrcFloor()){
            for(int i = startFloor; i <= request.getOutsideElevatorRequest().getSrcFloor(); i++){
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                currentFloor = i;
            }
        }
        System.out.println("porte ouverte");
        startFloor = currentFloor;
        for (int i=startFloor; i <= request.getInsideElevatorRequest().getDstFloor(); i++){
            Thread.sleep(1000);
            System.out.println("étage : "+i);
            currentFloor = i;
            if(checkNewRequests(request))
                break;
        }

    }

    public void downRequest(ElevatorRequest request) throws InterruptedException {
        int startFloor = currentFloor;
        if(startFloor < request.getOutsideElevatorRequest().getSrcFloor()){
            for (int i = startFloor; i <= request.getOutsideElevatorRequest().getSrcFloor(); i++){
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                currentFloor = i;
            }
        }
        System.out.println("porte ouverte");
        startFloor = currentFloor;
        for (int i=startFloor; i >= request.getInsideElevatorRequest().getDstFloor(); i--){
            Thread.sleep(1000);
            System.out.println("étage : "+i);
            currentFloor = i;
            if(checkNewRequests(request))
                break;
        }
    }

    public boolean checkRequest(){
        return currentRequests.isEmpty() ? false : true;
    }

    public boolean checkNewRequests(ElevatorRequest currentRequest){
        if (checkRequest()){
            if(currentDirection == UP){
                ElevatorRequest elevatorRequest = currentRequests.pollFirst();
                if(elevatorRequest.getInsideElevatorRequest().getDstFloor() < currentRequest.getInsideElevatorRequest().getDstFloor()){
                    currentRequests.add(elevatorRequest);
                    currentRequests.add(currentRequest);
                    return true;
                }
                currentRequests.add(elevatorRequest);
            }

            if(currentDirection == DOWN){
                ElevatorRequest request = currentRequests.pollLast();
                if (request.getInsideElevatorRequest().getDstFloor() > currentRequest.getInsideElevatorRequest().getDstFloor()){
                    currentRequests.add(request);
                    currentRequests.add(currentRequest);
                    return true;
                }
                currentRequests.add(request);
            }
        }
        return false;
    }

    public void addDownRequestsToCurrentRequests(){
        if(!downRequests.isEmpty()){
            currentRequests = downRequests;
            currentDirection = DOWN;
        }else {
            currentState = State.STOP;
        }
    }

    public void addUpRequestsToCurrentRequests(){
        if(!upRequests.isEmpty()){
            currentRequests = upRequests;
            currentDirection = UP;
        }else {
            currentState = State.STOP;
        }
    }


    public void start() throws InterruptedException {
        while (true){
            if(checkRequest()){
                if(currentDirection == UP){
                    ElevatorRequest request = currentRequests.pollFirst();
                    upRequest(request);
                    if(currentRequests.isEmpty())
                        addDownRequestsToCurrentRequests();
                }
                if (currentDirection == DOWN){
                    ElevatorRequest request = currentRequests.pollLast();
                    downRequest(request);
                    if(currentRequests.isEmpty())
                        addUpRequestsToCurrentRequests();
                }
            }else {
                break;
            }
        }
    }

















    /* ==================================================================== */
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Direction goesUp() throws InterruptedException {
        System.out.println(currentFloor);
        while (true){
            Thread.sleep(1000);
                currentFloor++;
                System.out.println(currentFloor);
                if (HIGHER_FLOOR == currentFloor){
                    currentDirection = DOWN;
                    break;
                }

        }
        return UP;
    }

   public Direction goesDown() throws InterruptedException {
       System.out.println(currentFloor);
       while (true) {
               currentFloor--;
               Thread.sleep(1000);
               System.out.println(currentFloor);
               if (LOWER_FLOOR == currentFloor) {
                   currentDirection = UP;
                   break;
               }
       }
        return DOWN;
    }

}

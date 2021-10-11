package elevator;

import GUI.IHM;

import java.util.Set;
import java.util.TreeSet;

import static elevator.Direction.*;

/**
 * This class represent the Elevator in general
 */
public class Elevator {

    private int HIGHER_FLOOR = 9;
    private int LOWER_FLOOR = 0;
    private static int currentFloor = 0;
    private static Direction currentDirection = UP;
    private static State currentState = State.NONE;


    /**
     * requests which are being processed
     */
    static TreeSet<ElevatorRequest> currentRequests = new TreeSet<>();

    /**
     * saving the up requests
     */
    static TreeSet<ElevatorRequest> upRequests = new TreeSet<>();
    /**
     * saving the down requests
     */
    static TreeSet<ElevatorRequest> downRequests = new TreeSet<>();



    public void delay(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void upRequest(ElevatorRequest request) throws InterruptedException {
        delay(500);
        int startFloor = currentFloor;
        if(startFloor < request.getOutsideElevatorRequest().getSrcFloor()){
            for(int i = startFloor; i <= request.getOutsideElevatorRequest().getSrcFloor(); i++){
                if(currentState == State.STOP_EMERGENCY) {
                    IHM.getCentreTextArea().append("HS");
                    IHM.getLeftTextArea().setText("HS");
                    IHM.getRightTextArea().setText("HS");
                    break;
                }
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                IHM.getCentreTextArea().append("étage : "+i+"\n");
                IHM.getLeftTextArea().setText(" [ "+i+" ] ");
                IHM.getRightTextArea().setText(" [ "+i+" ] ");
                currentFloor = i;
            }
        }else if(startFloor > request.getOutsideElevatorRequest().getSrcFloor())
        {
            for(int i = startFloor; i >= request.getOutsideElevatorRequest().getSrcFloor(); i--)
            {
                if(currentState == State.STOP_EMERGENCY) {
                    IHM.getCentreTextArea().append("HS");
                    IHM.getLeftTextArea().setText("HS");
                    IHM.getRightTextArea().setText("HS");
                    break;
                }
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                IHM.getCentreTextArea().append("étage : "+i+"\n");
                IHM.getLeftTextArea().setText(" [ "+i+" ] ");
                IHM.getRightTextArea().setText(" [ "+i+" ] ");
                currentFloor = i;
            }
        }
        IHM.getCentreTextArea().setText("");
        System.out.println("porte ouverte XxX");
        IHM.getCentreTextArea().append("--Ouverture des portes-- \n");
        startFloor = currentFloor;
        IHM.getCentreTextArea().append("étage : "+startFloor+"\n");
        IHM.getCentreTextArea().append("--Fermeture des portes-- \n");
        for (int i=startFloor; i <= request.getInsideElevatorRequest().getDstFloor(); i++){
            if(currentState == State.STOP_EMERGENCY) {
                IHM.getCentreTextArea().append("HS");
                IHM.getLeftTextArea().setText("HS");
                IHM.getRightTextArea().setText("HS");
                break;
            }
            Thread.sleep(1000);

            System.out.println("étage : "+i);
            IHM.getCentreTextArea().append("étage : "+i+"\n");
            IHM.getLeftTextArea().setText(" [ "+i+" ] ");
            IHM.getRightTextArea().setText(" [ "+i+" ] ");
            currentFloor = i;

            if(currentFloor == request.getInsideElevatorRequest().getDstFloor())
                IHM.getCentreTextArea().append("--Ouverture des portes-- \n");

            if(checkNewRequests(request))
                break;
        }



    }

    public void downRequest(ElevatorRequest request) throws InterruptedException {
        delay(500);
        int startFloor = currentFloor;

        if(startFloor < request.getOutsideElevatorRequest().getSrcFloor()){
            for (int i = startFloor; i <= request.getOutsideElevatorRequest().getSrcFloor(); i++){
                if(currentState == State.STOP_EMERGENCY) {
                    IHM.getCentreTextArea().append("HS");
                    IHM.getLeftTextArea().setText("HS");
                    IHM.getRightTextArea().setText("HS");
                    break;
                }
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                IHM.getCentreTextArea().append("étage : "+i+"\n");
                IHM.getLeftTextArea().setText(" [ "+i+" ] ");
                IHM.getRightTextArea().setText(" [ "+i+" ] ");
                currentFloor = i;
            }
        }else if(startFloor > request.getOutsideElevatorRequest().getSrcFloor()){
            for (int i = startFloor; i >= request.getOutsideElevatorRequest().getSrcFloor(); i--){
                if(currentState == State.STOP_EMERGENCY) {
                    IHM.getCentreTextArea().append("HS");
                    IHM.getLeftTextArea().setText("HS");
                    IHM.getRightTextArea().setText("HS");
                    break;
                }
                Thread.sleep(1000);
                System.out.println("étage : "+i);
                IHM.getCentreTextArea().append("étage : "+i+"\n");
                IHM.getLeftTextArea().setText(" [ "+i+" ] ");
                IHM.getRightTextArea().setText(" [ "+i+" ] ");
                currentFloor = i;
            }
        }
        IHM.getCentreTextArea().setText("");
        System.out.println("--Ouverture des portes--\n");
        IHM.getCentreTextArea().append("--Ouverture des portes--\n");
        startFloor = currentFloor;
        IHM.getCentreTextArea().append("étage : "+startFloor+"\n");
        IHM.getCentreTextArea().append("--Fermeture des portes-- \n");
        for (int i=startFloor; i >= request.getInsideElevatorRequest().getDstFloor(); i--){
            if(currentState == State.STOP_EMERGENCY) {
                IHM.getCentreTextArea().append("HS");
                IHM.getLeftTextArea().setText("HS");
                IHM.getRightTextArea().setText("HS");
                break;
            }
            Thread.sleep(1000);
            System.out.println("étage : "+i);
            IHM.getCentreTextArea().append("étage : "+i+"\n");
            IHM.getLeftTextArea().setText(" [ "+i+" ] ");
            IHM.getRightTextArea().setText(" [ "+i+" ] ");
            currentFloor = i;
            if(currentFloor == request.getInsideElevatorRequest().getDstFloor())
                IHM.getCentreTextArea().append("--Ouverture des portes-- \n");
            if(checkNewRequests(request))
                break;
        }
    }

    public boolean checkRequest(){

        delay(500);
        if(currentRequests.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean checkNewRequests(ElevatorRequest currentRequest){
        delay(500);
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
        delay(500);
        if(!downRequests.isEmpty()){
            currentRequests = downRequests;
            currentDirection = DOWN;
        }else {
            currentState = State.NONE;
        }
    }

    public void addUpRequestsToCurrentRequests(){
        delay(500);
        if(!upRequests.isEmpty()){
            currentRequests = upRequests;
            currentDirection = UP;
        }else {
            currentState = State.NONE;
        }
    }

    public void addRequest(ElevatorRequest request){
        delay(500);
        if(currentState == State.NONE){
            // check if the elevator is already on the floor on which the user
            // is if yes then we can directly process the destination floor
            if (currentFloor == request.getOutsideElevatorRequest().getSrcFloor()) {
                System.out.println(" la position de la cabine - " + currentFloor + " étage \n déplacement vers  - " + request.getInsideElevatorRequest().getDstFloor() +" étage");
                IHM.getCentreTextArea().append(" la position de la cabine - " + currentFloor + " étage \n déplacement vers  - " + request.getInsideElevatorRequest().getDstFloor() +" étage \n");
            }
            // check if the elevator is already on the floor on which the user
            // is if no then elevator first needs to move to source floor
            else {
                System.out.println("  la position de la cabine -  " + currentFloor + " étage \n déplacement vers  - " + request.getOutsideElevatorRequest().getSrcFloor()+" étage");
                IHM.getCentreTextArea().append(" la position de la cabine - " + currentFloor + " étage \n déplacement vers  - " + request.getOutsideElevatorRequest().getSrcFloor() +" étage "+"\n");
            }
            currentState = State.MOVE;
            currentDirection = request.getOutsideElevatorRequest().getDirectionTo();
            currentRequests.add(request);

        }else if(currentState == State.MOVE){
            if(request.getOutsideElevatorRequest().getDirectionTo() != currentDirection){
                addtoWaitingRequests(request);
            }else if(request.getOutsideElevatorRequest().getDirectionTo() == currentDirection){
                if(currentDirection == UP && request.getInsideElevatorRequest().getDstFloor() < currentFloor){
                    addtoWaitingRequests(request);
                }else if(currentDirection == DOWN && request.getInsideElevatorRequest().getDstFloor() > currentFloor){
                    addtoWaitingRequests(request);
                } else {
                    currentRequests.add(request);
                }
            }
        }

    }

    public void addtoWaitingRequests(ElevatorRequest request){
        delay(500);
        if(request.getOutsideElevatorRequest().getDirectionTo() == Direction.UP){
            upRequests.add(request);
        }else {
            downRequests.add(request);
        }
    }

    public void resetHS(){
        currentFloor = 0;
        currentDirection = UP;
        this.setCurrentState(State.STOP_EMERGENCY);
        currentRequests.clear();
        upRequests.clear();
        downRequests.clear();

    }

    public void startElevator() throws InterruptedException {
        delay(500);
        System.out.println("The Elevator has started functioning");
            System.out.println("-");
            while (true) {
                System.out.println("...");
                if (checkRequest()) {
                    if (currentDirection == UP) {
                        ElevatorRequest request = currentRequests.pollFirst();
                        upRequest(request);
                        if (currentRequests.isEmpty())
                            addDownRequestsToCurrentRequests();
                    }
                    if (currentDirection == DOWN) {
                        ElevatorRequest request = currentRequests.pollLast();
                        downRequest(request);
                        if (currentRequests.isEmpty())
                            addUpRequestsToCurrentRequests();
                    }
                }
            }

    }

















    /* ==================================================================== */
    public static int getCurrentFloor() {
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

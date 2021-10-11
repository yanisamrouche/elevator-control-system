package elevator;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator();

        ProcessRequest p = new ProcessRequest(elevator);
        Thread T = new Thread(p);
        T.start();
        Thread.sleep(3000);

//        OutsideElevatorRequest outsideElevatorRequest = new OutsideElevatorRequest(Direction.UP, 0);
//        InsideElevatorRequest insideElevatorRequest = new InsideElevatorRequest(5);
//        ElevatorRequest elevatorRequest = new ElevatorRequest(insideElevatorRequest, outsideElevatorRequest);

        OutsideElevatorRequest outsideElevatorRequest1 = new OutsideElevatorRequest(Direction.UP, 0);
        InsideElevatorRequest insideElevatorRequest1 = new InsideElevatorRequest(5);
        ElevatorRequest elevatorRequest1 = new ElevatorRequest(insideElevatorRequest1, outsideElevatorRequest1);


//        AddRequest addRequest = new AddRequest(elevator, elevatorRequest);
//        Thread thread = new Thread(addRequest);
//        AddRequest addRequest1 = new AddRequest(elevator, elevatorRequest1);
//        Thread thread1 = new Thread(addRequest1);
////        thread.start();
//        thread1.start();

        elevator.upRequest(elevatorRequest1);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        System.out.println(outsideElevatorRequest.getSrcFloor());
//        System.out.println(outsideElevatorRequest.getDirectionTo());
//        System.out.println(insideElevatorRequest.getDstFloor());
//        System.out.println(elevatorRequest.getInsideElevatorRequest().getDstFloor());
//        System.out.println(elevatorRequest.getOutsideElevatorRequest().getSrcFloor() +"-->"+ elevatorRequest.getOutsideElevatorRequest().getDirectionTo() + " "+elevatorRequest.getInsideElevatorRequest().getDstFloor());
//        System.out.println(elevator.goesUp());

    }

}

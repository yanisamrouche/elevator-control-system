package elevator;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator();

        OutsideElevatorRequest outsideElevatorRequest = new OutsideElevatorRequest(Direction.UP, 0);
        InsideElevatorRequest insideElevatorRequest = new InsideElevatorRequest(9);
        ElevatorRequest elevatorRequest = new ElevatorRequest(insideElevatorRequest, outsideElevatorRequest);

        OutsideElevatorRequest outsideElevatorRequest2 = new OutsideElevatorRequest(Direction.DOWN, 3);
        InsideElevatorRequest insideElevatorRequest2 = new InsideElevatorRequest(1);
        ElevatorRequest elevatorRequest2 = new ElevatorRequest(insideElevatorRequest2, outsideElevatorRequest2);

        OutsideElevatorRequest outsideElevatorRequest3 = new OutsideElevatorRequest(Direction.DOWN, 5);
        InsideElevatorRequest insideElevatorRequest3 = new InsideElevatorRequest(0);
        ElevatorRequest elevatorRequest3 = new ElevatorRequest(insideElevatorRequest3, outsideElevatorRequest3);

        elevator.upRequest(elevatorRequest);
        elevator.downRequest(elevatorRequest2);
        elevator.downRequest(elevatorRequest3);
        elevator.start();


//        System.out.println(outsideElevatorRequest.getSrcFloor());
//        System.out.println(outsideElevatorRequest.getDirectionTo());
//        System.out.println(insideElevatorRequest.getDstFloor());
//        System.out.println(elevatorRequest.getInsideElevatorRequest().getDstFloor());
//        System.out.println(elevatorRequest.getOutsideElevatorRequest().getSrcFloor() +"-->"+ elevatorRequest.getOutsideElevatorRequest().getDirectionTo() + " "+elevatorRequest.getInsideElevatorRequest().getDstFloor());
//        System.out.println(elevator.goesUp());

    }

}

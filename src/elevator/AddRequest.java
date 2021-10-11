package elevator;

public class AddRequest implements Runnable{

    private Elevator elevator;
    private ElevatorRequest request;

    public AddRequest(Elevator elevator, ElevatorRequest request) {
        this.elevator = elevator;
        this.request = request;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (elevator.getCurrentState() == State.STOP_EMERGENCY){
            System.out.println("URGENT");
        }else {
            elevator.addRequest(request);
        }
    }
}

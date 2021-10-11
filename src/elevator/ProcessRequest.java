package elevator;

public class ProcessRequest implements Runnable {

        private Elevator elevator;

        public ProcessRequest(Elevator elevator) {
            this.elevator = elevator;
        }

        @Override
        public void run() {
            /**
             * start the elevator
             */
            try {
                if (elevator.getCurrentState() == State.STOP_EMERGENCY){
                    System.out.println("URGENNNNNNNCEEE");
                }else {
                    elevator.startElevator();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}


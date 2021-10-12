package GUI;

import elevator.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HandleFloorsButtonsAction extends AbstractAction {

    IHM ihm;
    Elevator elevator = HandleControlButtonsAction.elevator;
    InsideElevatorRequest insideElevatorRequest;
    OutsideElevatorRequest outsideElevatorRequest;
    ElevatorRequest elevatorRequest;

    public HandleFloorsButtonsAction(IHM ihm, String s){
        super(s);
        this.ihm = ihm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton button : ihm.floorBtn){

            if(e.getSource() == button){
                int floor = Integer.parseInt(button.getText());
                if(elevator.getCurrentDirection() == Direction.UP && elevator.getCurrentFloor() < floor) {

                    outsideElevatorRequest = new OutsideElevatorRequest(Direction.UP, elevator.getCurrentFloor());
                    insideElevatorRequest = new InsideElevatorRequest(floor);
                    elevatorRequest = new ElevatorRequest(insideElevatorRequest, outsideElevatorRequest);
                    try {
                        ProcessRequest p = new ProcessRequest(elevator);
                        Thread T = new Thread(p);
                        T.start();

                        Thread.sleep(1000);
                        AddRequest addRequest = new AddRequest(elevator, elevatorRequest);
                        Thread thread = new Thread(addRequest);
                        thread.start();


                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(elevator.getCurrentDirection() == Direction.DOWN && elevator.getCurrentFloor() > floor){

                    outsideElevatorRequest = new OutsideElevatorRequest(Direction.DOWN, elevator.getCurrentFloor());
                    insideElevatorRequest = new InsideElevatorRequest(floor);
                    elevatorRequest = new ElevatorRequest(insideElevatorRequest,outsideElevatorRequest);
                    try {

                        ProcessRequest p = new ProcessRequest(elevator);
                        Thread T = new Thread(p);
                        T.start();
                        Thread.sleep(2000);
                        AddRequest addRequest = new AddRequest(elevator, elevatorRequest);
                        Thread thread = new Thread(addRequest);
                        thread.start();

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

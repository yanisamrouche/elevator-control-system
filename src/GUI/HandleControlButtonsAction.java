package GUI;

import elevator.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HandleControlButtonsAction extends AbstractAction {
    IHM ihm;
    static Elevator elevator = new Elevator();
    InsideElevatorRequest insideElevatorRequest;
    static OutsideElevatorRequest outsideElevatorRequest;
    ElevatorRequest elevatorRequest ;





    public HandleControlButtonsAction(IHM ihm, String txt){
        super(txt);
        this.ihm = ihm;
        this.ihm.leftTextArea.setText(String.valueOf(elevator.getCurrentFloor()));
        this.ihm.rightTextArea.setText(String.valueOf(elevator.getCurrentFloor()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click ! ! ! ");
        ProcessRequest p = new ProcessRequest(elevator);
        Thread thread ;
        Thread thread2 = new Thread(p);

        if(e.getSource()==ihm.stopEmergencyBtn)
        {

            elevator.resetHS();
            ihm.leftTextArea.setText("HS");
            ihm.rightTextArea.setText("HS");
            ihm.centreTextArea.append("l'ascenseur est hors service");
            ihm.stopEmergencyBtn.setBackground(Color.red);
        }
        if(e.getSource() == ihm.upBtn)
        {

            String outsideSelectedFloor = (String) ihm.floors.getModel().getSelectedItem();
            String outsideFLoor = outsideSelectedFloor.substring(7);
            System.out.println(outsideFLoor);
            thread2.start();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            outsideElevatorRequest = new OutsideElevatorRequest(Direction.UP, Integer.parseInt(outsideFLoor.trim()));
            insideElevatorRequest = new InsideElevatorRequest(Integer.parseInt(outsideFLoor.trim()));
            elevatorRequest = new ElevatorRequest(insideElevatorRequest, outsideElevatorRequest);

            AddRequest addRequest = new AddRequest(elevator, elevatorRequest);
            thread = new Thread(addRequest);

            thread.start();

        }
        else if(e.getSource() == ihm.downBtn)
        {

            String outsideSelectedFloor = (String) ihm.floors.getModel().getSelectedItem();
            String outsideFLoor = outsideSelectedFloor.substring(7);
            System.out.println(outsideFLoor);
            thread2.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            outsideElevatorRequest = new OutsideElevatorRequest(Direction.DOWN, Integer.parseInt(outsideFLoor.trim()));
            insideElevatorRequest = new InsideElevatorRequest( Integer.parseInt(outsideFLoor.trim()));
            elevatorRequest = new ElevatorRequest(insideElevatorRequest, outsideElevatorRequest);

            AddRequest addRequest = new AddRequest(elevator, elevatorRequest);
            thread = new Thread(addRequest);
            thread.start();



        }

    }
}

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HandleFloorsButtonsAction extends AbstractAction {
    IHM ihm;
    List<JButton> btnFloors = new ArrayList<>();

    public HandleFloorsButtonsAction(IHM ihm, String txt){
        super(txt);
        this.ihm = ihm;
    }

    public List<JButton> getBtnFloors() {
        return btnFloors;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click ! ! ! ");
        btnFloors.add(ihm.btnFloor0);btnFloors.add(ihm.btnFloor1);btnFloors.add(ihm.btnFloor2);
        btnFloors.add(ihm.btnFloor3);btnFloors.add(ihm.btnFloor4);btnFloors.add(ihm.btnFloor5);
        btnFloors.add(ihm.btnFloor6);btnFloors.add(ihm.btnFloor7);btnFloors.add(ihm.btnFloor8);
        btnFloors.add(ihm.btnFloor9);
        if(e.getSource()==ihm.stopEmergencyBtn){
            ihm.rightTextArea.setText("HS");
            ihm.leftTextArea.setText("HS");
            ihm.stopEmergencyBtn.setBackground(Color.red);
        }
        for (int i=0; i < btnFloors.size(); i++){
            if(e.getSource() == btnFloors.get(i)){
                btnFloors.get(i).setBackground(Color.green);

            }
        }

    }
}

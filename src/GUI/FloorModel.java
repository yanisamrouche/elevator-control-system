package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class FloorModel extends DefaultComboBoxModel {
    ArrayList<String> floors;
    public FloorModel(){
        super();
        floors = new ArrayList<>();
        floors.add("Etage : 0");
        floors.add("Etage : 1");
        floors.add("Etage : 2");
        floors.add("Etage : 3");
        floors.add("Etage : 4");
        floors.add("Etage : 5");
        floors.add("Etage : 6");
        floors.add("Etage : 7");
        floors.add("Etage : 8");
        floors.add("Etage : 9");
    }
    public String getSelectedFloor(){
        return (String) getSelectedItem();
    }

    @Override
    public Object getElementAt(int index){
        return floors.get(index);
    }

    @Override
    public int getSize(){
        return floors.size();
    }

    @Override
    public int getIndexOf(Object element){
        return floors.indexOf(element);
    }
}

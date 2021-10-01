import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IHM extends JFrame implements ItemListener {

    JButton upBtn;
    JButton downBtn;
    JButton stopBtn;
    JButton stopEmergencyBtn;

    JButton btnFloor0;
    JButton btnFloor1;
    JButton btnFloor2;
    JButton btnFloor3;
    JButton btnFloor4;
    JButton btnFloor5;
    JButton btnFloor6;
    JButton btnFloor7;
    JButton btnFloor8;
    JButton btnFloor9;

    JComboBox floors;


    public IHM(){
        super();
        build();
    }

    void build(){

        setTitle("Elevator");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        commandBtnLeftPanel(leftPanel());
        floorsBoxLeftPanel(leftPanel());
        leftPanel();
        floorBtnRightPanel(rightPanel());
        commandBtnRightPanel(rightPanel());
        rightPanel();



    }

    JPanel rightPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(145,47,25));
        panel.setBounds(700,0,800,1000);
        add(panel);
        return panel;
    }

    JPanel leftPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,42,63));
        panel.setBounds(0,0,700,1000);
        add(panel);
        return panel;
    }

    void floorBtnRightPanel(JPanel panel){

        panel.setBounds(750,50,200,200);
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        btnFloor0 = new JButton("0");
        btnFloor1 = new JButton("1");
        btnFloor2 = new JButton("2");
        btnFloor3 = new JButton("3");
        btnFloor4 = new JButton("4");
        btnFloor5 = new JButton("5");
        btnFloor6 = new JButton("6");
        btnFloor7 = new JButton("7");
        btnFloor8 = new JButton("8");
        btnFloor9 = new JButton("9");

        panel.add(btnFloor9);
        panel.add(btnFloor8);
        panel.add(btnFloor7);
        panel.add(btnFloor6);
        panel.add(btnFloor5);
        panel.add(btnFloor4);
        panel.add(btnFloor3);
        panel.add(btnFloor2);
        panel.add(btnFloor1);
        panel.add(btnFloor0);

        add(panel);
    }

    void commandBtnRightPanel(JPanel panel){

        panel.setBounds(730,500,250,100);
        GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        stopEmergencyBtn = new JButton("STOP EMERGENCY");

        panel.add(stopEmergencyBtn);

        add(panel);
    }

    void floorsBoxLeftPanel(JPanel panel){
        floors =new JComboBox(new FloorModel());
        floors.setPreferredSize(new Dimension(500,50));
        floors.addItemListener(this);
        upBtn.setEnabled(false);
        downBtn.setEnabled(false);
        panel.add(floors);
        add(panel);
    }

    void commandBtnLeftPanel(JPanel panel){

        panel.setBounds(200,80,250,100);
        upBtn = new JButton("UP");
        panel.add(upBtn);
        downBtn = new JButton( "DOWN");
        panel.add(downBtn);
        add(panel);
    }



    public FloorModel getModelFloor(){ return (FloorModel) floors.getModel();}

    public static void main(String[] args){
        new IHM().setVisible(true);
    }
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == floors){
            System.out.println(" click ! ! ! ");
            String floor = getModelFloor().getSelectedFloor();
            System.out.println(floor);
            switch (floor){
                case "Etage : 0":
                    this.downBtn.setEnabled(false);
                    this.upBtn.setEnabled(true);
                    break;
                case "Etage : 1":
                case "Etage : 2":
                case "Etage : 3":
                case "Etage : 4":
                case "Etage : 5":
                case "Etage : 6":
                case "Etage : 7":
                case "Etage : 8":
                    this.upBtn.setEnabled(true);
                    this.downBtn.setEnabled(true);
                    break;
                case "Etage : 9":
                    this.upBtn.setEnabled(false);
                    this.downBtn.setEnabled(true);
                    break;

            }
        }


    }


}

package GUI;

import javax.swing.*;
import java.awt.*;
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

    TextArea leftTextArea;
    TextArea rightTextArea;


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

        title(leftPanel(), "Outside the elevator", 200, 0);
        log(leftPanel());
        logLeftPanel(leftPanel());
        commandBtnLeftPanel(leftPanel());
        floorsBoxLeftPanel(leftPanel());
        leftPanel();
        /* ===================================================*/

        title(rightPanel(), "Inside the elevator", 700,850);
        logRightPanel(rightPanel());
        floorBtnRightPanel(rightPanel());
        commandBtnRightPanel(rightPanel());
        rightPanel();

    }

    JPanel rightPanel(){
        JPanel panel = new JPanel();

        panel.setBackground(new Color(96,69,80));
        panel.setBounds(700,0,800,1000);
        add(panel);
        return panel;
    }

    JPanel leftPanel(){
        JPanel panel = new JPanel();

        panel.setBackground(new Color(155,123,99));
        panel.setBounds(0,0,700,1000);
        add(panel);
        return panel;
    }

    void floorBtnRightPanel(JPanel panel){

        panel.setBounds(750,80,200,200);
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        btnFloor0 = new JButton(new HandleFloorsButtonsAction(this, "0"));
        btnFloor1 = new JButton(new HandleFloorsButtonsAction(this,"1"));
        btnFloor2 = new JButton(new HandleFloorsButtonsAction(this,"2"));
        btnFloor3 = new JButton(new HandleFloorsButtonsAction(this,"3"));
        btnFloor4 = new JButton(new HandleFloorsButtonsAction(this,"4"));
        btnFloor5 = new JButton(new HandleFloorsButtonsAction(this,"5"));
        btnFloor6 = new JButton(new HandleFloorsButtonsAction(this,"6"));
        btnFloor7 = new JButton(new HandleFloorsButtonsAction(this,"7"));
        btnFloor8 = new JButton(new HandleFloorsButtonsAction(this,"8"));
        btnFloor9 = new JButton(new HandleFloorsButtonsAction(this,"9"));

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

        stopEmergencyBtn = new JButton(new HandleFloorsButtonsAction(this,"STOP EMERGENCY"));

        panel.add(stopEmergencyBtn);

        add(panel);
    }

    void logRightPanel(JPanel panel){
        panel.setBounds(825,0,50, 50);

        rightTextArea = new TextArea("",3,3, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
        rightTextArea.setEditable(false);
        rightTextArea.setBackground(new Color(255,255,255));
        panel.add(rightTextArea);
    }

    void floorsBoxLeftPanel(JPanel panel){
        panel.setBounds(100, 250,500,500);
        floors =new JComboBox(new FloorModel());
        floors.setPreferredSize(new Dimension(500,50));
        floors.addItemListener(this);
        upBtn.setEnabled(false);
        downBtn.setEnabled(false);
        panel.add(floors);
        add(panel);
    }

    void commandBtnLeftPanel(JPanel panel){

        panel.setBounds(220,400,250,100);
        upBtn = new JButton("/\\");
        panel.add(upBtn);
        downBtn = new JButton( "\\/");
        panel.add(downBtn);
        add(panel);

    }

    void logLeftPanel(JPanel panel){
        panel.setBounds(300,10,80, 80);
        JLabel label = new JLabel("");
        panel.add(label);

        leftTextArea = new TextArea("",5,5, TextArea.SCROLLBARS_NONE);

        leftTextArea.setEditable(false);
        leftTextArea.setBackground(new Color(255,255,255));
        panel.add(leftTextArea);
    }

    TextArea centreTextArea;
    void log(JPanel panel){
        panel.setBounds(180,550,350, 200);
        JLabel label = new JLabel("==Actions==");
        panel.add(label);

        centreTextArea = new TextArea(">>",50,50, TextArea.SCROLLBARS_NONE);

        centreTextArea.setEditable(false);
        centreTextArea.setBackground(new Color(255,255,255));
        panel.add(centreTextArea);
    }

    void title(JPanel panel, String s, int x, int y){
        panel.setBounds(x, y, 300, 50);
        JLabel label = new JLabel(s);
        panel.add(label);
    }


    void addToLeftText(String text){
        leftTextArea.append("[ " + text + " ]");
    }
    void addToRightText(String text){
        rightTextArea.append("[ " + text + " ]");
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

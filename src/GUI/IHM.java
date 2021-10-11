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

    JButton[] floorBtn = new JButton[10] ;

    JComboBox floors;

    static TextField leftTextArea = new TextField();
    static TextField rightTextArea = new TextField();;



    public IHM(){
        super();
        build();
    }

    void build(){

        setTitle("Elevator");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setLayout(null);

        title(leftPanel(), "Outside the elevator", 200, 0);
        logLeftPanel(leftPanel());
        log(leftPanel());
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

        panel.setBackground(new Color(52,69,80));
        panel.setBounds(700,0,800,1000);
        add(panel);
        return panel;
    }

    JPanel leftPanel(){
        JPanel panel = new JPanel();

        panel.setBackground(new Color(0,123,99));
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

        int numBtn = 9;
        for (JButton button : floorBtn){
            button = new JButton(new HandleFloorsButtonsAction(this,numBtn+""));
            floorBtn[numBtn] = button;
            panel.add(button);
            numBtn--;
        }

        add(panel);
    }

    void commandBtnRightPanel(JPanel panel){

        panel.setBounds(730,500,250,100);
        GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        stopEmergencyBtn = new JButton(new HandleControlButtonsAction(this,"STOP EMERGENCY"));

        panel.add(stopEmergencyBtn);

        add(panel);
    }

    void logRightPanel(JPanel panel){
        panel.setBounds(825,0,50, 60);

//        rightTextArea = new TextArea("",4,4, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
        rightTextArea.setPreferredSize(new Dimension(40,45));
        rightTextArea.setEditable(false);
        rightTextArea.setBackground(new Color(80,80,80));
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
        upBtn = new JButton(new HandleControlButtonsAction(this, "/\\"));
        panel.add(upBtn);
        downBtn = new JButton(new HandleControlButtonsAction(this,"\\/"));
        panel.add(downBtn);
        add(panel);

    }

    void logLeftPanel(JPanel panel){

        panel.setBounds(290,50,80, 85);
        JLabel label = new JLabel("");
        panel.add(label);

//        leftTextArea = new TextArea("",3,4, TextArea.SCROLLBARS_NONE);
        leftTextArea.setPreferredSize(new Dimension(40,45));
        leftTextArea.setEditable(false);
        leftTextArea.setBackground(new Color(80,80,80));
        panel.add(leftTextArea);

    }

    static JTextArea centreTextArea;
    void log(JPanel panel){

        panel.setBounds(80,550,550, 500);
        JLabel label = new JLabel("");
        panel.add(label);

        centreTextArea = new JTextArea(">>");
        centreTextArea.setEditable(false);
        centreTextArea.setPreferredSize(new Dimension(400,400));
        centreTextArea.setBackground(new Color(255,255,255));

        panel.add(centreTextArea);


    }

    void title(JPanel panel, String s, int x, int y){
        panel.setBounds(x, y, 300, 50);
        JLabel label = new JLabel(s);
        panel.add(label);
    }



    public JButton getUpBtn() {
        return upBtn;
    }

    public JButton getDownBtn() {
        return downBtn;
    }

    public JButton getStopBtn() {
        return stopBtn;
    }

    public JButton getStopEmergencyBtn() {
        return stopEmergencyBtn;
    }

    public JButton[] getFloorBtn() {
        return floorBtn;
    }

    public JComboBox getFloors() {
        return floors;
    }

    public static TextField getLeftTextArea() {
        return leftTextArea;
    }

    public static TextField getRightTextArea() {
        return rightTextArea;
    }

    public static JTextArea getCentreTextArea() {
        return centreTextArea;
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

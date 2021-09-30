import javax.swing.*;
import java.awt.*;

public class IHM extends JFrame {

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

    JButton Floor0 ;
    JButton Floor1;
    JButton Floor2 ;
    JButton Floor3 ;
    JButton Floor4 ;
    JButton Floor5 ;


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
        setVisible(true);
        leftPanel();
        floorBtnPanel(rightPanel());
        commandBtnPanel(rightPanel());
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

    void floorBtnPanel(JPanel panel){

        panel.setBounds(750,50,200,200);
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        btnFloor0 = new JButton("0");
        btnFloor1 = new JButton("1");
        btnFloor2 = new JButton("2");
        btnFloor3 = new JButton("3");
        btnFloor4 = new JButton("4");
        btnFloor5 = new JButton("5");



        panel.add(btnFloor5);
        panel.add(btnFloor4);
        panel.add(btnFloor3);
        panel.add(btnFloor2);
        panel.add(btnFloor1);
        panel.add(btnFloor0);

        add(panel);
    }

    void commandBtnPanel(JPanel panel){

        panel.setBounds(730,500,250,100);
        GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setHgap(3);
        gridLayout.setVgap(3);
        panel.setLayout(gridLayout);

        upBtn = new JButton("UP");
        downBtn = new JButton("DOWN");
        stopBtn = new JButton("STOP");
        stopEmergencyBtn = new JButton("STOP HS");

        panel.add(upBtn);
        panel.add(downBtn);
        panel.add(stopBtn);
        panel.add(stopEmergencyBtn);

        add(panel);
    }



    public static void main(String[] args){
        new IHM().build();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Traffic Light Project
 *@author Ronard Nyongkah
 *@version Spring 2025
 *CSci1130
*/

public class Trafficlight extends JFrame implements ActionListener{
    final int FRAME_WIDTH = 800, FRAME_HEIGHT = 800;
    private JPanel guiPanel;
    private DisplayPanel display;
    JButton goButton, stopButton, slowButton;
    boolean isRed, isYellow, isGreen;
    // creating color variable
    private Color stopColor = new Color(102,14,14), slowColor = new Color(145,145,56), goColor = new Color(42,75,17);

    

    public static void main(String[] args) {
        Trafficlight frame = new Trafficlight();
        frame.setSize(new Dimension(frame.FRAME_WIDTH, frame.FRAME_HEIGHT));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();

        frame.pack();
        frame.setVisible(true);
        
    }

    public void setUpGUI(){

        Container window = getContentPane();
        //instantiate the DisplayPanel object
        display = new DisplayPanel();
        //instantiate the JPanel called guiPanel
        guiPanel = new JPanel(new FlowLayout());
        //instantiate the JButton

        stopButton = new JButton("STOP!");
        slowButton = new JButton("SLOW!");
        goButton = new JButton("GO!");

        guiPanel.add(stopButton);
        guiPanel.add(slowButton);
        guiPanel.add(goButton);
        

        stopButton.addActionListener(this);
        slowButton.addActionListener(this);
        goButton.addActionListener(this);
        

        window.add(display, BorderLayout.CENTER);
        window.add(guiPanel, BorderLayout.SOUTH);
        

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == stopButton){
            stopColor = Color.red;
            slowColor = new Color(145,145,56);
            goColor = new Color(42,75,17);
        }
        else if(actionEvent.getSource() == slowButton){
            slowColor = Color.yellow;
            stopColor = new Color(102,14,14);
            goColor = new Color(42,75,17);
        }
        else if (actionEvent.getSource() == goButton) {
            goColor = Color.green;
            stopColor = new Color(102,14,14);
            slowColor = new Color(145,145,56);

            
        }
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-200));
            // this.setBackground(Color.BLACK);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


            g2d.setColor(Color.BLACK);
            g2d.fillRect(250, 100, 300, 500);
            g2d.setColor(stopColor);
            g2d.fillOval(350,150,125,125);
            g2d.setColor(slowColor);
            g2d.fillOval(350,300,125,125);
            g2d.setColor(goColor);
            g2d.fillOval(350,450,125,125);
        }
    }//end inner class

    
}

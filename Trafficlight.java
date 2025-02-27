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
    private JLabel topLabel;
    private JPanel guiPanel, topPanel;
    private DisplayPanel display;
    JButton goButton, stopButton, slowButton;
    boolean isRed, isYellow, isGreen;
    // creating color variables for when the lights first show up in dark mode
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
        topPanel = new JPanel(new FlowLayout());
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());
        //instantiate the JButton
        topLabel=new JLabel("Traffic");
        stopButton = new JButton("STOP!");
        slowButton = new JButton("SLOW!");
        goButton = new JButton("GO!");

        guiPanel.add(stopButton);
        guiPanel.add(slowButton);
        guiPanel.add(goButton);
        

        stopButton.addActionListener(this);
        slowButton.addActionListener(this);
        goButton.addActionListener(this);
        
        topPanel.add(topLabel);
        window.add(topPanel, BorderLayout.NORTH);
        window.add(display, BorderLayout.CENTER);
        window.add(guiPanel, BorderLayout.SOUTH);
        

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == stopButton){
            isRed = true;
            isYellow = false;
            isGreen = false;
        }
        else if(actionEvent.getSource() == slowButton){
            isRed = false;
            isYellow = true;
            isGreen = false;
        }
        else if (actionEvent.getSource() == goButton) {
            isRed = false;
            isYellow = false;
            isGreen = true;

        }
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-200));
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

            
            g2d.setColor(Color.BLACK);
            
        //the six arcs under here create the illusion of the other lights that are off to the sides
            g2d.fillArc(425,150,250,250,70,100);

            g2d.fillArc(425,300,250,250,70,100);

            g2d.fillArc(424,450,250,250,70,100);

            g2d.fillArc(125,150,250,250,10,100);

            g2d.fillArc(125,300,250,250,10,100);

            g2d.fillArc(125,450,250,250,10,100);


            g2d.fillRect(250, 75, 300, 500);
            g2d.setColor(stopColor);
            if(isRed){
                g2d.setColor(Color.red);
            }
            g2d.fillOval(340,130,125,125);
            g2d.setColor(slowColor);
            if(isYellow){
                g2d.setColor(Color.yellow);
            }
            g2d.fillOval(340,280,125,125);
            g2d.setColor(goColor);
            if(isGreen){
                g2d.setColor(Color.green);
            }
            g2d.fillOval(340,430,125,125);

        }
    }//end inner class

    
}

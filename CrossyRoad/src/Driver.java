import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuKeyListener;
 
public class Driver extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
        //instance variables
        private Player p1;
        private ArrayList<Integer> road;
        private ArrayList<Integer> tracks;
        private ArrayList<Integer> water;
        private int y;
        private int diff;
       
       
        public void paint(Graphics g) {
                Color grassGreen = new Color(126,200,80);
                g.setColor(grassGreen);
               
       
               
               
                g.fillRect(0, y, 1000, 5000);
               
               
               
                for (int i = 0; i<road.size()-1;i+=2) {
                        g.setColor(Color.black);
                        g.fillRect(0,road.get(i),1000,Math.abs(road.get(i)-road.get(i+1)));
                        road.set(i,road.get(i)+diff);
                        road.set(i+1,road.get(i+1)+diff);
                }
                for (int i = 0; i<tracks.size()-1;i+=2) {
                        g.setColor(Color.gray);
                        g.fillRect(0,tracks.get(i),1000,Math.abs(tracks.get(i)-tracks.get(i+1)));
                        tracks.set(i,tracks.get(i)+diff);
                        tracks.set(i+1,tracks.get(i+1)+diff);
                }
                for (int i = 0; i<water.size()-1;i+=2) {
                        g.setColor(Color.blue);
                        g.fillRect(0,water.get(i),1000,Math.abs(water.get(i)-water.get(i+1)));
                        water.set(i,water.get(i)+diff);
                        water.set(i+1,water.get(i+1)+diff);
                }
       
                p1.paint(g);
               
        }
       
       
        public void rings(int x, int y, int width, Graphics g) {
               
               
               
        }      
       
        public static void main(String[] arg) {
               
                //find a way to run the constructor of the Driver class
                Driver d  = new Driver(); //will this invoke a constructor?
               
 
        }      
       
        //1) add a Driver constructor
                public Driver() {
                        y = -4400;
                        diff = 0;
                        p1 = new Player();
                        road = new ArrayList<Integer>();
                        water = new ArrayList<Integer>();
                        tracks = new ArrayList<Integer>();
                       
                        int curPos = 450;
                        while(curPos >= -4400) {
                                int randTerrain = (int)((Math.random()*3)+1);
                                int randSize = (int)((Math.random()*2)+1);
                                System.out.println("randTerrain = " + randTerrain + "randSize = " + randSize);
                                if (randTerrain == 1) {
                                        System.out.println("Road");    
                                        road.add(curPos-(50*randSize));
                                        road.add(curPos);              
                                        curPos = curPos-(50*randSize)-50;
                                }
                                if (randTerrain == 2) {
                                        System.out.println("Tracks");
                                        tracks.add(curPos-(50*randSize));
                                        tracks.add(curPos);            
                                        curPos = curPos-(50*randSize)-50;
                                       
                                }
                                if (randTerrain == 3) {
                                        System.out.println("Water");
                                        water.add(curPos-(50*randSize));
                                        water.add(curPos);             
                                        curPos = curPos-(50*randSize)-50;                            
                                }
                        }
                       
                       
                        JFrame frame = new JFrame("Crossy Road");
                        frame.setSize(400,600);
                        frame.add(this);
                       
                        //this part makes sure the x button closes the program
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       
                        frame.addMouseListener(this);
                        frame.addMouseMotionListener(this);
                       
                       
                        t.start();
                        //make the frame show up
                        frame.setVisible(true);
                                       
                }
        Timer t = new Timer(16, this);
        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                repaint();
        }
 
 
        @Override
        public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
 
        @Override
        public void mouseEntered(MouseEvent m) {
                // TODO Auto-generated method stub
               
        }
 
 
        @Override
        public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
 
        @Override
        public void mousePressed(MouseEvent m) {
                y+= 50;
                diff = 50;
        }
 
 
        @Override
        public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
                diff = 0;
        }
 
 
        @Override
        public void mouseDragged(MouseEvent m) {
                // TODO Auto-generated method stub
               
               
               
        }
 
 
        @Override
        public void mouseMoved(MouseEvent m) {
               
        }
}
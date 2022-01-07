import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuKeyListener;

public class Driver extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener{
        //instance variables
        private Player p1;
        private ArrayList<Integer> road;
        private ArrayList<Integer> tracks;
        private ArrayList<Integer> water;
        private int y;
        private int diff;
        private int counter;
        private int threshold;
        private ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
       
       
        public void paint(Graphics g) {
                Color grassGreen = new Color(126,200,80);
                g.setColor(grassGreen);
                counter++;
                g.fillRect(0, y, 1000, 6000);
                for (int i = 0; i<road.size()-1;i+=2) {
                        g.setColor(Color.black);
                        g.fillRect(0,road.get(i),400,Math.abs(road.get(i)-road.get(i+1)));
                        road.set(i,road.get(i)+diff);
                        road.set(i+1,road.get(i+1)+diff);
                }
                for (int i =0; i<cars.size();i++) {
                        int randomSpawn = (int)(Math.random()*80);
                        cars.get(i).setY(cars.get(i).getY()+diff);
                        cars.get(i).setX(cars.get(i).getX()+cars.get(i).getvX());
                        cars.get(i).paint(g);
                        if(cars.get(i).getX()>400) {
                                cars.get(i).setX(0-randomSpawn);
                        }
                        if(p1.getY()>cars.get(i).getY() && p1.getY() >cars.get(i).getY()+cars.get(i).getWidth()) {
                               
                        }
                       
                }
               
                for (int i = 0; i<tracks.size()-1;i+=2) {
                        g.setColor(Color.gray);
                        g.fillRect(0,tracks.get(i),400,Math.abs(tracks.get(i)-tracks.get(i+1)));
                        tracks.set(i,tracks.get(i)+diff);
                        tracks.set(i+1,tracks.get(i+1)+diff);
                }
                for (int i = 0; i<water.size()-1;i+=2) {
                        g.setColor(Color.blue);
                        g.fillRect(0,water.get(i),400,Math.abs(water.get(i)-water.get(i+1)));
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
                        y = -5400;
                        diff = 0;
                        threshold=0;
                        p1 = new Player(190,500);
                        road = new ArrayList<Integer>();
                        water = new ArrayList<Integer>();
                        tracks = new ArrayList<Integer>();
                       
                        int curPos = 450;
                        while(curPos >= -4400) {
                                int randTerrain = (int)((Math.random()*3)+1);
                                int randSize = (int)((Math.random()*2)+1);
//                              System.out.println("randTerrain = " + randTerrain + "randSize = " + randSize);
                                if (randTerrain == 1) {
                                               
                                        road.add(curPos-(50*randSize));
                                        road.add(curPos);              
                                        for (int i = 0; i<randSize;i++) {
                                                int randomSpawn = (int)(Math.random()*80);
                                                Vehicle temp = new Vehicle(0-randomSpawn,curPos-(50*(randSize-i))+5,5);
                                                cars.add(temp);
                                        }
                                        curPos = curPos-(50*randSize)-50;
                                       
                                       
                                }
                                if (randTerrain == 2) {
       
                                        tracks.add(curPos-(50*randSize));
                                        tracks.add(curPos);            
                                        curPos = curPos-(50*randSize)-50;
                                       
                                }
                                if (randTerrain == 3) {
               
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
                        frame.addKeyListener(this);
                       
                        t.start();
                        //make the frame show up
                        frame.setVisible(true);
                                       
                }
        Timer t = new Timer(70, this);
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
               
        }
 
 
        @Override
        public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
 
        @Override
        public void mouseDragged(MouseEvent m) {
                // TODO Auto-generated method stub
               
               
               
        }
 
 
        @Override
        public void mouseMoved(MouseEvent m) {
               
        }
 
 
        @Override
        public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
                if (arg0.getKeyCode() == 38 && threshold <=3) {
                        threshold++;
                        p1.setY(p1.getY()-50);
                }
                if (arg0.getKeyCode() == 38 && counter >=1 && threshold>3) {
                        y+= 50;
                        diff = 50;
                        counter =0;
                } 
               
               
        }
 
 
        @Override
        public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                diff =0;
               
        }
 
 
        @Override
        public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
               
        }
       
}
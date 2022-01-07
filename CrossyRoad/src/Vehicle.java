import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
 
public class Vehicle {
        private int x;
        private int y;
        private int vX;
        private int width;
        private int height;
        private Color color;
        private ArrayList<Integer> road;
       
       
        public int getX() {
                return x;
        }
 
        public void setX(int x) {
                this.x = x;
        }
 
        public int getY() {
                return y;
        }
 
        public void setY(int y) {
                this.y = y;
        }
 
        public ArrayList<Integer> getRoad() {
                return road;
        }
 
        public void setRoad(ArrayList<Integer> road) {
                this.road = road;
        }
 
        public Vehicle(int x, int y, int vX) {
                this.x = x;
                this.y = y;
                this.vX = vX;
                width = 100;
                height = 40;
                int red = (int)(Math.random()*256);
                int green = (int)(Math.random()*256);
                int blue = (int)(Math.random()*256);
                color = new Color(red,green,blue);  
        }
       
        public void paint(Graphics g) {
 
                g.setColor(color);
                g.fillRect(x, y, width, height);
        }
 
        public int getWidth() {
                return width;
        }
 
        public void setWidth(int width) {
                this.width = width;
        }
 
        public int getvX() {
                return vX;
        }
 
        public void setvX(int vX) {
                this.vX = vX;
        }
}
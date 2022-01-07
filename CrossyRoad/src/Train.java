import java.awt.Color;
	import java.awt.Graphics;
	
public class Train {
	


		private static int x;
		private static int y;
		private static int width;
		private static int length;
		private int vx,vy;
		private Color color;
		private double area; //helps with width calculation as we consume other cells
		
		
		public void paint(Graphics g) {
			x += vx;
			
			g.setColor(color);
			g.fillRect(x, y, width, length);
		}
		
		public Train(int newX, int newY) {
			width = 40;
			length = 200;

			int red = (int) (Math.random()*256);
			int green = (int) (Math.random()*256);
			int blue = (int) (Math.random()*256);
			
			
			color = new Color(135, 206, 250);
			
			vx = 100;
			
			area = Math.PI * Math.pow(width/2,2);
			x = newX;
			y = newY;
		}
		
		public boolean collide(Train other) {
			
			int x1 = this.x+width/2;
			int y1 = this.y+width/2;
			
			int x2 = other.x + other.width/2;
			int y2 = other.y + other.width/2;
			
			int dist = (int) (Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1 - y2,2) ));
			int r1 = this.width/2;
			int r2 = other.width/2;
			
			//figure out which cell is bigger
			//increment it's size somehow
			
			if (r1 + r2 >= dist) {
				if (this.area > other.area) {
				this.area += other.area;
				//calculate new width based on new area
				this.width = (int) Math.sqrt( (this.area*4) / Math.PI );
				
				other.x = 10000;
			}
			}
			
			return ((r1+r2) > dist);
		}
		
		public static void collisions (Train player1, Player other) {
			
			int x = (int) (Math.random()*800);
			int y = (int) (Math.random()*600);
			
			
			int x1 = player1.x+ player1.width/2;
			int y1 = player1.y+player1.width/2;
			
			int x2 = other.getX()/2;
			int y2 =  other.getY();
			
			int dist = (int) (Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1 - y2,2) ));
			int r1 = player1.width/2;
			int r2 = other.getY()/2;
			
			//figure out which cell is bigger
			//increment it's size somehow
			
			
		}

		//getter
		
		public double getArea() {
			return area;
		}

		public void setArea(double area) {
			this.area = area;
		}

		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public static int getWidth() {
			return width; //return this.x
		}
		
		//setter
		public static void setX(int newX) {
			x = newX;
		}
		
		public static void setY(int newY) {
			y = newY;
		}
		
		public void setWidth(int newWidth) {
			width = newWidth;
		}
		
		public void setVx(int newVx) {
			vx = newVx;
			
		}
		public void setVy(int newVy) {
			vy = newVy;
			
		}
		
		public void setColor(int r, int g, int b) {
			color = new Color(r,g,b);
		}
		
	}

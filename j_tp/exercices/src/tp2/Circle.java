package tp2;

import java.awt.*;

public class Circle extends Figure {
	private Point centre;
	private int rayon;
	
	public Circle() {
		
	}
	
	public Circle(int x1, int y1, int r) {
		this.centre = new Point(x1, y1);
		this.rayon = r;
	}
	
	public void setLocation(int x1,int y1) {
		this.centre.x = x1;
		this.centre.y = y1;
	}
	
	public void setRayon(int r) {
		this.rayon = r;
	}
	
	public Point getLocation() {
		return centre;
	}
	
	public int getRayon() {
		return rayon;
	}
	
	public boolean contains(int x,int y){
		double dx, dy;
		dx = (x - this.centre.getX())*(x - this.centre.getX());
		dy = (y - this.centre.getY())*(y - this.centre.getY());
		if (dx+dy < this.rayon*this.rayon) return true;
		return false;
	}

    public void draw(Graphics g) {
    	super.draw(g);
    	g.drawOval(this.centre.x-this.rayon, this.centre.y-this.rayon, this.rayon*2, this.rayon*2);
    }
	
}

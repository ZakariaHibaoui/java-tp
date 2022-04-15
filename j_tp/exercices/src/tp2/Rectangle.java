package tp2;

import java.awt.*;

public class Rectangle extends Figure {
	private int w;
	private int h;
	private Point pos;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point pos, int w, int h) {
		this.pos = pos;
		this.w = w;
		this.h = h;
	}
	
	public void setLocation(int x1,int y1) {
		this.pos.x = x1;
		this.pos.y = y1;
	}
	
	public void setDimension(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public Point getLocation() {
		return this.pos;
	}
	
	public int getWidth() {
		return this.w;
	}
	
	public int getHeight() {
		return this.h;
	}
	
	public boolean contains(int x,int y){
        if ((x >= this.pos.getX() && x <= this.pos.getX() + this.w) && (y >= this.pos.getY() && y <= this.pos.getY() + this.h))
        	return true;
        return false;
	}

    public void draw(Graphics g) {
    	super.draw(g);
    	g.drawRect(this.pos.x, this.pos.y, this.w, this.h);
    }
}

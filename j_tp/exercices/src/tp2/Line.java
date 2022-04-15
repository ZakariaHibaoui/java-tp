package tp2;

import java.awt.*;

public class Line extends Figure {
	private Point extremity1;
	private Point extremity2;
	
	public Line() {
		
	}
	
	public Line(Point p1, Point p2) {
		this.extremity1 = p1;
		this.extremity2 = p2;
	}
	
	public void setExtremity1(int x,int y) {
		this.extremity1.x = x;
		this.extremity1.y = y;
	}
	
	public void setExtremity2(int x,int y) {
		this.extremity2.x = x;
		this.extremity2.y = y;
	}
	
	public boolean contains(int x,int y){
        return false;
    }

    public void draw(Graphics g) {
    	super.draw(g);
    	g.drawLine(this.extremity1.x, this.extremity1.y, this.extremity2.x, this.extremity2.y);
    }
}
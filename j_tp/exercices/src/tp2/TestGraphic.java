package tp2;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TestGraphic extends Frame implements MouseListener, MouseMotionListener {
	// manually circles and rectangle
	static Circle circle1 = new Circle(200, 200, 100);
	static Circle circle2 = new Circle(160, 150, 20);
	static Circle circle3 = new Circle(240, 150, 20);
	static Rectangle rect = new Rectangle(new Point(150, 220), 100, 40);
	
	// list of added figures
	ArrayList<Circle> allCircles=new ArrayList<Circle>();
	ArrayList<Rectangle> allRects=new ArrayList<Rectangle>();
	
	// list of colors
	static Color[] colors = { Color.black, Color.blue , Color.cyan, Color.red, Color.green, Color.magenta, Color.orange, Color.yellow };
	
	// Dialog
	Draw draw;
	
	// counter and points of creating line
	int count = 0;
	Point p1, p2;
	
	// buttons for create a figure
	Button addCircle = new Button("Ajouter Cercle");
	Button addRect = new Button("Ajouter Rectangle");
	Button addLine = new Button("Ajouter Ligne");
	Button demo = new Button("");
	
	public TestGraphic() {
		this.setVisible(true);
		this.setSize(500, 500);
		
		allCircles.add(circle1);
		allCircles.add(circle2);
		allCircles.add(circle3);
		allRects.add(rect);
		
		addCircle.setSize(150, 30);
		addCircle.setLocation(0, 50);
		add(addCircle);
		
		addLine.setSize(150, 30);
		addLine.setLocation(160, 50);
		add(addLine);
		
		addRect.setSize(150, 30);
		addRect.setLocation(320, 50);
		add(addRect);
		
		add(demo);
		demo.setVisible(false);
			
		addCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				draw = new Draw("cercle", colors);
			}
		});
		addLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				draw = new Draw("ligne", colors);
			}
		});
		addRect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				draw = new Draw("rect", colors);
			}
		});
				
        addMouseListener(this);
        addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        circle1.draw(g);
        circle2.draw(g);
        circle3.draw(g);
        rect.draw(g);
    }
	
	public static void main(String[] args) {
        TestGraphic test = new TestGraphic();
    }
    
	@Override
    public void mouseClicked(MouseEvent e) {    
		/*
		if (circle1.contains(e.getX(), e.getY()) && !circle2.contains(e.getX(), e.getY()) && !circle3.contains(e.getX(), e.getY()) && !rect.contains(e.getX(), e.getY())) {			
			this.changeColor(getGraphics(), circle1);
			circle1.draw(getGraphics());
		}
		
		if (circle2.contains(e.getX(), e.getY())) {			
			this.changeColor(getGraphics(), circle2);
			circle2.draw(getGraphics());
		}
		
		if (circle3.contains(e.getX(), e.getY())) {
			this.changeColor(getGraphics(), circle3);
			circle3.draw(getGraphics());
		}
		
		if (rect.contains(e.getX(), e.getY())) {
			this.changeColor(getGraphics(), rect);
			rect.draw(getGraphics());
		}
		*/
		
		// create new figure
		if (draw != null) {			
			// cercle
			if (draw.getType() == "cercle") {				
				Circle drawCircle = new Circle(e.getX(), e.getY(), draw.getDrawRayon());
				drawCircle.setColor(draw.getColor());
				allCircles.add(drawCircle);
				drawCircle.draw(getGraphics());
			}
			
			// rectangle
			if (draw.getType() == "rect") {				
				Rectangle drawRect = new Rectangle(new Point(e.getX(), e.getY()), draw.getRectWidth(), draw.getRectHeight());
				drawRect.setColor(draw.getColor());
				allRects.add(drawRect);
				drawRect.draw(getGraphics());
			}
			
			// ligne
			if (draw.getType() == "ligne") {
				if (count == 2)
					count = 0;
				
				if (count == 0) {
					this.p1 = new Point(e.getX(), e.getY());					
				}
				
				if (count == 1) {
					this.p2 = new Point(e.getX(), e.getY());
					Line drawLine = new Line(this.p1, this.p2);
					drawLine.setColor(draw.getColor());
					drawLine.draw(getGraphics());
				}
				
				count++;
			}
		}
		
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		/*
		ArrayList<Circle> clickedCircles=new ArrayList<Circle>();
		ArrayList<Rectangle> clickedRects=new ArrayList<Rectangle>();
		
		for (Rectangle r: allRects) {
			if (r.contains(e.getX(), e.getY())) {			
				// r.setLocation(e.getX(), e.getY());
				clickedRects.add(r);
			}
		}
		
		for (Circle c: allCircles) {
			if (c.contains(e.getX(), e.getY())) {			
				// c.setLocation(e.getX(), e.getY());
				clickedCircles.add(c);
			}
		}
		*/
		
		if (circle1.contains(e.getX(), e.getY()) && !circle2.contains(e.getX(), e.getY()) && !circle3.contains(e.getX(), e.getY()) && !rect.contains(e.getX(), e.getY())) {			
			circle1.setLocation(e.getX(), e.getY());
		}
		
		if (circle2.contains(e.getX(), e.getY())) {			
			circle2.setLocation(e.getX(), e.getY());
		}
		
		if (circle3.contains(e.getX(), e.getY())) {
			circle3.setLocation(e.getX(), e.getY());
		}
		if (rect.contains(e.getX(), e.getY())) {
			rect.setLocation(e.getX(), e.getY());
		}
	
		repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	public void changeColor(Graphics g, Figure f) {
		int i = 1;
		for (int j=0; j < colors.length; j++) {
			if (colors[j] == f.getColor()) {
				i = j+1;
				break;
			}
		}
		
		if (i == colors.length)
			i = 0;
		
		f.setColor(colors[i]);
	}
    
    
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}

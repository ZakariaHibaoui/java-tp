package tp2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp2.Rectangle;

public class Draw {

	private TextField rayon;
	private TextField width;
	private TextField height;
	private Choice colorChoice;
	
	private int drawRayon;
	private int rectWidth;
	private int rectHeight;
	private Color color;
	
	private String type;
	
	// private Rectangle drawRect = new Rectangle(new Point(150, 220), 100, 40);
	
	public Draw(String type, Color[] colors) {
		Frame f = new Frame();
		Dialog d = new Dialog(f, "", true);

		colorChoice = new Choice();
		colorChoice.setBounds(100,100, 75,75);  
		for (Color color: colors) {
			colorChoice.add(color.toString());
		}
        d.add(colorChoice);
        
        
        this.type = type;
		
		if (type == "cercle") {			
			rayon = new TextField("150");
			rayon.setBounds(50,100, 200,30);
			d.add(rayon);
		}
		
		if (type == "rect") {			
			width = new TextField("150");
			width.setBounds(50,100, 200,30);
			d.add(width);
			
			height = new TextField("150");
			height.setBounds(50,100, 200,30);
			d.add(height);
		}
		
		Button close = new Button("Annuler");
		close.setBounds(50,100, 200,30);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				for (Color c: colors) {
					if (c.toString().equals(colorChoice.getSelectedItem())) {
						color = c;
						break;
					}
				}
								
				if (type == "cercle") {			
					drawRayon = Integer.parseInt(rayon.getText());
				}
				if (type == "rect") {			
					rectWidth = Integer.parseInt(width.getText());
					rectHeight = Integer.parseInt(height.getText());
				}
				d.setVisible(false);
			}
		});
		d.add(close);
		
		d.setLayout(new FlowLayout());
		d.setSize(450, 100);
		d.setVisible(true);
		
	}
	
	public int getDrawRayon() {
		return this.drawRayon;
	}
	public int getRectWidth() {
		return this.rectWidth;
	}
	public int getRectHeight() {
		return this.rectHeight;
	}
	public String getType() {
		return this.type;
	}
	
	public Color getColor() {
		return this.color;
	}
	
}

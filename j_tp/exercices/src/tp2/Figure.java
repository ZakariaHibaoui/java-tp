package tp2;

import java.awt.*;

public abstract class Figure {
	private Color couleur;
	private String name;
	
	public Figure() {}
	
	public void setColor(Color c) {
		this.couleur = c;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Color getColor() {
		return this.couleur;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.couleur);
	}
	
	public boolean contains(int x,int y) {
		return false;
	}
}

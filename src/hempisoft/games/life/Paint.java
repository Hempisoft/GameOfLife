package hempisoft.games.life;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Paint extends JPanel{
	
	private int width = 500;
	private int height = 300;
	public Paint() {
		this.setSize(width, height);
		Graphics g = null;
		super.paintComponent(g);
	}
}

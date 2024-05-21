package hempisoft.games.life;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	JFrame frame;
	private int width = 800, height = 630;

	public int[] getDim() {
		return new int[] { this.width, this.height };
	}

	public boolean isActive() {
		return true;
	}

	public Window(int width, int height) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel() {
			int width = 800, height = 600;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(0, 0, 0));
				g.fillRect(0, 0, this.width, this.height);
				g.setColor(new Color(200, 200, 200));
				g.drawRect(50, 50, width - 100, height - 100);
				repaint();
			}
		};
		frame.getContentPane().add(pane);
		// frame.pack();
		frame.setSize(this.width, this.height);
		frame.setVisible(true);
	}
}

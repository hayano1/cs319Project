package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class GuiCheckBox {
	private State currentState = State.FREE;
	private Rectangle clickBox;
	private ArrayList<ActionListener> listeners;
	private String text = "";
	private Color main;
	private Color clicked;

	private Font ftn0 = Game.main.deriveFont(20f);

	// private AudioHandler audio;

	public GuiCheckBox(int x, int y, int width) {
		clickBox = new Rectangle(x, y, width, width);
		listeners = new ArrayList<ActionListener>();
		main = new Color(173, 177, 179);
		clicked = new Color(111, 116, 117);
	}

	public void update() {
	}

	public void render(Graphics2D g) {
		if (currentState == State.CLICKED) {
			g.setColor(clicked);
			g.fill(clickBox);
		} else {
			g.setColor(main);
			g.fill(clickBox);
		}
		g.setColor(Color.black);
		g.setFont(ftn0);
		g.drawString(
				text,
				clickBox.x + clickBox.width / 2+ 20,
				clickBox.y + clickBox.height / 2
						+ DrawUtils.getMessageHeight(text, ftn0, g) / 2);
	}

	public void mousePressed(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			if (currentState == State.CLICKED) {
				currentState = State.FREE;
			} else {
				currentState = State.CLICKED;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			for (ActionListener al : listeners) {
				al.actionPerformed(null);
			}
		}
	}

	public int getX() {
		return clickBox.x;
	}

	public int getY() {
		return clickBox.y;
	}

	public int getHeight() {
		return clickBox.height;
	}

	public int getWidth() {
		return clickBox.width;
	}

	public void setText(String text) {
		this.text = text;
	}

	private enum State {
		CLICKED, FREE
	}

	public void addActionListener(ActionListener listener) {
		listeners.add(listener);
	}

}

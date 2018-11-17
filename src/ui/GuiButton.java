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

public class GuiButton {
	private State currentState = State.RELEASED;
	private Rectangle clickBox;
	private ArrayList<ActionListener> listeners;
	private String text = "";
	private Color main;
	private Color hover;
	private Color pressed;

	private Font ftn0 = Game.main.deriveFont(26f);

	// private AudioHandler audio;

	public GuiButton(int x, int y, int width, int height) {
		clickBox = new Rectangle(x, y, width, height);
		listeners = new ArrayList<ActionListener>();
		main = new Color(0, 0, 0);
		hover = new Color(27, 164, 185);
		pressed = new Color(111, 116, 117);
	}

	public void update() {
	}

	public void render(Graphics2D g) {
		if (currentState == State.HOVER) {
			g.setColor(hover);
			g.fill(clickBox);
		} else if (currentState == State.PRESSED) {
			g.setColor(pressed);
			g.fill(clickBox);
		} else {
			g.setColor(main);
			g.fill(clickBox);
		}
		g.setColor(Color.white);
		g.setFont(ftn0);
		g.drawString(
				text,
				clickBox.x + clickBox.width / 2
						- DrawUtils.getMessageWidth(text, ftn0, g) / 2,
				clickBox.y + clickBox.height / 2
						+ DrawUtils.getMessageHeight(text, ftn0, g) / 2);
	}

	public void mousePressed(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			currentState = State.PRESSED;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			for (ActionListener al : listeners) {
				al.actionPerformed(null);
			}
		}
		currentState = State.RELEASED;
	}

	public void mouseDragged(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			currentState = State.PRESSED;
		} else {
			currentState = State.RELEASED;
		}
	}

	public void mouseMoved(MouseEvent e) {
		if (clickBox.contains(e.getPoint())) {
			currentState = State.HOVER;
		} else {
			currentState = State.RELEASED;
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
		RELEASED, HOVER, PRESSED
	}

	public void addActionListener(ActionListener listener) {
		listeners.add(listener);
	}

}

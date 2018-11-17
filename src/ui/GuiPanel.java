package UI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Mechanics.Game;

public class GuiPanel {

	private ArrayList<GuiButton> buttons;
	private ArrayList<GuiCheckBox> chkbox;
	private Color main;
	private Rectangle clickBox;
	private Image image;

	public GuiPanel() {

		clickBox = new Rectangle(0, 0, Game.WIDTH, Game.HEIGHT);
		buttons = new ArrayList<GuiButton>();
		chkbox = new ArrayList<GuiCheckBox>();
		main = new Color(233,161,53);
	}

	void update() {
		for (GuiButton a : buttons) {
			a.update();
		}
		for (GuiCheckBox a : chkbox) {
			a.update();
		}
	}

	public void add(GuiButton button) {
		buttons.add(button);
	}

	public void remove(GuiButton button) {
		buttons.remove(button);
	}

	public void add(GuiCheckBox checkbox) {
		chkbox.add(checkbox);
	}

	public void remove(GuiCheckBox checkbox) {
		chkbox.remove(checkbox);
	}

	void render(Graphics2D g) {

		g.setColor(main);
		g.fill(clickBox);

		// image = getImage();
		// g.drawImage(image, 0, 0, null);

		for (GuiButton a : buttons) {
			a.render(g);
		}
		for (GuiCheckBox a : chkbox) {
			a.render(g);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (GuiButton a : buttons) {
			a.mousePressed(e);
		}
		for (GuiCheckBox a : chkbox) {
			a.mousePressed(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		for (GuiButton a : buttons) {
			a.mouseReleased(e);
		}
		for (GuiCheckBox a : chkbox) {
			a.mouseReleased(e);
		}
	}

	public void mouseDragged(MouseEvent e) {
		for (GuiButton a : buttons) {
			a.mouseDragged(e);
		}
	}

	public void mouseMoved(MouseEvent e) {
		for (GuiButton a : buttons) {
			a.mouseMoved(e);
		}
	}

	@SuppressWarnings("unused")
	private static Image getImage() {
		Image image = null;
		image = new ImageIcon("res/bg.jpg").getImage();
		return image;
	}
}

package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class playPanel extends GuiPanel {

	private Font titleFont = Game.main.deriveFont(100f);
	private String Title = "";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;
	private Image image;

	public playPanel() {
		super();
		GuiButton newGameButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh
				/ 2, 220, buttonWitdh, buttonHeight);
		GuiButton loadGameButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh
				/ 2, 310, buttonWitdh, buttonHeight);
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				490, buttonWitdh, buttonHeight);

		newGameButton.setText("NEW GAME");
		loadGameButton.setText("LOAD GAME");
		backButton.setText("BACK");

		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("newGamePanel");
			}
		});
		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("loadGamePanel");
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});

		add(newGameButton);
		add(loadGameButton);
		add(backButton);
	}

	public void render(Graphics2D g) {
		super.render(g);
		image = getImage();
//		g.drawImage(image, 100, 200, null);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(Title,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g)
						/ 2, 150);

	}
	private static Image getImage() {
		Image image = null;
		image = new ImageIcon("res/board.jpg").getImage();
		return image;
	}
}

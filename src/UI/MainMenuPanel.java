package UI;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mechanics.Game;

public class MainMenuPanel extends GuiPanel {

	private Font titleFont = Game.main.deriveFont(100f);
	// private String Title = "Puzzler Pro";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;
	private Image image;

	public MainMenuPanel() {
		super();
		GuiButton playButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				340, buttonWitdh, buttonHeight);
		GuiButton optionsButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh
				/ 2, 410, buttonWitdh, buttonHeight);
		GuiButton creditsButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh
				/ 2, 480, buttonWitdh, buttonHeight);
		GuiButton exitButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				550, buttonWitdh, buttonHeight);

		playButton.setText("PLAY");
		optionsButton.setText("OPTIONS");
		creditsButton.setText("CREDITS");
		exitButton.setText("EXIT");

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("playPanel");
			}
		});
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("optionsPanel");
			}
		});

		creditsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("creditsPanel");
			}
		});

		exitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});

		add(playButton);
		add(optionsButton);
		add(creditsButton);
		add(exitButton);
	}

	public void render(Graphics2D g) {
		super.render(g);

		image = getImage();
		g.drawImage(image, 375, 70, null);

		// g.setFont(titleFont);
		// g.setColor(Color.black);
		// g.drawString(Title,
		// Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g)
		// / 2+30, 150);

	}

	private static Image getImage() {
		Image image = null;
		image = new ImageIcon("res/logo2.jpg").getImage();
		return image;
	}
}

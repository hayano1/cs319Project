package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class pausePanel extends GuiPanel {
	private Font titleFont = Game.main.deriveFont(70f);
	private String Title = "Pause Menu";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;

	public pausePanel() {
		super();

		GuiButton resumeButton = new GuiButton(
				Game.WIDTH / 2 - buttonWitdh / 2, 220, buttonWitdh,
				buttonHeight);
		GuiButton SaveButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				310, buttonWitdh, buttonHeight);
		GuiButton HelpButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				400, buttonWitdh, buttonHeight);
		GuiButton mainMenuButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh
				/ 2, 490, buttonWitdh, buttonHeight);

		resumeButton.setText("Resume");
		SaveButton.setText("Save Game");
		HelpButton.setText("Help");
		mainMenuButton.setText("Main Menu");

		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("play2DPanel");
			}
		});
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		HelpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});

		add(resumeButton);
		add(SaveButton);
		add(HelpButton);
		add(mainMenuButton);

	}

	public void render(Graphics2D g) {
		super.render(g);

		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(Title,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g)
						/ 2, 150);

	}

}

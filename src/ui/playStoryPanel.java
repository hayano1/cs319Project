package UI;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.Game;

public class playStoryPanel extends GuiPanel {

	// Game Over
	boolean GAMEOVER = false;
	private GuiButton tryAgainButton;
	private GuiButton mainMenuButton;
	private GuiButton screenShotButton;
	private int smallButtonWidth = 160;
	private int spacing = 20;
	private int largeButtonWidth = smallButtonWidth * 2 + spacing;
	private int buttonHeight = 50;
	private boolean added;

	public playStoryPanel() {

		mainMenuButton = new GuiButton(Game.WIDTH / 2 - largeButtonWidth / 2,
				500, largeButtonWidth, buttonHeight);
		tryAgainButton = new GuiButton(mainMenuButton.getX(),
				mainMenuButton.getY() - spacing - buttonHeight,
				smallButtonWidth, buttonHeight);
		screenShotButton = new GuiButton(tryAgainButton.getX()
				+ tryAgainButton.getWidth() + spacing, tryAgainButton.getY(),
				smallButtonWidth, buttonHeight);

		tryAgainButton.setText("Try Again");
		screenShotButton.setText("Screenshot");
		mainMenuButton.setText("Back to Main Menu");

		tryAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("playPanel");
			}
		});

		screenShotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});

	}

	private void drawGui(Graphics2D g) {

	}

	public void drawGameOver(Graphics2D g) {

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics2D g) {
		drawGui(g);
		GAMEOVER = true;
		added = false;

		if (GAMEOVER) {
			if (!added) {
				added = true;
				add(mainMenuButton);
				add(screenShotButton);
				add(tryAgainButton);
			}
			drawGameOver(g);
		}
		super.render(g);
	}
}
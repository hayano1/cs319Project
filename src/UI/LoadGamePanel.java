package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class LoadGamePanel extends GuiPanel {

	private Font titleFont = Game.main.deriveFont(50);
	private String Title = "Select the Load Game";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;

	public LoadGamePanel() {
		super();

		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				490, buttonWitdh, buttonHeight);

		backButton.setText("BACK");

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("playPanel");
			}
		});

		add(backButton);
	}

	public void render(Graphics2D g) {
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(Title,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g)
						/ 2, 100);

	}
}
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class optionsPanel extends GuiPanel {
	private boolean b1 = false;
	private boolean b2 = false;
	private Font titleFont = Game.main.deriveFont(70f);
	private String Title = "Options Menu";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;

	public optionsPanel() {
		super();

		GuiCheckBox sndchk = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh, 250,
				20);
		GuiCheckBox sndchk2 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh,
				300, 20);
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				490, buttonWitdh, buttonHeight);

		sndchk.setText("Sound ON/OFF");
		sndchk2.setText("Music ON/OFF");
		backButton.setText("BACK");

		sndchk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (b1 == false) {
					// SOUNDS OFF FUNCTION GOES HERE
				} else {
					// SOUNDS ON FUNCTION GOES HERE
				}
			}
		});

		sndchk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (b2 == false) {
					// SOUNDS OFF FUNCTION GOES HERE
				} else {
					// SOUNDS ON FUNCTION GOES HERE
				}
			}
		});

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});

		add(sndchk);
		add(sndchk2);
		add(backButton);
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

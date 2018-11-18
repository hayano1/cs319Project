
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class creditsPanel extends GuiPanel {
	private Font titleFont = Game.main.deriveFont(70f);
	private String Title = "Credits";
	private String credits1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
	private String credits2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
	private String credits3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
	private Font textFont = Game.main.deriveFont(20f);
	private int buttonWitdh = 300;
	private int buttonHeight = 60;



	public creditsPanel() {
		super();

		
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2,
				490, buttonWitdh, buttonHeight);

		backButton.setText("BACK");
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
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
						/ 2, 150);
		
		g.setFont(textFont);
		g.setColor(Color.black);
		g.drawString(credits1,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(credits1, textFont, g)
						/ 2 -100, 240);
		g.setFont(textFont);
		g.setColor(Color.black);
		g.drawString(credits2,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(credits2, textFont, g)
						/ 2 -100, 330);
		g.setFont(textFont);
		g.setColor(Color.black);
		g.drawString(credits3,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(credits3, textFont, g)
						/ 2 -100, 420);

	}
	

	
}


package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class inGameOptions extends GuiPanel {

	private Font titleFont = Game.main.deriveFont(60f);
	private Font font = Game.main.deriveFont(30f);
	private String Title = "Select Game Options";
	private String difficulty = "Select Game Difficulty";
	private String BoardSize = "Select Game Size";
	private String BoardType = "Select Board Type ";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;

	public inGameOptions() {
	super();
		
		GuiCheckBox chk1 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh +300, 180,
				20);
		GuiCheckBox chk2 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh +470,
				180, 20);
		
		chk1.setText("Square");
		chk2.setText("Diamond");
		
		
		
		GuiCheckBox chk3 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh +300,
				280, 20);
		GuiCheckBox chk4 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh+ 470,
				280, 20);
		
		chk3.setText("X");
		chk4.setText("Y");
		
		
		
		
		GuiCheckBox chk5 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh +300,
				380, 20);
		GuiCheckBox chk6 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh+470,
				380, 20);
		GuiCheckBox chk7 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh+300,
				480, 20);
		GuiCheckBox chk8 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh+470, 
				480, 20);
		GuiCheckBox chk9 = new GuiCheckBox(Game.WIDTH / 2 - buttonWitdh + 640,
				480, 20);
		
		
		chk5.setText("Izi");
		chk6.setText("Easy");
		chk7.setText("Medium");
		chk8.setText("Hard");
		chk9.setText("Extreme");
		
		
		GuiButton continueButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2+300,
				540, buttonWitdh, buttonHeight);
		
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWitdh / 2-300,
				540, buttonWitdh, buttonHeight);

		backButton.setText("BACK");
		continueButton.setText("CONTINUE");

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("play2DPanel");
			}
		}); 
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("newGamePanel");
			}
		});
		
		add(chk1);
		add(chk2);
		add(chk3);
		add(chk4);
		add(chk5);
		add(chk6);
		add(chk7);
		add(chk8);
		add(chk9);
		add(backButton);
		add(continueButton);
	}

	public void render(Graphics2D g) {
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(Title,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g)
						/ 2, 75);
		g.drawString(BoardType,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(BoardType, font, g)
						/ 2- 230, 200);
		g.drawString(BoardSize,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(BoardSize, font, g)
						/ 2 - 240, 300);
		g.drawString(difficulty,
				Game.WIDTH / 2 - DrawUtils.getMessageWidth(difficulty, font, g)
						/ 2- 200, 400);

	}
}

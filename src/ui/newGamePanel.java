package UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mechanics.DrawUtils;
import Mechanics.Game;

public class newGamePanel extends GuiPanel{
	
	private Font titleFont = Game.main.deriveFont(60f);
	private String Title = "Select Game Mode";
	private int buttonWitdh = 300;
	private int buttonHeight = 60;
	
	public newGamePanel(){
		super();
		GuiButton d2button = new GuiButton(Game.WIDTH/2 -buttonWitdh/2 ,220 ,buttonWitdh ,buttonHeight);
		GuiButton d3button = new GuiButton(Game.WIDTH/2 -buttonWitdh/2, 310, buttonWitdh,buttonHeight);
		GuiButton storybutton = new GuiButton(Game.WIDTH/2 -buttonWitdh/2, 400, buttonWitdh,buttonHeight);
		GuiButton backButton = new GuiButton(Game.WIDTH/2 -buttonWitdh/2, 490, buttonWitdh,buttonHeight);
		
		d2button.setText("2D GAME");
		d3button.setText("3D GAME");
		storybutton.setText("STORY MODE");
		backButton.setText("BACK");
				
		
		d2button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("inGameOptionsPanel");	
			}
		});
		d3button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("play3DPanel");	
			}
		});
		storybutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("playStoryPanel");	
			}
		});
		
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("playPanel");	
			}
		});
		
		add(d2button);
		add(d3button);
		add(storybutton);
		add(backButton);
	}
	
	public void render(Graphics2D g){
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(Title, Game.WIDTH / 2 - DrawUtils.getMessageWidth(Title, titleFont, g) / 2, 150);

	}
}

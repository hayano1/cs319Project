package Generated;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import OurTimer.TimerPanel;
import UI.panelTemp;

public class allGamesPanelHere extends panelTemp {

	private JLabel timer;
	private JLabel currLevel;
	private JButton getHint;
	
	
	public allGamesPanelHere(int boardWidth, int boardHeight, int boardType){
	
		this.setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		Board board = new Board(boardWidth, boardHeight, boardType);
		TimerPanel counter = new TimerPanel(6);
		
		
		
		currLevel = new JLabel("Level: 1");
		
		getHint = new JButton("Get Hint");
		getHint.setFont(new Font("Gadugi", Font.BOLD, 24));
		getHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Getting Hint");
			}
		});
		
		
		infoPanel.add(counter);
		//infoPanel.add(currLevel);
		//infoPanel.add(getHint);
		
		this.add(board, BorderLayout.CENTER);		
		this.add(infoPanel, BorderLayout.EAST);
	
		
		
	}
	
	
	
}

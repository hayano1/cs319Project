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
import UI.pausePanel;

public class allGamesPanelHere extends panelTemp  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel currLevel;
	private JButton getHint;
	
	private Board board;
	
	
	public allGamesPanelHere(int boardWidth, int boardHeight, int boardType){
	
		this.setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		board = new Board(boardWidth, boardHeight, boardType);
		TimerPanel counter = new TimerPanel(6);
		//addKeyListener(this);
		
		this.requestFocus();
		this.grabFocus();
		this.setFocusable(true);
		
		
		currLevel = new JLabel("Level: 1");
		
		getHint = new JButton("Get Hint");
		getHint.setFont(new Font("Gadugi", Font.BOLD, 24));
		getHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Getting Hint");
			}
		});
		
		
		//infoPanel.add(counter);
		//infoPanel.add(currLevel);
		
		this.add(board, BorderLayout.CENTER);		
		//this.add(infoPanel, BorderLayout.EAST);
		
		
	
		
		
	}
	
	public void displayPauseMenu() {
    	
    	pausePanel p = new pausePanel();
    	
    	this.add(p, BorderLayout.EAST);
    	
    	
    }
	
	
//	public void keyPressed(KeyEvent evt) {
//
//		System.out.println("Key PRessed");
//
//	}
//	public void keyReleased(KeyEvent evt) {
//		// TODO Auto-generated method stub
//		int keyCode = evt.getKeyCode();
//		System.out.println("SADSDA");
//
//		// add any key as below
//		if (board.selectedPiece != null) {
//
//			board.playMusic(3);
//
//			if (keyCode == KeyEvent.VK_LEFT) {
//				System.out.println("Left");
//				board.selectedPiece.rotateCounterClock();
//				main.window.repaint();
//			}
//
//			else if (keyCode == KeyEvent.VK_RIGHT) {
//				System.out.println("Right");
//				board.selectedPiece.rotateClock();
//				main.window.repaint();
//			}
//
//			else if (keyCode == KeyEvent.VK_UP) {
//				System.out.println("UP");
//				board.selectedPiece.rotateRespecttoY();
//				main.window.repaint();
//			}
//
//			else if (keyCode == KeyEvent.VK_DOWN) {
//				System.out.println("Down");
//				board.selectedPiece.rotateRespecttoX();
//				main.window.repaint();
//			}
//
//			else if (keyCode == KeyEvent.VK_ESCAPE) {
//				// pause panel dont change this
//				activatedPanel = 9;
//
//			}
//		}
//		else if( keyCode == KeyEvent.VK_ESCAPE) {
//			
//			System.out.println("Escape Pressed");
//			
//		
//			
//		}
//	}
//	public void keyTyped(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}
//

	
	
	
}

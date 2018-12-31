package Generated;

import AllPanels.pausePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import OurTimer.TimerPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class allGamesPanelHere extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel currLevel;
        private static Board board;
        private static JPanel infoPanel;
        public static TimerPanel counter;
        public static pausePanel pausePanel;
        public static JPanel tempPanel;
	
	public allGamesPanelHere(int boardWidth, int boardHeight, int boardType, String gameMode ,String level){
	
                tempPanel = new JPanel();
                tempPanel.setLayout(new BorderLayout());
            
		this.setLayout(new BorderLayout());
                //addKeyListener(this);
                this.requestFocus();
                
                
		
                pausePanel = new pausePanel(boardType);
                pausePanel.setVisible(false);
                
                
		infoPanel = new JPanel();
		board = new Board(boardWidth, boardHeight , boardType,  gameMode ,level);
		counter = new TimerPanel(6);
			counter.setSize(170,170);
			counter.setPreferredSize(new Dimension(170,30));
		
		infoPanel.setPreferredSize(new Dimension(150,200));
		infoPanel.setMaximumSize(new Dimension(150,200));
		
	
		currLevel = new JLabel("Level: " + level);
			currLevel.setSize(150,150);
			currLevel.setPreferredSize(new Dimension(150,30));
			currLevel.setFont(new Font("Gadugi", Font.BOLD, 24));
		

		infoPanel.add(currLevel);
		infoPanel.add(counter);
		
		//tempPanel.add(pausePanel, BorderLayout.CENTER);
		tempPanel.add(board, BorderLayout.CENTER);	
                
		tempPanel.add(infoPanel, BorderLayout.WEST);
		
                this.add(tempPanel, BorderLayout.CENTER);

        counter.startTime();
		
	}
	
   
    public static void changeMiddle(){
        
        System.out.println("Trying to change now");
        
        if( !pausePanel.isVisible() ){
            System.out.println("Pause is not visible");
            
            
            tempPanel.remove(board);
            tempPanel.remove(infoPanel);
            tempPanel.add(pausePanel, BorderLayout.CENTER);
            
            board.setVisible(false);
            pausePanel.setVisible(true);
            
            tempPanel.revalidate();
            tempPanel.repaint();
            
            //pausePanel.setFocusable(true);
            
        }
        else{
            System.out.println("Pause is visible");
            
            tempPanel.remove(pausePanel);
            tempPanel.add(board, BorderLayout.CENTER);
            tempPanel.add(infoPanel, BorderLayout.WEST);
            
            board.setVisible(true);
            pausePanel.setVisible(false);
        }
        
        
    }
    
}


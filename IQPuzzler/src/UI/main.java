package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Generated.Board;
import Generated.allGamesPanelHere;

public class main {

	private JPanel contentPane;
	public static JFrame window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//main frame = new main();
					window = new JFrame("Game");
					window.setVisible(true);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setSize(new Dimension(1200,600));
					
					allGamesPanelHere allGamesPanelHere = new allGamesPanelHere(11,5,1);
					
					window.add(allGamesPanelHere);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		
		
		//Dimension size = frame.getBounds().getSize()
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Height: " + screenSize.getHeight() + "    Width: " + screenSize.getWidth());
		
		int xFrame, yFrame;
		int xfWidth, xfHeight;
		
		xFrame = (int) (0.1*screenSize.getWidth());
		yFrame = (int) (0.1*screenSize.getHeight());
		
		xfWidth = (int) (0.8*screenSize.getWidth());
		xfHeight = (int) (0.8*screenSize.getHeight());
		
		
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(xFrame, yFrame, xfWidth, xfHeight);
		// setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		window.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// CALL YOUR GAME PANELS HERE
		// YOUR PANEL MUST EXTEND panelTemp ÝNSTEAD OFF JPANEL

		// EXAMPLE -----> public class MainMenuPanel extends panelTemp

		final MainMenuPanel mp = new MainMenuPanel();
		final playPanel pp = new playPanel();
		final newGamePanel np = new newGamePanel();
		final gameOptionsPanel gop = new gameOptionsPanel();
		final optionsPanel op = new optionsPanel();
		final creditsPanel cp = new creditsPanel();
		final allGamesPanelHere allGamesPanelHere = new allGamesPanelHere(11,5,0);
		final pausePanel ppp = new pausePanel();

		int delay = 100;

		ActionListener aa = new ActionListener() {
			panelTemp currentPanel = mp;


			public void actionPerformed(ActionEvent arg0) {
				 if (op.sounds == 1)
				 {
					 System.out.println("sounds on");
				 }else
				 {
					 //System.out.println("sounds off");
				 }
				 
				if(true) {
					contentPane.removeAll();
					contentPane.add(allGamesPanelHere, BorderLayout.CENTER);
					//contentPane.add(mp, BorderLayout.CENTER);
					currentPanel.activatedPanel = 0;
					//currentPanel = mp;
					currentPanel = allGamesPanelHere;
					window.revalidate();
					window.repaint();
				}
//				else if (currentPanel.activatedPanel == 1) {
//					contentPane.removeAll();
//					contentPane.add(allGamesPanelHere, BorderLayout.CENTER);
//					//contentPane.add(mp, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					//currentPanel = mp;
//					currentPanel = allGamesPanelHere;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 2) {
//					contentPane.removeAll();
//					contentPane.add(pp, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = pp;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 3) {
//					contentPane.removeAll();
//					contentPane.add(np, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = np;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 4) {
//					contentPane.removeAll();
//					contentPane.add(gop, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = gop;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 5) {
//					contentPane.removeAll();
//					contentPane.add(op, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = op;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 6) {
//					contentPane.removeAll();
//					contentPane.add(cp, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = cp;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 8) {
//
//					contentPane.removeAll();
//					contentPane.add(allGamesPanelHere, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = allGamesPanelHere;
//					window.revalidate();
//					window.repaint();
//				} else if (currentPanel.activatedPanel == 7) {
//					contentPane.removeAll();
//					contentPane.add(allGamesPanelHere, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = allGamesPanelHere;
//
//					window.revalidate();
//					window.repaint();
//
//				} else if (currentPanel.activatedPanel == 9) {
//
//					contentPane.removeAll();
//					contentPane.add(ppp, BorderLayout.CENTER);
//					currentPanel.activatedPanel = 0;
//					currentPanel = ppp;
//					window.revalidate();
//					window.repaint();
//				}
//
//				else if (currentPanel.activatedPanel == -1) {
//					System.exit(0);
//
//				}
			}
		};
		//new Timer(delay, aa).start();
		//contentPane.add(mp, BorderLayout.CENTER);

	}

}

/*
 * main menu 1
 * 
 * 1 MainMenuPanel(); 2 playPanel(); 3 newGamePanel(); 4 gameOptionsPanel(); 5
 * optionsPanel(); 6 creditsPanel(); 7 YOUR RANDOM GAME PANEL 8 YOUR STORY MODE
 * PANEL 9 pause panel 
 */
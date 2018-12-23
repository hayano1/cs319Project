package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Generated.Board;
import Generated.allGamesPanelHere;

public class main {

	public static JPanel contentPane;

	public static JFrame window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					main frame = new main();
					window.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(450, 200, 1000, 630);
		// setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		window.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		final MainMenuPanel mp = new MainMenuPanel();
		final playPanel pp = new playPanel();
		final newGamePanel np = new newGamePanel();
		final gameOptionsPanel gop = new gameOptionsPanel();
		final optionsPanel op = new optionsPanel();
		final creditsPanel cp = new creditsPanel();
		final pausePanel ppp = new pausePanel();
		final winPanel wp = new winPanel();
		final allGamesPanelHere boardc115 = new allGamesPanelHere(11, 5, 0);
		final allGamesPanelHere boardd115 = new allGamesPanelHere(11, 5, 1);
		final Board board = new Board(11,5,0);

		int delay = 100;

		ActionListener aa = new ActionListener() {
			panelTemp currentPanel = mp;

			public void actionPerformed(ActionEvent arg0) {
				if (panelTemp.activatedPanel == 1) {
					contentPane.removeAll();
					contentPane.add(mp, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = mp;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 2) {
					contentPane.removeAll();
					contentPane.add(pp, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = pp;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 3) {
					contentPane.removeAll();
					contentPane.add(np, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = np;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 4) {
					contentPane.removeAll();
					contentPane.add(gop, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = gop;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 5) {
					contentPane.removeAll();
					contentPane.add(op, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = op;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 6) {
					contentPane.removeAll();
					contentPane.add(cp, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = cp;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 7) {
					// classic 11 x 5
					if (currentPanel.type == 0) {
						contentPane.removeAll();
						contentPane.add(boardc115, BorderLayout.CENTER);
						panelTemp.activatedPanel = 0;
						currentPanel = board;
					} else if (currentPanel.type == 1) {
						contentPane.removeAll();
						contentPane.add(boardd115, BorderLayout.CENTER);
						panelTemp.activatedPanel = 0;
						currentPanel = board;
					}

					window.revalidate();
					window.repaint();

				
				} else if (panelTemp.activatedPanel == 9) {
					contentPane.removeAll();
					contentPane.add(ppp, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = ppp;
					window.revalidate();
					window.repaint();
				} else if (panelTemp.activatedPanel == 10) {
					contentPane.removeAll();
					contentPane.add(wp, BorderLayout.CENTER);
					panelTemp.activatedPanel = 0;
					currentPanel = wp;
					window.revalidate();
					window.repaint();
				}

				else if (panelTemp.activatedPanel == -1) {
					System.exit(0);

				}
			}
		};
		new Timer(delay, aa).start();
		contentPane.add(mp, BorderLayout.CENTER);

	}

}

/*
 * main menu 1
 * 
 * 1 MainMenuPanel(); 2 playPanel(); 3 newGamePanel(); 4 gameOptionsPanel(); 5
 * optionsPanel(); 6 creditsPanel(); 7 YOUR RANDOM GAME PANEL 8 YOUR STORY MODE
 * PANEL 9 pause panel 10 winPanel();
 */
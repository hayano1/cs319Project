package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainMenuPanel extends panelTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(380, 65, 242, 242);
		lblNewLabel.setIcon(new ImageIcon(main.class
				.getResource("/images/logo2.jpg")));
		add(lblNewLabel);

		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 2;
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(350, 325, 300, 55);
		add(btnNewButton);

		JButton btnOptons = new JButton("OPTIONS");
		btnOptons.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnOptons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 5;
			}
		});
		btnOptons.setForeground(Color.WHITE);
		btnOptons.setBackground(Color.BLACK);
		btnOptons.setBounds(350, 385, 300, 55);
		// btnOptons.setFont("VAG ROUNDED", Font.BOLD, 28);

		add(btnOptons);

		JButton btnCredts = new JButton("CREDITS");
		btnCredts.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnCredts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 6;
			}
		});
		btnCredts.setForeground(Color.WHITE);
		btnCredts.setBackground(Color.BLACK);
		btnCredts.setBounds(350, 445, 300, 55);
		add(btnCredts);

		JButton btnExt = new JButton("EXIT");
		btnExt.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = -1;
			}
		});

		btnExt.setForeground(Color.WHITE);
		btnExt.setBackground(Color.BLACK);
		btnExt.setBounds(350, 505, 300, 55);
		add(btnExt);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);
	}

}

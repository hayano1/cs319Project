package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class playPanel extends panelTemp {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public playPanel() {

		setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(380, 65, 242, 242);
		lblNewLabel.setIcon(new ImageIcon(main.class
				.getResource("/images/logo2.jpg")));
		add(lblNewLabel);

		JButton btnNewButton = new JButton("NEW GAME");
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 3;

			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(350, 325, 300, 55);
		add(btnNewButton);

		JButton btnOptons = new JButton("LOAD GAME");
		btnOptons.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnOptons.setForeground(Color.WHITE);
		btnOptons.setBackground(Color.BLACK);
		btnOptons.setBounds(350, 385, 300, 55);
		add(btnOptons);

		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 1;
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(350, 445, 300, 55);
		add(btnBack);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);

	}

}

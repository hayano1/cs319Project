package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class newGamePanel extends panelTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public newGamePanel() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(380, 65, 242, 242);
		lblNewLabel.setIcon(new ImageIcon(main.class
				.getResource("/images/logo2.jpg")));
		add(lblNewLabel);

		JButton btnNewButton = new JButton("RANDOM");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 4;
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(350, 325, 300, 55);
		add(btnNewButton);

		JButton btnOptons = new JButton("STORY MODE");
		btnOptons.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnOptons.setForeground(Color.WHITE);
		btnOptons.setBackground(Color.BLACK);
		btnOptons.setBounds(350, 385, 300, 55);
		add(btnOptons);

		JButton btnExt = new JButton("BACK");
		btnExt.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 2;
			}
		});
		btnExt.setForeground(Color.WHITE);
		btnExt.setBackground(Color.BLACK);
		btnExt.setBounds(350, 445, 300, 55);
		add(btnExt);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);

	}

}

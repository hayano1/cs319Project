package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class creditsPanel extends panelTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public creditsPanel() {
		setLayout(null);

		JButton btnExt = new JButton("BACK");
		btnExt.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 1;
			}
		});
		btnExt.setForeground(Color.WHITE);
		btnExt.setBackground(Color.BLACK);
		btnExt.setBounds(350, 455, 300, 55);
		add(btnExt);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);

	}

}

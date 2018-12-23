package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class pausePanel extends panelTemp {
	private static final long serialVersionUID = 1L;

	public pausePanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		JButton resume = new JButton("RESUME");
		resume.setFont(new Font("Gadugi", Font.BOLD, 24));
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 7;
			}
		});
		resume.setForeground(Color.WHITE);
		resume.setBackground(Color.BLACK);
		resume.setBounds(350, 192, 300, 55);
		add(resume);
		
		JButton mm = new JButton("MAIN MENU");
		mm.setFont(new Font("Gadugi", Font.BOLD, 24));
		mm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 1;
			}
		});
		mm.setForeground(Color.WHITE);
		mm.setBackground(Color.BLACK);
		mm.setBounds(350, 328, 300, 55);
		add(mm);
		
		JButton button = new JButton("HELP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Gadugi", Font.BOLD, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(350, 260, 300, 55);
		add(button);
		

//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setBackground(Color.BLACK);
//		lblNewLabel_1.setIcon(new ImageIcon(main.class
//				.getResource("/images/bg.jpg")));
//		lblNewLabel_1.setBounds(0, 0, 1000, 630);
//		add(lblNewLabel_1);

	}
}

package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class winPanel extends panelTemp {
	private static final long serialVersionUID = 1L;

	public winPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		
		JLabel label_1 = new JLabel("CONGRATULATIONS!!");
		label_1.setFont(new Font("Gadugi", Font.BOLD, 40));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(290, 70, 500, 75);
		add(label_1);
		
		JLabel label_11 = new JLabel("You won...");
		label_11.setFont(new Font("Gadugi", Font.BOLD, 30));
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(430,140, 224, 49);
		add(label_11);
		
		
		JButton resume = new JButton("PLAY AGAIN");
		resume.setFont(new Font("Gadugi", Font.BOLD, 24));
		resume.setForeground(Color.WHITE);
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 7;
			}
		});
		resume.setForeground(Color.WHITE);
		resume.setBackground(Color.BLACK);
		resume.setBounds(350, 300, 300, 55);
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
		mm.setBounds(350, 420, 300, 55);
		add(mm);
		
		JButton button = new JButton("HELP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Gadugi", Font.BOLD, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(350, 360, 300, 55);
		add(button);
		

//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setBackground(Color.BLACK);
//		lblNewLabel_1.setIcon(new ImageIcon(main.class
//				.getResource("/images/bg.jpg")));
//		lblNewLabel_1.setBounds(0, 0, 1000, 630);
//		add(lblNewLabel_1);

	}
}

package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		
		JLabel title = new JLabel("2G - IQ Puzzler Pro Team");
		title.setFont(new Font("Gadugi", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(265, 71, 426, 75);
		add(title);
		
		
		JLabel name0 = new JLabel("KAAN ALTINAY - 21501275");
		name0.setFont(new Font("Gadugi", Font.BOLD, 24));
		name0.setHorizontalAlignment(SwingConstants.CENTER);
		name0.setBounds(200, 150, 600, 75);
		add(name0);
		JLabel name1 = new JLabel("SKERD XHAFA - 21503353");
		name1.setFont(new Font("Gadugi", Font.BOLD, 24));
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setBounds(200, 200, 600, 75);
		add(name1);
		JLabel name2 = new JLabel("MUHAMMED UMAIR AHMED - 21600539");
		name2.setFont(new Font("Gadugi", Font.BOLD, 24));
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setBounds(200, 250, 600, 75);
		add(name2);
		JLabel name3 = new JLabel("ALIYU SAIFULLAH VANDANA - 21603047");
		name3.setFont(new Font("Gadugi", Font.BOLD, 24));
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setBounds(200, 300, 600, 75);
		add(name3);
		JLabel name4 = new JLabel("BURAK ALAYDIN - 21603427");
		name4.setFont(new Font("Gadugi", Font.BOLD, 24));
		name4.setHorizontalAlignment(SwingConstants.CENTER);
		name4.setBounds(200, 350, 600, 75);
		add(name4);
		
		
		
		
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

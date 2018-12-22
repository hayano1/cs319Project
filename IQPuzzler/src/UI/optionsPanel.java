package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class optionsPanel extends panelTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  int sounds;

	/**
	 * Create the panel.
	 */
	public optionsPanel() {
		setLayout(null);

		JLabel volumeLabel = new JLabel("SOUNDS");
		volumeLabel.setFont(new Font("Gadugi", Font.BOLD, 24));
		volumeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumeLabel.setBounds(100, 270, 483, 50);
		add(volumeLabel);

		JButton button = new JButton("BACK");
		button.setFont(new Font("Gadugi", Font.BOLD, 24));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setBounds(350, 450, 300, 55);
		add(button);
		

		final JRadioButton rdbtnClassic = new JRadioButton("ON/OFF");
		rdbtnClassic.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnClassic.setForeground(Color.BLACK);
		rdbtnClassic.setBackground(new Color(255, 204, 0));
		rdbtnClassic.setBounds(550, 270, 150, 50);
		add(rdbtnClassic);

		JLabel lblSelectGameOptons = new JLabel("OPTIONS");
		lblSelectGameOptons.setFont(new Font("Gadugi", Font.BOLD, 35));
		lblSelectGameOptons.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectGameOptons.setBounds(300, 100, 400, 75);
		add(lblSelectGameOptons);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);

		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnClassic.isSelected()){
					sounds = 1;
				}
				else{
					sounds = 0;
				}
				activatedPanel = 1;
			}
		});
		// button.setBounds(68, 483, 124, 55);

	}
}

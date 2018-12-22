package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class gameOptionsPanel extends panelTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public gameOptionsPanel() {
		setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setIcon(new ImageIcon(main.class
				.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1000, 630);
		add(lblNewLabel_1);
		

		JLabel lblBoardType = new JLabel("Board Size");
		lblBoardType.setFont(new Font("Gadugi", Font.BOLD, 25));
		lblBoardType.setBounds(68, 174, 182, 66);
		add(lblBoardType);

		JLabel label = new JLabel("Board Type");
		label.setFont(new Font("Gadugi", Font.BOLD, 25));
		label.setBounds(68, 236, 182, 66);
		add(label);

		JLabel label_1 = new JLabel("Game Difficulty");
		label_1.setFont(new Font("Gadugi", Font.BOLD, 25));
		label_1.setBounds(68, 315, 224, 49);
		add(label_1);

		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// THÝS LEADS TO YOUR PANEL BY CHANGÝNG CURRENT PANEL
				// UNCOMMENT THÝS AFTER YOU ADD YOUR PANEL
				activatedPanel = 7;
			}
		});
		btnNext.setFont(new Font("Gadugi", Font.BOLD, 24));
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(Color.BLACK);
		btnNext.setBounds(750, 483, 124, 55);
		add(btnNext);



		JLabel lblSelectGameOptons = new JLabel("SELECT GAME OPTIONS");
		lblSelectGameOptons.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSelectGameOptons.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectGameOptons.setBounds(265, 71, 426, 75);
		add(lblSelectGameOptons);

		JButton button = new JButton("BACK");
		button.setFont(new Font("Gadugi", Font.BOLD, 24));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activatedPanel = 3;
			}
		});
		button.setBounds(100, 483, 124, 55);
		add(button);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("11X5");
		rdbtnNewRadioButton.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnNewRadioButton.setForeground(Color.BLACK);
		rdbtnNewRadioButton.setBackground(new Color(255, 204, 0));
		rdbtnNewRadioButton.setBounds(300, 186, 127, 37);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnx = new JRadioButton("16x16");
		rdbtnx.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnx.setForeground(Color.BLACK);
		rdbtnx.setBackground(new Color(255, 192, 0));
		rdbtnx.setBounds(475, 186, 127, 37);
		add(rdbtnx);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnx);
		
		
		
		
		

		JRadioButton rdbtnClassic = new JRadioButton("Classic");
		rdbtnClassic.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnClassic.setForeground(Color.BLACK);
		rdbtnClassic.setBackground(new Color(255, 192, 0));
		rdbtnClassic.setBounds(300, 248, 127, 37);
		add(rdbtnClassic);

		JRadioButton rdbtnDiamond = new JRadioButton("Diamond");
		rdbtnDiamond.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnDiamond.setForeground(Color.BLACK);
		rdbtnDiamond.setBackground(new Color(255, 192, 0));
		rdbtnDiamond.setBounds(475, 248, 174, 37);
		add(rdbtnDiamond);
		
		
		ButtonGroup shape = new ButtonGroup();
		shape.add(rdbtnClassic);
		shape.add(rdbtnDiamond);

		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnEasy.setForeground(Color.BLACK);
		rdbtnEasy.setBackground(new Color(255, 192, 0));
		rdbtnEasy.setBounds(300, 315, 127, 37);
		add(rdbtnEasy);

		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnMedium.setForeground(Color.BLACK);
		rdbtnMedium.setBackground(new Color(255, 192, 0));
		rdbtnMedium.setBounds(475, 315, 127, 37);
		add(rdbtnMedium);

		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Gadugi", Font.BOLD, 24));
		rdbtnHard.setForeground(Color.BLACK);
		rdbtnHard.setBackground(new Color(255, 192, 0));
		rdbtnHard.setBounds(652, 315, 127, 37);
		add(rdbtnHard);
		
		
		ButtonGroup diff = new ButtonGroup();
		diff.add(rdbtnEasy);
		diff.add(rdbtnMedium);
		diff.add(rdbtnHard);
		
		this.setComponentZOrder(lblNewLabel_1, 11);


	}
}

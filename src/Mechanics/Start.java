package Mechanics;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import Generated.Board;
import Generated.Piece;
import GameModel.XYCoord;

public class Start {

	public static void main(String[] args){
		Game game = new Game();
		
		JFrame window = new JFrame("IQ Puzzler Pro");
		window.setUndecorated(false);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		
		JFrame window1 = new JFrame("IQ Game Pro");
		Board myBoard = new Board(11,4,0);
		
		window1.add(myBoard);
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window1.setVisible(true);
		window1.pack();
		
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}
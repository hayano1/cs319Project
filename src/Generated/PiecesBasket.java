package Generated;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import GameModel.Inventory;
import GameModel.XYCoord;

public class PiecesBasket extends JPanel {

	// Pieces array
	static private Polygon myPol;
	static int x, y;
	
	static public int CurrentSelectedPieceId = -1;
	
	static private int[] xPol;
	static private int[] yPol;
	
	static public ArrayList<Piece> allPieces ;

	

	public PiecesBasket() {

		allPieces = Inventory.pieces;
	
		for(int i = 0; i < allPieces.size(); i++)
		{
			this.add(allPieces.get(i));
		}
		
		
		
		
	}


}

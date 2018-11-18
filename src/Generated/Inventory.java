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

public class Inventory extends JPanel {

	// Pieces array
	static private Polygon myPol;
	static int x, y;
	
	static public int CurrentSelectedPieceId = -1;
	
	static private int[] xPol;
	static private int[] yPol;
	
	static private ArrayList<Piece> allPieces = new ArrayList<Piece>();
	static private ArrayList<XYCoord> cords = new ArrayList<XYCoord>();
	
	static Color red = Color.decode("#ff0000");

	public Inventory() {

		
		
		cords.add( new XYCoord(0,0));
		cords.add( new XYCoord(0,1));
		cords.add( new XYCoord(0,2));
		cords.add( new XYCoord(1,2));
		
		
		allPieces.add(new Piece( 1, 1, cords , 1,1  ));
		
		
		this.add(allPieces.get(0));
		
		
	}


}

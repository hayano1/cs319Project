package Generated;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JLabel implements MouseListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static public final int TileWidth = 50;
	static public final int TileHeight = 50;
	static Color darkGreen = Color.decode("#389900");
	static Color darkGreen1 = Color.decode("#52e100");
	static Color tan = Color.decode("#000000");
	
	static boolean whatColor;
	
	public int x;
	public int y;
	public int tileId;
	public int pieceId;
	public boolean occupied;
	public int TileType;
	public boolean visible;
	
	static public Rectangle tempR;
	static public Polygon tempP;
	
	static private int[] xCords ;
	static private int[] yCords;
	
	static public TileStates state = TileStates.Normal;
	
		
	public Tile(int xWidth, int yHeight, int tileIdd, int pieceIdd, int tileType, boolean visiblee) {
		
		
		
		x = xWidth;
		y = yHeight;
		tileId = tileIdd;
		pieceId = pieceIdd;
		whatColor = true;
		occupied = false;
		TileType = tileType;
		visible = visiblee;
		
		if( TileType == 0)
			tempR = new Rectangle(x, y, TileWidth, TileHeight);
		else {
			
			xCords = new int[4];
			yCords = new int[4];
			
			xCords[0] = (int)( TileWidth/2);
			xCords[1] = (int)( 0 );
			xCords[2] = (int)( TileWidth/2);
			xCords[3] = (int)( TileWidth);
			
			yCords[0] = (int)( 0);
			yCords[1] = (int)( TileHeight/2);
			yCords[2] = (int)( TileHeight);
			yCords[3] = (int)( TileHeight/2);
			
			//System.out.println(xCords[0]);

			tempP = new Polygon( xCords, yCords, 4);
		}
		
		Dimension dim = new Dimension( TileWidth+2, TileHeight+2);
		
		this.setMaximumSize(dim);
		this.setPreferredSize(dim);
		this.setSize(dim);
		

	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D newG = (Graphics2D) g;
		
		
		if( state == TileStates.Normal) {
			newG.setColor(darkGreen);
		}
		else if( state == TileStates.Hovered ) {
			newG.setColor(darkGreen1);
		}
		else {
			newG.setColor(tan);
		}
	
		if( TileType == 0 ) {
			if(!visible)
				newG.setColor(Color.BLACK);
			newG.fillRect(0, 0, TileWidth, TileHeight);
			
			g.setColor(tan);
			drawBlackBorder(x, y, g);
		}
		else if( TileType == 1 ) {
			
			if(!visible)
				g.setColor(Color.BLACK);
			g.drawPolygon(tempP);
			g.fillPolygon(tempP);
			
			drawBlackBorderPoly(xCords, yCords, g);
			
		}

		g.drawString(tileId +" " + pieceId,  TileWidth/3,  TileHeight/3);
		
		//newG.dispose();
		//g.dispose();
		
	}
	
	
	static public void drawBlackBorder(int x, int y, Graphics g) {
		
		//g.drawLine(x, y, x + Tile.TileWidth, y);
	    //g.drawLine(x, y, x, y + Tile.TileHeight);
	    //g.drawLine(x, y + Tile.TileHeight, x + Tile.TileWidth,  y + Tile.TileHeight);
	    //g.drawLine(x + Tile.TileWidth, y, x + Tile.TileWidth,  y + Tile.TileHeight);
		
		g.drawLine(0, 0, Tile.TileWidth, 0);
	    g.drawLine(0, 0, 0,  Tile.TileHeight);
	    g.drawLine(0,  Tile.TileHeight, Tile.TileWidth,  Tile.TileHeight);
	    g.drawLine( Tile.TileWidth, 0, Tile.TileWidth,  Tile.TileHeight);
		
	}
	
	static public void drawBlackBorderPoly(int[] x, int[] y, Graphics g) {
		
		//g.drawLine( xCords[0], 0, 50, 50);
		
	    g.drawLine( xCords[0], yCords[0], xCords[1],  yCords[1]);
	    g.drawLine( xCords[1], yCords[1], xCords[2],  yCords[2]);
	    g.drawLine( xCords[2], yCords[2], xCords[3],  yCords[3]);
	    g.drawLine( xCords[3], yCords[3], xCords[0],  yCords[0]);
		
	}
	
	static public void repaintRectangle() {
		
	}
	
	
	static public enum TileStates{
		Clicked, Hovered, Normal
	}

	
	
	
	
	
	/*
	static public int getPieceIdInTile() {
		return pieceId;
	}
	static public int getTileId() {
		return tileId;
	}
	static public boolean occupiedTile() {
		return occupied;
	}
	static public int getXCord() {
		return x;
	}
	static public int getYCord() {
		return y;
	}
	static public String getState() {
		return state+"";
	}
	*/


	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

	
}

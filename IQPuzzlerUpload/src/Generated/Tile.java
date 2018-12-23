package Generated;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


public class Tile extends JComponent implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static public int TileWidth = 50;
	static public int TileHeight = 50;

	public static final int bigger = 10;;
	static Color normal = Color.decode("#ffff00");
	static Color hovered = Color.decode("#ffae19");
	static Color potential = Color.decode("#ff4b4b");
	
	private Color taken = Color.BLUE;
	
	static boolean whatColor;
	
	public int x;
	public int y;
	public int tileId;
	public int pieceId;
	public boolean occupied;
	public static int TileType;
	public boolean visible;
	
	static public Rectangle tempR;
	
	public TileStates state = TileStates.Normal;
	
	
	//Constructor
	public Tile(int xWidth, int yHeight, int tileIdd, int pieceIdd, int tileType, boolean visiblee) {
		
		x = xWidth;
		y = yHeight;
		tileId = tileIdd;
		pieceId = pieceIdd;
		whatColor = true;
		occupied = false;
		TileType = tileType;
		visible = visiblee;

		tempR = new Rectangle(x, y, TileWidth, TileHeight);

		Dimension dim = new Dimension( TileWidth+2, TileHeight+2);
		
		this.setMaximumSize(dim);
		this.setPreferredSize(dim);
		this.setSize(dim);
	}
	
	//Paint Component
	public void paintComponent(Graphics g) {
		
		//super.paintComponent(g);
		Graphics2D newG = (Graphics2D) g;
		
		if ( state == TileStates.Taken || pieceId != -1) {
			newG.setColor(taken);
		}
		else if( state == TileStates.Normal) {
			newG.setColor(normal);
		}
		else if( state == TileStates.Hovered) {
			newG.setColor(hovered);
		}
		else if( state == TileStates.PotentialSelection ){
			newG.setColor(potential);
		}
		else {
			newG.setColor(Color.PINK);
		}
		
	
		if( TileType == 0 ) {
			
			if(!visible)
				newG.setColor(Color.BLACK);
			
			//newG.setColor(Color.decode("#2e2e2e"));
			newG.fillRect(x, y, TileWidth, TileHeight);
			
			g.setColor(potential);
			drawBlackBorder(x, y, g);
			
			//newG.setColor(Color.PINK);
//			float dist[] = {0.005f, 0.1f};
//			Color temp = Color.decode("#d1d1d1");
//			Color temp1 = Color.decode("#090909");
//            Color[] colors = {temp, temp1};
//            RadialGradientPaint p = new RadialGradientPaint(new Point2D.Float((float)(x + TileWidth*0.6 ), (float)(y + + 0.6*TileHeight )), TileWidth, dist, colors );
//            
//            newG.setPaint(p);
			//newG.fill(new Ellipse2D.Double(x, y, 50, 50));
			
			g.setColor(Color.RED);
			g.drawString(tileId +"",  (x)+(TileWidth/3),  (y)+(TileHeight/3) );
			
		}
		else if( TileType == 1 ) {

			if(visible) {
				//g.setColor(Color.BLACK);
			
				Graphics2D g2 = (Graphics2D)g.create();		//we need temporary so it wont keep rotating every time
			    g2.rotate(Math.toRadians(-45),  Board.boardHeight * Tile.TileHeight*0.5, Board.boardHeight * Tile.TileHeight*0.2);
			
				
				g2.fillRect(x, y, TileWidth, TileHeight);
				drawBlackBorder(x, y, g);
				
				g2.setColor(Color.RED);
				g2.drawString(tileId +"",  (x)+(TileWidth/3),  (y)+(TileHeight/3) );
				
				//g.drawString("!", x+ (int)(Board.boardHeight * Tile.TileHeight*0.5) , y + (int)(Board.boardHeight * Tile.TileHeight*0.2) );
			
			}

			
		}
		
		
	}
	
	//Methods
	static public void drawBlackBorder(int x, int y, Graphics g) {
		
		if( TileType == 0) {

			g.setColor(Color.BLACK);
			
			g.drawLine(x, y, x + Tile.TileWidth, y);
		    g.drawLine(x, y, x, y + Tile.TileHeight);
		    g.drawLine(x, y + Tile.TileHeight, x + Tile.TileWidth,  y + Tile.TileHeight);
		    g.drawLine(x + Tile.TileWidth, y, x + Tile.TileWidth,  y + Tile.TileHeight);
			
			g.setColor(Color.BLACK);
		}
		else if (TileType == 1 ) {
			
			Graphics2D g2d = (Graphics2D)g.create();
		    g2d.rotate(Math.toRadians(-45),  Board.boardHeight * Tile.TileHeight*0.5, Board.boardHeight * Tile.TileHeight*0.2);
			
			g2d.setColor(Color.BLACK);
			
			g2d.drawLine(x, y, x + Tile.TileWidth, y);
			g2d.drawLine(x, y, x, y + Tile.TileHeight);
			g2d.drawLine(x, y + Tile.TileHeight, x + Tile.TileWidth,  y + Tile.TileHeight);
			g2d.drawLine(x + Tile.TileWidth, y, x + Tile.TileWidth,  y + Tile.TileHeight);
		}
	}
			
	public enum TileStates{
		PotentialSelection, Hovered, Normal, Taken, Unavailable
	}

	public int getPieceIdInTile() {
		return pieceId;
	}
	public int getTileId() {
		return tileId;
	}
	public boolean occupiedTile() {
		return occupied;
	}
	public int getXCord() {
		return x;
	}
	public int getYCord() {
		return y;
	}
	

	public void setWidthHeight(int height, int width) {
		
		TileHeight = height;
		TileWidth = width;
		
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	
	public void mouseEntered(MouseEvent e) {
		if( pieceId == -1)
			setState( TileStates.Hovered);
	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("Mouse exited from tile with id: " + tileId + "  -> " + state);
		if( pieceId == -1)
			setState( TileStates.Normal );
		else
			setState( TileStates.Taken );
	}

	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	
	public void setState(TileStates t) {
		 state = t;
	}
	
	public TileStates getState() {
		 return state;
	}

	public void setTakenColor( Color t) {
		taken = t.brighter();
	}

	
}

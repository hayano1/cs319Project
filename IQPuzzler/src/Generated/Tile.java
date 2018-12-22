package Generated;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
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
	public Polygon tempP;
	
	private int[] xCords ;
	private int[] yCords;
	
	public TileStates state = TileStates.Normal;
	
	
	
		
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
			
			if( (int)( tileId/Board.boardWidth ) % 2 == 0) {
			xCords = new int[4];
			yCords = new int[4];
			
			xCords[0] = (int)( TileWidth/2) + x;
			xCords[1] = (int)( 0 )+ x ;
			xCords[2] = (int)( TileWidth/2)+ x;
			xCords[3] = (int)( TileWidth)+ x;
			
			yCords[0] = (int)( 0)+ y;
			yCords[1] = (int)( TileHeight/2)+ y;
			yCords[2] = (int)( TileHeight)+ y;
			yCords[3] = (int)( TileHeight/2)+ y;
			
			
			System.out.println(xCords[0] + "," + yCords[0] + "      " + xCords[1] + "," + yCords[1] + "      " + xCords[2] + "," + yCords[2] + "      " + xCords[3] + "," + yCords[3] );
			}
			else {
				
				xCords = new int[4];
				yCords = new int[4];
				
				xCords[0] = (int)( TileWidth/2) + x;
				xCords[1] = (int)( 0 )+ x ;
				xCords[2] = (int)( TileWidth/2)+ x;
				xCords[3] = (int)( TileWidth)+ x;
				
				yCords[0] = (int)( 0)+ y;
				yCords[1] = (int)( TileHeight/2)+ y;
				yCords[2] = (int)( TileHeight)+ y;
				yCords[3] = (int)( TileHeight/2)+ y;
				
			}

			
			
			tempP = new Polygon( xCords, yCords, 4);
		}
		
		Dimension dim = new Dimension( TileWidth+2, TileHeight+2);
		
		this.setMaximumSize(dim);
		this.setPreferredSize(dim);
		this.setSize(dim);
		

	}
	
	
	public void paintComponent(Graphics g) {
		
		//System.out.println("Trying to print");
		
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
			
			newG.fillRect(x, y, TileWidth, TileHeight);
			
			g.setColor(potential);
			drawBlackBorder(x, y, g);
			
			g.setColor(Color.RED);
			g.drawString(tileId +"",  (x)+(TileWidth/3),  (y)+(TileHeight/3) );
			
		}
		else if( TileType == 1 ) {

			if(visible) {
				//g.setColor(Color.BLACK);
			
			//System.out.println(xCords[0] + "," + yCords[0] + "      " + xCords[1] + "," + yCords[1] + "      " + xCords[2] + "," + yCords[2] + "      " + xCords[3] + "," + yCords[3] );

			
				 Graphics2D g2d = (Graphics2D)g.create();
			     g2d.rotate(Math.toRadians(-45),  Board.boardHeight * Tile.TileHeight*0.5, Board.boardHeight * Tile.TileHeight*0.2);
			
				
				g2d.fillRect(x, y, TileWidth, TileHeight);
				drawBlackBorder(x, y, g);
				
				g2d.setColor(Color.RED);
				g2d.drawString(tileId +"",  (x)+(TileWidth/3),  (y)+(TileHeight/3) );
				
				//g.drawString("!", x+ (int)(Board.boardHeight * Tile.TileHeight*0.5) , y + (int)(Board.boardHeight * Tile.TileHeight*0.2) );
			
			
			}
			
			//g.drawPolygon(tempP);
			//g.fillPolygon(tempP);
			
			//drawBlackBorder(xCords, yCords, g);
			
		}

		
		
		
	}
	
	
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
		
//		g.drawLine(0, 0, Tile.TileWidth, 0);
//	    g.drawLine(0, 0, 0,  Tile.TileHeight);
//	    g.drawLine(0,  Tile.TileHeight, Tile.TileWidth,  Tile.TileHeight);
//	    g.drawLine( Tile.TileWidth, 0, Tile.TileWidth,  Tile.TileHeight);
		
	}
			
	
	public enum TileStates{
		PotentialSelection, Hovered, Normal, Taken, Unavailable
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

	public void setWidthHeight(int height, int width) {
		
		TileHeight = height;
		TileWidth = width;
		
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Mouse entered at tile with id: " + tileId + "  -> " + state);
		
		if( pieceId == -1)
			setState( TileStates.Hovered);
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Mouse exited from tile with id: " + tileId + "  -> " + state);
		if( pieceId == -1)
			setState( TileStates.Normal );
		else
			setState( TileStates.Taken );
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setState(TileStates t) {
		
		 state = t;
		
	}
	
	public TileStates getState() {
		
		 return state;
		
	}

	public void setTakenColor( Color t) {
		
		taken = t.brighter();
//		int val = t.getRGB();
//		
//		val = val * 0xF;
//	
//		taken = Color.decode(val+"") ;
		
	}
	
	
	

	
}

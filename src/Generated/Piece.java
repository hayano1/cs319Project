package Generated;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import GameModel.XYCoord;

public class Piece extends JLabel{
    //attributes
    int pieceID;
    int color;
    int size;
    ArrayList<XYCoord> coordinates;
    
	public boolean pieceHasFocus;
	
	static private int[] xPol;
	static private int[] yPol;
	
	static int x, y;
	
	static private Polygon myPol;

    //constructor

   // public Piece(){};

    public Piece(int pieceID, int color, ArrayList<XYCoord> coord2, int xx, int yy)
    {
        this.pieceID = pieceID;
        this.color = color;
        size = coord2.size();
        coordinates = coord2;
        
 

		x = xx;
		y = yy;
		
		pieceHasFocus = false;
		
		int xMax = -5000;
		int xMin =  5000;
		int yMax =  -5000;
		int yMin =  5000;
		
		for( int i = 0; i < coordinates.size(); i++) {
			//for( int j = 0; j < coordinates.size(); j++) {
				if( xMax < coordinates.get(i).getX() ) {
					xMax = coordinates.get(i).getX();
				}
				
				if( xMin > coordinates.get(i).getX()) {
					xMin = coordinates.get(i).getX();
				}
				
				if( yMax < coordinates.get(i).getY() ) {
					yMax = coordinates.get(i).getY();
				}
				
				if( yMin > coordinates.get(i).getY()) {
					yMin = coordinates.get(i).getY();
				}
			//}
			
		}
		
		System.out.println(xMin + "  " + xMax  + "    |    " + yMin +  "   " + yMax);
		
		Dimension dim = new Dimension( ( Math.abs(xMax) + Math.abs(xMin) )* Tile.TileWidth + 5,  ( Math.abs(yMax) + Math.abs(yMin) )* Tile.TileHeight + 5 );
		
		//this.setPreferredSize(dim);
		//this.setMaximumSize(dim);
		//this.setSize(dim);
		
		 DragPieceMouseListener listener = new DragPieceMouseListener();
		 	addMouseListener(listener);
			addMouseMotionListener(listener);
		
        
        
        
        
    }
    //gets piece ID
    public int getPieceID()
    {
        return pieceID;
    }
    //gets color
    public int getColor()
    {
        return color;
    }
    //size
    public int getSizeofPiece()
    {
    	return size;
    }
    //rotates piece's Y coordinates
    public void rotateRespecttoX()
    {
        for(int i = 0; i < size; i++)
        {
            if(coordinates.get(i).getY() != 0)
            {
                int newY = coordinates.get(i).getY() * -1;
                coordinates.get(i).setY(newY);
            }
        }
        this.repaint();
    }
    //rotates piece's X coordinates
    public void rotateRespecttoY()
    {
        for(int i = 0; i < size; i++)
        {
            if(coordinates.get(i).getX() != 0)
            {
                int newX = coordinates.get(i).getX() * -1;
                coordinates.get(i).setY(newX);
            }
        }
        this.repaint();
    }
    //rotates 90 degrees, counter-clockwise
    public void rotateCounterClock()
    {
        int newX = 0;
        int newY = 0;
        for(int i = 1; i < size; i++)
        {
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
        }
        this.rotateRespecttoY();
        this.repaint();
    }
    //rotates 90 degrees, clockwise
    public void rotateClock()
    {
        int newX = 0;
        int newY = 0;
        for(int i = 1; i < size; i++)
        {
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
        }
        this.rotateRespecttoX();
        this.repaint();
    }
    //gets the coordinates of the balls on a piece
    public ArrayList<XYCoord> getCoordinates()
    {
        return coordinates;
    }
    public int differenceX(int index)
    {
        int diff = -20;
        if(coordinates == null)
            return diff;
        else
            diff = coordinates.get(0).getX() + coordinates.get(index).getX();
        return diff;
    }
    public int differenceY(int index)
    {
        int diff = -20;
        if(coordinates == null)
            return diff;
        else
            diff = coordinates.get(0).getY() - coordinates.get(index).getY();
        return diff;
    }
    public void paintComponent(Graphics g) {

		//System.out.println("Drawing piece");
		//g.drawLine(58, 50, 4100, 1000);
		
		super.paintComponent(g);
		
		if( pieceHasFocus )
			g.setColor(Color.RED);  //Change color here when merging code
		else
			g.setColor(Color.BLUE);

		
        drawPiece(g, x, y);
	}
	
	public void drawPiece(Graphics g, int x, int y) {
		
			System.out.println("asdfasdfasdfsadf");
			int size = this.coordinates.size();
						
			xPol = new int[4*size];
			yPol = new int[4*size];
			
			for( int j = 0; j < this.coordinates.size(); j++) {
				geneCords(this.coordinates.get(j), j+1, x, y);
			}
			int polySize = removeDuplicates(4*size);
			
			
			myPol = new Polygon(xPol, yPol, polySize);

			g.fillPolygon(myPol);
			
		}

	private void geneCords(XYCoord cord, int nr, int x, int y) {
		
		int nr1 = (nr - 1)*4;

			int xt = Math.abs(cord.getX()) * Tile.TileWidth + x;
			int xt1 = Math.abs(cord.getX()) * Tile.TileWidth  + Tile.TileWidth + x;
			
			int yt = Math.abs(cord.getY()) * Tile.TileHeight + y;
			int yt1 = Math.abs(cord.getY()) * Tile.TileHeight + Tile.TileHeight + y;
			
			xPol[nr1]   = xt;
			yPol[nr1]   = yt;
			
			xPol[nr1+1] = xt;
			yPol[nr1+1] = yt1;
			
			xPol[nr1+2] = xt1;
			yPol[nr1+2] = yt1;
			
			xPol[nr1+3] = xt1;
			yPol[nr1+3] = yt;
			
	}
	
	private int removeDuplicates(int size) {
		
		for( int i = 0; i < size; i++) {
			int xtemp = xPol[i];
			int ytemp = yPol[i];
			
			for( int j = 0; j < size && j != i; j++) {
				
				if( xPol[j] == xtemp && yPol[j] == ytemp ) {
					xPol[j] = -1;
					yPol[j] = -1;
					
					xPol[i] = -1;
					yPol[i] = -1;
					
				}
				
			}
			
		}
		
		
		List<Integer> xArray = new ArrayList<Integer>();
		List<Integer> yArray = new ArrayList<Integer>();
		
		for( int i = 0; i < size; i++) {
			if( xPol[i] != -1 ) {
				int temp = xPol[i];
				xArray.add( temp );
			}
		}

		for( int i = 0; i < size; i++) {
			if( yPol[i] != -1 ) {
				int temp = yPol[i];
				yArray.add( temp );
			}
		}
		
		xPol = new int[xArray.size()];
		yPol = new int[yArray.size()];
		
		
		for( int i = 0; i <  xArray.size(); i++) {
			xPol[i] = xArray.get(i);
			yPol[i] = yArray.get(i);
		}
		
		boolean checkX = true;
		
		for( int i = 0; i < xArray.size(); i++) {
			
			if( checkX) {
				
				int temp = xPol[i];
				
				for( int j = 0; j < xArray.size()  && j != i; j++) {
					if( i+1 < xArray.size()) {
						if(xPol[j] == temp ) {
							int newTemp = xPol[i+1];
							xPol[i+1] = xPol[j];
							xPol[j] = newTemp;
							
							newTemp = yPol[i+1];
							yPol[i+1] = yPol[j];
							yPol[j] = newTemp;
							
							break;
						}
					}
					
					
				}
				
				checkX = false;
			}
			else {
				int temp = yPol[i];
				
				for( int j = 0; j < xArray.size() && j != i; j++) {
					if(yPol[j] == temp ) {
						if( i+1 < xArray.size()) {
							int newTemp = xPol[i+1];
							xPol[i+1] = xPol[j];
							xPol[j] = newTemp;
							
							newTemp = yPol[i+1];
							yPol[i+1] = yPol[j];
							yPol[j] = newTemp;
							
							
						}
						break;
					}
				}
				
				
				checkX = true;
			}
			
			
		}
		
		
		
		return xArray.size();
	}
	
	class DragPieceMouseListener extends MouseAdapter {
		
		boolean inside = false;

		public void mousePressed(MouseEvent e) {
			//setStartPoint(e.getX(), e.getY());
			if( myPol.contains( e.getPoint() ) ){
				inside = true;
				
				if( pieceHasFocus )
					pieceHasFocus = false;
				
				if( !pieceHasFocus)
					pieceHasFocus = true;
				
				repaint();
			}
			else { 
				inside = false;
				repaint();
			}
		}

		public void mouseDragged(MouseEvent e) {
			//boolean asd
			if( inside ) {
				setEndPoint(e.getX(), e.getY());
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {

			if( pieceHasFocus )
				pieceHasFocus = false;
			
			repaint();
		}
	}
	
	public void setEndPoint(int xx, int yy) {
        this.x = (xx);
        this.y = (yy);
        
       // System.out.println(x + " " + y);
    }
}
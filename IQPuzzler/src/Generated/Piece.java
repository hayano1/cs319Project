package Generated;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import GameModel.XYCoord;

public class Piece extends JComponent{

	private static final long serialVersionUID = 1L;
	//attributes
    int pieceID,size;
    public Color color,selectedColor, currentColor;
    public ArrayList<XYCoord> coordinates;
    public ArrayList<Ellipse2D> circles;
	
    public boolean pieceHasFocus;
	public boolean placed = false;
	public boolean permaPlaced = false;

	static public int width, height; 
	private int x, y;	//position on screen
	private int firstX = 0, firstY = 0; //position after clicking on shape
	private int constructorX, constructorY;
	
	public XYCoord clickedCircleOnShape;
	


    public Piece(int pieceID, Color color, ArrayList<XYCoord> coord2, int xx, int yy)
    {
        this.pieceID = pieceID;
        this.color = color;
        selectedColor = Color.decode("#00ff50");
        currentColor = color;
        size = coord2.size();
        coordinates = coord2;
        
        constructorX = xx;
        constructorY = yy;
        
        circles = new ArrayList<Ellipse2D>();
        
           
      int length =  coordinates.size();
		
		int width = Tile.TileWidth;
		int height = Tile.TileHeight;
        
        for( int i =0; i < length; i++) {
			
			int xT = coordinates.get(i).getX();
			int yT = coordinates.get(i).getY();
			
			circles.add(new Ellipse2D.Double( xT*width ,yT*height,width,height) );	
		}
        
        
		x = xx;
		y = yy;
		
		pieceHasFocus = false;
		
		Dimension dim = getDimensions();
		
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setSize(dim);
		
				
        
    }
    	//gets piece ID
    public int getPieceID()
    {
        return pieceID;
    }
    	//gets color
    public Color getColor()
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
    	
    	//System.out.println("@@@@@@@@@@@@@@@@@@ X");
    	
    	int maxY = -5000;
        for(int i = 0; i < size; i++)
        {
        	//System.out.println( coordinates.get(i).getY() );
        	if( maxY <  coordinates.get(i).getY()) {
        		maxY = coordinates.get(i).getY();
        	}
        }
        
        //System.out.println("----------------- " + maxY);
    	
    	
        for(int i = 0; i < size; i++)
        {
        	//System.out.println( coordinates.get(i).getY() );
            int newY = ( coordinates.get(i).getY() * -1 ) + maxY;
            coordinates.get(i).setY(newY);
        }
        
        //System.out.println("@@@@@@@@@@@@@@@@@@");
        
        this.repaint();
    }
    	//rotates piece's X coordinates
    public void rotateRespecttoY()
    {
    	//System.out.println("@@@@@@@@@@@@@@@@@@ Y");
    	
    	int maxX = -5000;
        for(int i = 0; i < size; i++)
        {
        	//System.out.println( coordinates.get(i).getX() + " " +   coordinates.get(i).getY());
        	if( maxX <  coordinates.get(i).getX()) {
        		maxX = coordinates.get(i).getX();
        	}
        }
    	
        //System.out.println("----------------- " + maxX);
        
        for(int i = 0; i < size; i++)
        {
            int newX = ( coordinates.get(i).getX() * -1)  + maxX;
            coordinates.get(i).setX(newX);
            //System.out.println( coordinates.get(i).getX() + " " +   coordinates.get(i).getY());
        }
        
        //System.out.println("@@@@@@@@@@@@@@@@@@");
        this.repaint();
        
        
    }
    //rotates 90 degrees, counter-clockwise
    public void rotateCounterClock()
    {
        int newX = 0;
        int newY = 0;
        
        rotateRespecttoY();
        
        for(int i = 0; i < size; i++)
        {
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
        }
        
        this.repaint();
    }
    
    
    	//rotates 90 degrees, clockwise
    public void rotateClock()
    {
        int newX = 0;
        int newY = 0;
        
        rotateRespecttoX();
        
        for(int i = 0; i < size; i++)
        {
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
            
            System.out.println( newX + " " + newY);
        }
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
  
    public void setPermaPlaced(boolean newBol) {
    	permaPlaced = newBol;
    }
    
    public Dimension getDimensions() {
    	
    	int xMax = -5000;
		int xMin =  5000;
		int yMax =  -5000;
		int yMin =  5000;
		
		for( int i = 0; i < coordinates.size(); i++) {
			
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
			
		}
		
		
		width = ( Math.abs(xMax) + Math.abs(xMin) +1 )* Tile.TileWidth + 5;
		height =  ( Math.abs(yMax) + Math.abs(yMin) +1)* Tile.TileHeight + 5;
		
		return  new Dimension( width, height );
		
    }

    public void setPosition(Point p) {
    	
    	x = (int) p.getX();
    	y = (int) p.getY();
    	
    }
    
    public void setPieceFocus (boolean foc) {
    	
    	pieceHasFocus = foc;
    	
    }
    
    public void changePieceFocus() {
    	
    	if( pieceHasFocus ) {
			pieceHasFocus = false;
		}				
		else{
			pieceHasFocus = true;
		}
    
    }
    
    public void paintComponent(Graphics g) {


		//System.out.println("Drawing piece");
		
		//super.paintComponent(g);
    
		if( pieceHasFocus ) {
			g.setColor(selectedColor);  
			currentColor = selectedColor;
		}
		else {
			g.setColor(color);
			currentColor = color;
		}

		
		//System.out.println(x + "   " + y);
		//=================
		Graphics2D g2 = (Graphics2D)g;
		

		int length =  circles.size();
		
		for( int i = 0; i < circles.size();) {
			circles.remove(i);
		}
		
		int width = Tile.TileWidth;
		int height = Tile.TileHeight;
		
		
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " + x + "  " + y);
		
		for( int i =0; i < length; i++) {
			
			int xT = coordinates.get(i).getX();
			int yT = coordinates.get(i).getY();
			
			
			circles.add(new Ellipse2D.Double(  x + xT*width ,y +yT*height,width,height) );	 

			
			if(Tile.TileType == 0) {
				g2.fill( circles.get(i) );
				g.setColor(Color.BLACK);
				g.drawOval( x + xT*width, y + yT*height, width, height); 
			}
			else if(Tile.TileType == 1) {
				
				AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(45), x, y);
				
				g2.fill(at.createTransformedShape( circles.get(i) ));
				g.setColor(Color.BLACK);
				
				g2.draw( at.createTransformedShape( new Ellipse2D.Double(x + xT*width, y + yT*height, width, height) ));
				
				Graphics2D g2d = (Graphics2D)g.create();
			    g2d.rotate(Math.toRadians(45), x, y);
				g2d.setColor(Color.RED);
				g2d.drawString(xT + " " + yT +"",  x + xT*width + Tile.TileWidth/2,  y + yT*height + Tile.TileHeight/2 );
				
			}	
			
			g.setColor(currentColor);
			//System.out.println(x*width + "  " + y*height);

		}
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        //=================
        
	}
    
	public boolean insideShape(MouseEvent e) {
		
		boolean insideShape = false;
		
		for( int i=0; i < circles.size(); i++) {
			if( Tile.TileType == 0) {
				if( circles.get(i).contains(e.getPoint()) ){
					insideShape = true;
					clickedCircleOnShape = coordinates.get(i);
					
					break;
				}
			}
			else if( Tile.TileType == 1) {
				
				double x1 =  e.getPoint().getX() - x;
				double y1 =  e.getPoint().getY() - y;
				
				double coss = Math.cos(Math.toRadians(45));
				double sinn = Math.sin(Math.toRadians(45));
				
				double xx = x +( ( x1 * coss ) + ( y1 *  sinn) );
				double yy = y +( ( y1 * coss ) - ( x1 * sinn ) ); 
				
				Point ee = new Point((int)xx, (int)yy) ;
				
				if( circles.get(i).contains( ee ) ){
					
					insideShape = true;
					clickedCircleOnShape = coordinates.get(i);
					
					break;	
				}
			}
		}
		
		return insideShape;
		
	}
	
	public void setFirstPoint(int xx, int yy) {
		firstX = xx-x;
		firstY = yy-y;
		//System.out.println(firstX + "  " + firstY);
	}
	
	public void setSecondPoint(int xx, int yy) {
        x = ( (xx - firstX));
        y = ( (yy - firstY));
        
       //System.out.println(x + " " + y);
    }
	
	public void returnToOrigin() {
		
		setPosition(new Point( constructorX, constructorY) );
		
	}
	
	public void setConstructorXandY(int x, int y) {
		constructorX = x;
		constructorY = y;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
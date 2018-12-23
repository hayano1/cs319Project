package Generated;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
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

	private int width, height; 
	private int x, y;	//position on screen
	private int firstX = 0, firstY = 0; //position after clicking on shape
	private int constructorX, constructorY;
	
	int xInGrid;
	int yInGrid;
	
	public XYCoord clickedCircleOnShape;
	

	//Constructor
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

        
        xInGrid = -1;
        yInGrid = -1;
        
        xInGrid = xInGrid + 0;
        yInGrid = yInGrid + 0;
        
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
   
    //Methods
    
    	//gets piece ID
    public int getPieceID(){
        return pieceID;
    }
    	//gets color
    public Color getColor(){
        return color;
    }
    	//size
    public int getSizeofPiece(){
    	return size;
    }
    	//rotates piece's Y coordinates
    public void rotateRespecttoX(){
    	
    	int maxY = -5000;
        for(int i = 0; i < size; i++)
        {
        	if( maxY <  coordinates.get(i).getY()) {
        		maxY = coordinates.get(i).getY();
        	}
        }
    	
        for(int i = 0; i < size; i++)
        {
            int newY = ( coordinates.get(i).getY() * -1 ) + maxY;
            coordinates.get(i).setY(newY);
        }
        this.repaint();
    }
    	//rotates piece's X coordinates
    public void rotateRespecttoY()
    {
    	int maxX = -5000;
        for(int i = 0; i < size; i++)
        {
        	if( maxX <  coordinates.get(i).getX()) {
        		maxX = coordinates.get(i).getX();
        	}
        }
    	
        for(int i = 0; i < size; i++)
        {
            int newX = ( coordinates.get(i).getX() * -1)  + maxX;
            coordinates.get(i).setX(newX);
        }
        
        this.repaint();
    }
    	//rotates 90 degrees, counter-clockwise
    public void rotateCounterClock(){
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
    public void rotateClock(){
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
    public ArrayList<XYCoord> getCoordinates(){
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
    	//gets the maximum space a piece occupies
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
    	//changes pieces position
    public void setPosition(Point p) {
    	x = (int) p.getX();
    	y = (int) p.getY();
    }
    
    public void setPieceFocus (boolean foc) {
    	
    	pieceHasFocus = foc;
    	
    }

    //Paint Component
    public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		if( pieceHasFocus ) {
			g.setColor(selectedColor);  
			currentColor = selectedColor;
		}
		else {
			g.setColor(color);
			currentColor = color;
		}

		//=================
		Graphics2D g2 = (Graphics2D)g;
		
//		RenderingHints rh = new RenderingHints(
//                RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
//                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        g2.setRenderingHint(RenderingHints.KEY_DITHERING,
//                RenderingHints.VALUE_DITHER_ENABLE);
//
//        g2.setRenderingHints(rh);
		
		//System.out.println(" X: " + x + "  Y: " + y);

		int length =  circles.size();
		
		for( int i = 0; i < circles.size();) {
			
			circles.remove(i);
		}
		
		int width = Tile.TileWidth;
		int height = Tile.TileHeight;
		
		
		for( int i =0; i < length; i++) {
			
			int xT = coordinates.get(i).getX();
			int yT = coordinates.get(i).getY();
			
			
			circles.add(new Ellipse2D.Double(  x + xT*width ,y +yT*height,width,height) );	 

			
			if(Tile.TileType == 0) {
				
//				float dist[] = {0.1f, 0.7f};
//                Color[] colors = {color.brighter().brighter(), color.darker().darker()};
//                RadialGradientPaint p = new RadialGradientPaint(new Point2D.Float((float)(x + xT*width + 0.3*width), (float)(y +yT*height + 0.3*height )), width, dist, colors );
//                g2.setPaint(p);
				
				//System.out.print( "  " +1+ " ");
                g2.fill( circles.get(i) );
				g.setColor(Color.BLACK);
				//g.drawOval( x + xT*width, y + yT*height, width, height); 
				g2.draw( new Ellipse2D.Double(x + xT*width, y + yT*height, width, height) );
				g2.drawString(xT + " " + yT +"",  x + xT*width + Tile.TileWidth/2,  y + yT*height + Tile.TileHeight/2 );
			}
			else if(Tile.TileType == 1) {
				
				AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(-45), x, y);
				
//				float dist[] = {0.1f, 0.7f};
//                Color[] colors = {color.brighter().brighter(), color.darker().darker()};
//                RadialGradientPaint p = new RadialGradientPaint(new Point2D.Float((float)(x + xT*width + 0.6*width), (float)(y +yT*height + 0.6*height )), width, dist, colors );
//                g2.setPaint(p);
				
				//drawing shape
				g2.fill(at.createTransformedShape( circles.get(i) ));
				g.setColor(Color.BLACK);
				g2.draw( at.createTransformedShape( new Ellipse2D.Double(x + xT*width, y + yT*height, width, height) ));
				
				//drawing numbers
				Graphics2D g3 = (Graphics2D)g.create();
			    g3.rotate(Math.toRadians(-45), x, y);
				g3.setColor(Color.RED);
				g3.drawString(xT + " " + yT +"",  x + xT*width + Tile.TileWidth/2,  y + yT*height + Tile.TileHeight/2 );
				
			}	
			g.setColor(currentColor);
		}
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
				
				double coss = Math.cos(Math.toRadians(-45));
				double sinn = Math.sin(Math.toRadians(-45));
				
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
	}
	
	public void setSecondPoint(int xx, int yy) {
        x = ( (xx - firstX));
        y = ( (yy - firstY));
    }
	
	public void returnToOrigin() {
		
		setPosition(new Point( constructorX, constructorY) );
	}
	
	public void setConstructorXandY(int x, int y) {
		constructorX = x;
		constructorY = y;
	}
	
	public void setXCordsInBoard(XYCoord newCords) {
		
		xInGrid = newCords.getX();
		yInGrid = newCords.getY();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
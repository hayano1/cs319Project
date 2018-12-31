package Generated;
import GameModel.Indeces;
import java.awt.*;
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
        
        public boolean selected;
	
	public XYCoord clickedCircleOnShape;
	

	//Constructor
    public Piece(int pieceID, Color color, ArrayList<XYCoord> coord2, int xx, int yy)
    {
        this.pieceID = pieceID;
        this.color = color;
        //selectedColor = Color.decode("#00ff50");
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
		int width = Tile.TileWidth/2;
		int height = Tile.TileHeight/2;
        
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
    	int minAll =  clickedCircleOnShape.getY();
    	boolean changeY = false;
    	
        for(int i = 0; i < size; i++)
        {
        	if( maxY <  coordinates.get(i).getY()) {
        		maxY = coordinates.get(i).getY();
        	}
        	
        	if( !changeY && minAll > coordinates.get(i).getY() ) {
        		changeY = true;
        	}
        }
    	
        for(int i = 0; i < size; i++)
        {
        	int newY = ( coordinates.get(i).getY() * -1  ) + maxY;
        	
            coordinates.get(i).setY(newY);
        }

        
        this.repaint();
       // clickedCircleOnShape.setY(( clickedCircleOnShape.getY() * -1  ) + maxY ) ;
        //System.out.println("XX: "  + clickedCircleOnShape.getX() + "  YY: " + clickedCircleOnShape.getY() );
        
        
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
            g.setColor(color.darker());
            currentColor = color.darker();
        }
        else {
            g.setColor(color);
            currentColor = color;
        }

		//=================
		Graphics2D g2 = (Graphics2D)g;

		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_DITHERING,
				RenderingHints.VALUE_DITHER_ENABLE);

		g2.setRenderingHints(rh);
		
		//System.out.println(" X: " + x + "  Y: " + y);

		int length =  circles.size();
		
		for( int i = 0; i < circles.size();) {
			
			circles.remove(i);
		}
		
                 int width ;
                 int height;
                
                if( !placed ){
                    width = (int) ((int) Tile.TileWidth / Indeces.shrinkScale) ;
                    height = (int) ((int) Tile.TileHeight / Indeces.shrinkScale);
                }
                else{
                    width = ((int) Tile.TileWidth ) ;
                    height =((int) Tile.TileHeight );
                }
                
                if( selected){
                    width = ((int) Tile.TileWidth ) ;
                    height =((int) Tile.TileHeight );
                }
                
		
		
		for( int i =0; i < length; i++) {
			
			int xT = coordinates.get(i).getX();
			int yT = coordinates.get(i).getY();
			
			circles.add(new Ellipse2D.Double(  x + xT*width ,y +yT*height,width,height) );	 

			if(Tile.TileType == 0) {

				g2.fill( circles.get(i) );
				g2.setColor(color.brighter());
				//g.drawOval( x + xT*width, y + yT*height, width, height);
				//System.out.println(x );
				g2.fill( new Ellipse2D.Double(x + xT*width + 8, y + yT*height + 8, width-20, height-16) );
			}
			else if(Tile.TileType == 1) {
				
				AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(-45), x, y);
				
				//drawing shape
				g2.fill(at.createTransformedShape( circles.get(i) ));
				//g.setColor(Color.BLACK);
                                g2.setColor(color.brighter());
				g2.fill( at.createTransformedShape( new Ellipse2D.Double(x + xT*width +8, y + yT*height + 8, width-20, height-20) ));
				
				//drawing numbers
				//Graphics2D g3 = (Graphics2D)g.create();
                                //g3.rotate(Math.toRadians(-45), x, y);
				//g3.setColor(Color.RED);
				//g3.drawString(xT + " " + yT +"",  x + xT*width + Tile.TileWidth/2,  y + yT*height + Tile.TileHeight/2 );
				
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
					clickedCircleOnShape = new XYCoord(0,0);
					
					clickedCircleOnShape.setX(coordinates.get(i).getX());
					clickedCircleOnShape.setY(coordinates.get(i).getY());
					//coordinates.get(i);
					
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
					clickedCircleOnShape =new XYCoord(0,0);
					
					clickedCircleOnShape.setX(coordinates.get(i).getX());
					clickedCircleOnShape.setY(coordinates.get(i).getY());
					//return coordinates.get(i);
					break;	
				}
			}
		}
		
		return insideShape;
		
	}
	
	public void setTiltedConstructor(double xxxx, double yyyy) {
		
		
		Point point = new Point( (int)xxxx, (int) yyyy);
		Point2D result = new Point2D.Double();
	    AffineTransform rotation = new AffineTransform();
	    //double angleInRadians = (angle * Math.PI / 180);
	   
	    
	    rotation.rotate(Math.toRadians(-45),  Board.boardHeight * Tile.TileHeight*0.5, Board.boardHeight * Tile.TileHeight*0.2);
	    rotation.transform(point, result);
		
		setConstructorXandY( (int) result.getX(), (int)result.getY());

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
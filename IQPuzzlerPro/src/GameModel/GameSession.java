package GameModel;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import Generated.Board;
import Generated.Piece;
import Generated.Tile;
import OurTimer.TimerPanel;

public class GameSession {
	//Attributes
	int gameID;
	int gameType;
	int diff_level;
	static Board gameBoard;
	
	public Inventory inventory;
	
	public ArrayList< ArrayList<Object> > allPieces;
	
	static int firstHeight; 
        static int firstWidth;
	
	
	//Constructor
	public GameSession(int gameID, int gameType, String gameMode ,int diff_level, String currLevel)
	{
		System.out.println("Board Height is : " +  Board.boardHeight + "  " + Tile.TileHeight + "  = " +  Board.boardHeight * Tile.TileHeight);
		
		if( gameType == 0){
			//firstHeight = Board.boardHeight * Tile.TileHeight  + 20;
                    firstHeight = 0;
                    firstWidth = 0;
                 }
		else {
			firstHeight = (int) ((Board.boardHeight - 0.2) * Tile.TileHeight + 20);
		}
		
		
		this.gameID = gameID;
		this.gameType = gameType;
		this.diff_level = diff_level;
		
		initializeChallenge( gameType , gameMode ,currLevel + "");
		
		inventory = new Inventory(0);

        for(int count = 0; count < allPieces.size(); count++){
            inventory.addPiece( (Piece) allPieces.get(count).get(Indeces.Piece));
        }
        inventory.print();
	}
	
	//Methods
    public void initializeChallenge( int gameType, String gameMode ,String currLevel){
    	
    	int currMaxHeight = -5000;
    	int initWidth = 50;
    	
        try {
        	
        	  allPieces = new ArrayList< ArrayList<Object> >();

                  String dir = "";
                  System.out.println(gameType + " @@");
                  
                  if( gameMode.equals("Normal") ){
                    if( gameType == 0){
                        dir = "Levels\\\\Normal\\";
                    }
                    else{
                        dir = "Levels\\\\Diamond\\";
                    }
                  }
                  else if(  gameMode.equals("LoadGame")){
                       dir = "SavedGames\\";
                  }
                  else if( gameMode.equals("Generated") ){
                      dir = "Levels\\Generated\\";
                  }
                  else if (gameMode.equals("Story")){
                      dir = "Levels\\Normal\\";
                  }
                  
  
        	  File file = new File( dir + currLevel + ".txt"); 
        	  @SuppressWarnings("resource")
        	  BufferedReader level = new BufferedReader(new FileReader(file)); 
        	  
        	  String line; 
        	  int count  = 1;
        	  int width = initWidth;
        	  
        	  long timee = Long.parseLong( level.readLine() );
                  TimerPanel.setTimeLeft(timee);
        	  
        	  while ((line = level.readLine()) != null) {
        		  
        		  ArrayList<XYCoord> pieceCoords = new ArrayList<XYCoord>();
        		 
        		  int start = -1;
        		  int index = line.indexOf(":");

        		  int safe = line.lastIndexOf(":");
					
        		  while( index > 0 && index <= safe ) {

        			  String temp =  line.substring(start+1, index);
        			  int xCoord = Integer.parseInt( temp.substring(0, temp.lastIndexOf(","))   );
        			  int yCoord = Integer.parseInt( temp.substring(temp.lastIndexOf(",")+1 )   );
        			  
        			  pieceCoords.add(new XYCoord(xCoord, yCoord));
        			  
        			  start = index;
        			  index = line.indexOf(":", index+1);

        		  }
        		  
        		  index = line.lastIndexOf(":");
        		  
        		  ArrayList<Object> temp = new ArrayList<Object>();
        		  
        		  temp.add( new Piece(count, Color.decode( line.substring(index+1 , line.lastIndexOf(";")  ) ) , pieceCoords, width, firstHeight) );	//adding piece
        		  
        		  
        		  String insideBoard = line.substring(line.lastIndexOf(";")+1, line.indexOf("/")) ;
        		  
        		  
        		  if( insideBoard.equals("1")) {
        			  temp.add(true);
        		  }
        		  else if ( insideBoard.equals("0")   ) {
        			  temp.add(false);
        		  }
        		  
        		  
        		  index = line.indexOf("/") +1;
        		  int lastIndex = line.lastIndexOf("/");
        		  int ll = line.indexOf("=");
        		  
        		  int xInGrid = Integer.parseInt( line.substring(index, lastIndex)  );
        		  int yInGrid = Integer.parseInt( line.substring(lastIndex +1, ll )   );
        		  
        		  
        		  temp.add(xInGrid);
        		  temp.add(yInGrid);
        		  
        		  
        		  index = line.lastIndexOf("=");
        		  String permaPlaced =  line.substring(index+1) ;
        		  
        		  if( permaPlaced.equals("1")) {
        			  temp.add(true);
        		  }
        		  else if ( permaPlaced.equals("0")   ) {
        			  temp.add(false);
        		  }
        		  
        		  
        		  allPieces.add(temp);
        		  
        		  Piece t = ((Piece) temp.get(0));
        		  count++;
        		  if( !insideBoard.equals("0")) {
        			  
	        		  Dimension dim = t.getDimensions();
	        		  
	        		  if( dim.getHeight() > currMaxHeight) {  
	        			  currMaxHeight = (int) dim.getHeight();		  
	        		  }
	        		  
	        		  System.out.println("SSSS : " + dim.getWidth());
                                  
	        		  if( Board.TileType == 0) {
                                          
                                        if(   Board.boardHeight*Tile.TileHeight > firstHeight ) {
                                            
                                            if( width == initWidth){
                                                width = Board.boardWidth *  Tile.TileWidth + Board.boardMargin + 20;
                                            }
                                            else{
                                               width = initWidth;
                                               firstHeight += currMaxHeight*Indeces.shrinkScale;
                                            } 
                                            
                                            if( count == 4){
                                                firstHeight = Board.boardHeight * Tile.TileHeight + 30 ;
                                                width = initWidth;
                                            }
                                            
                                            //count++;
                                           
                                        }
                                        else{
                                            System.out.println("CCCC: " + count);
                                            
                                            width += dim.getWidth()/1.15 + 20 ;
                                            //count ++;
                                            
                                            if( Math.abs(-width + 1000) < 100){
                                                firstHeight += currMaxHeight/Indeces.shrinkScale;
                                                width = initWidth;
                                            }
                                        }
                                          
	        		  }
	        		  else if(  Board.TileType  == 1) {
	        			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
	        			 width += dim.getWidth() + Math.cos(Math.toRadians(-45)) * dim.getWidth() ;
	        			  if(  width >= 900   ) {
                                            width = initWidth;
                                            firstHeight += currMaxHeight ;
                                            }
	        		  }

	        		  
        		  }
        		 
        	    System.out.println(line); 
        	  } 
        	  
           
        	int length = allPieces.size();
        	for( int i=0; i < length; i++ ) {
        		boolean inBoardOrNot = (Boolean) allPieces.get(i).get(Indeces.InBoard);
        		
        		if( !inBoardOrNot ) {
        			((Piece) allPieces.get(i).get(Indeces.Piece)).setPermaPlaced(!inBoardOrNot);
        		}
        	}
        	
                level.close();
        	
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }

    public Inventory getGameSeshInven() {
    	return inventory;
    }


}
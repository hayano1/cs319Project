package GameModel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import Generated.Board;
import Generated.Piece;
import Generated.Tile;

public class GameSession {
	//Attributes
	int gameID;
	int gameType;
	int diff_level;
	static Board gameBoard;
	
	public Inventory inventory;
	
	public ArrayList< ArrayList<Object> > allPieces;
	
	static int firstHeight = Board.boardHeight * Tile.TileHeight;
	
	
	//Constructor
	public GameSession(int gameID, int gameType, int diff_level, int currLevel)
	{
		this.gameID = gameID;
		this.gameType = gameType;
		this.diff_level = diff_level;
		
		initializeChallenge( currLevel + "");
		
		inventory = new Inventory(0);

        for(int count = 0; count < allPieces.size(); count++){
            inventory.addPiece( (Piece) allPieces.get(count).get(Indeces.Piece));
        }
        inventory.print();
	}
	
	//Methods
    public void initializeChallenge(String currLevel){
        try {
        	
        	  allPieces = new ArrayList< ArrayList<Object> >();

        	  
        	  File file = new File("Levels\\"+ currLevel + ".txt"); 
        	  @SuppressWarnings("resource")
        	  BufferedReader level = new BufferedReader(new FileReader(file)); 
        	  
        	  String line; 
        	  int count  = 1;
        	  int width = 0;
        	  
        	  //int timeLeft = Integer.parseInt( level.readLine() );
        	  level.readLine();
        	  
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
        		  
        		  temp.add(new Piece(count, Color.decode( line.substring(index+1 , line.lastIndexOf(";")  ) ) , pieceCoords, width, firstHeight));	//adding piece
        		  
        		  
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
        		  
        		  count++;
        		  width += 200;
        		  if( width == 1200) {
        			  width = 0;
        			  firstHeight += 250;
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
        	
        	
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }

    public Inventory getGameSeshInven() {
    	return inventory;
    }


}
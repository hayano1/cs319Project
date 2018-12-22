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
	//public boolean toGrid[];
	//public  List<List<Integer>> toGridCords;
	static Board gameBoard;
	
	public Inventory inventory;
	//public ArrayList<Piece> allPieces;
	//public ArrayList<Boolean> toGrid;
	
	public ArrayList< ArrayList<Object> > allPieces;
	
	Piece selectedPiece;
	
	static int firstHeight = Board.boardHeight * Tile.TileHeight;
	
	
	static Color color1 = Color.decode("#fca1ed"); //
	static Color color2 = Color.decode("#1b01bf"); //
	static Color color3 = Color.decode("#67a3fc"); //
	static Color color4 = Color.decode("#fffa00"); //
	static Color color5 = Color.decode("#a4fcb1"); //
	static Color color6 = Color.decode("#ffc300"); //
	static Color color7 = Color.decode("#d400ff"); //
	static Color color8 = Color.decode("#1d0047"); //
	static Color color9 = Color.decode("#ff2100"); //
	static Color color10 = Color.decode("#e9ff00");//
	static Color color11 = Color.decode("#ff0000");//
	static Color color12 = Color.decode("#00f2ff");//

	//Shapes of pieces
	public static ArrayList<XYCoord> coord1 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(2,0),new XYCoord(2,1),new XYCoord(3,1)));     //    
	public static ArrayList<XYCoord> coord2 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(2,0),new XYCoord(2,1),new XYCoord(2,2) ));	//   
	public static ArrayList<XYCoord> coord3 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(1,1) ));										//									   	
	public static ArrayList<XYCoord> coord4 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(2,0),new XYCoord(3,0),new XYCoord(1,1)));		//
	public static ArrayList<XYCoord> coord5 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(0,1),new XYCoord(1,1),new XYCoord(1,2)));   	// 
	public static ArrayList<XYCoord> coord6 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(2,0), new XYCoord(0,1),new XYCoord(1,1),new XYCoord(2,1),new XYCoord(1,2)));		//    
	public static ArrayList<XYCoord> coord7 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(1,1),new XYCoord(2,1),new XYCoord(2,2)));		//    
	public static ArrayList<XYCoord> coord8 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(1,1),new XYCoord(1,2)));						//					   
	public static ArrayList<XYCoord> coord9 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(1,0),new XYCoord(1,1),new XYCoord(1,2),new XYCoord(1,3)));		//    
	public static ArrayList<XYCoord> coord10 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(2,0),new XYCoord(0,1),new XYCoord(1,1),new XYCoord(2,1)));  	// 
	public static ArrayList<XYCoord> coord11 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(1,0), new XYCoord(2,0),new XYCoord(0,1),new XYCoord(1,1)));						//
	public static ArrayList<XYCoord> coord12 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(1,0), new XYCoord(0,1),new XYCoord(1,1),new XYCoord(2,1)));						//
	
	//Creating pieces
	public static Piece piece1 = new Piece(1, color1, coord1, 0, firstHeight);
	public static Piece piece2 = new Piece(2, color2, coord2, 200, firstHeight);
	public static Piece piece3 = new Piece(3, color3, coord3, 400, firstHeight);
	public static Piece piece4 = new Piece(4, color4, coord4, 600, firstHeight);
	public static Piece piece5 = new Piece(5, color5, coord5, 800, firstHeight);
	public static Piece piece6 = new Piece(6, color6, coord6, 1000,firstHeight);
	public static Piece piece7 = new Piece(7, color7, coord7, 0, firstHeight +250 );
	public static Piece piece8 = new Piece(8, color8, coord8, 200,firstHeight+ 250);
	public static Piece piece9 = new Piece(9, color9, coord9, 400,firstHeight+ 250);
	public static Piece piece10 = new Piece(10, color10, coord10, 600,firstHeight+250);
	public static Piece piece11 = new Piece(11, color11, coord11, 800,firstHeight+250);
	public static Piece piece12 = new Piece(12, color12, coord12, 1000,firstHeight+ 250);
	
	//Constructor
	public GameSession(int gameID, int gameType, int diff_level, int currLevel)
	{
		this.gameID = gameID;
		this.gameType = gameType;
		this.diff_level = diff_level;
		
		initializeChallenge( currLevel + "");
		
		inventory = new Inventory(0);
		selectedPiece = null;

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
        	  BufferedReader level = new BufferedReader(new FileReader(file)); 
        	  
        	  String line; 
        	  int count  = 1;
        	  int width = 0;
        	  
        	  while ((line = level.readLine()) != null) {
        		  
        		  ArrayList<XYCoord> pieceCoords = new ArrayList<XYCoord>();
        		  
        		 
        		  int start = -1;
        		  int index = line.indexOf(":");

        		  int safe = line.lastIndexOf(":");
					
        		  while( index > 0 && index <= safe ) {
        			  //System.out.println(line.substring(start+1, index));
        			  String temp =  line.substring(start+1, index);
        			  int xCoord = Integer.parseInt( temp.substring(0, temp.lastIndexOf(","))   );
        			  int yCoord = Integer.parseInt( temp.substring(temp.lastIndexOf(",")+1 )   );
        			  
        			  //System.out.println("X: " + xCoord + "  Y: " + yCoord );
        			  
        			  pieceCoords.add(new XYCoord(xCoord, yCoord));
        			  
        			  start = index;
        			  index = line.indexOf(":", index+1);

        		  }
        		  
        		  index = line.lastIndexOf(":");
        		  
        		  ArrayList<Object> temp = new ArrayList<Object>();
        		  
        		  temp.add(new Piece(count, Color.decode( line.substring(index+1 , line.lastIndexOf(";")  ) ) , pieceCoords, width, firstHeight));	//adding piece
        		  
        		  
        		  //System.out.println(line.substring(index+1, line.lastIndexOf(";")));
        		  String insideBoard = line.substring(line.lastIndexOf(";")+1, line.indexOf("/")) ;
        		  //System.out.println(insideBoard);
        		  
        		  if( insideBoard.equals("1")) {
        			  temp.add(true);
        			  //System.out.println("True");
        		  }
        		  else if ( insideBoard.equals("0")  ) {
        			  temp.add(false);
        			  //System.out.println("False");
        		  }
        		  
        		  
        		  index = line.indexOf("/") +1;
        		  int lastIndex = line.lastIndexOf("/");
        		  
        		  int xInGrid = Integer.parseInt( line.substring(index, lastIndex)  );
        		  int yInGrid = Integer.parseInt( line.substring(lastIndex +1 )   );
        		  
        		  //System.out.println("Xcor: " + line.substring(index, lastIndex) + "  Ycor: " + line.substring(lastIndex+1) );
        		  
        		  temp.add(xInGrid);
        		  temp.add(yInGrid);
        		  
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
        			((Piece) allPieces.get(i).get(Indeces.Piece)).setPermaPlaced(!inBoardOrNot );
        		}
        	}
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Inventory getGameSeshInven() {
    	return inventory;
    }

	public void rotateSelectedPieceCCW()
	{
		selectedPiece.rotateCounterClock();
	}
	public void rotateSelectedPieceCW()
	{
		selectedPiece.rotateClock();
	}
	public void rotateSelectedPieceX()
	{
		selectedPiece.rotateRespecttoX();
	}
	public void rotateSelectedPieceY()
	{
		selectedPiece.rotateRespecttoY();
	}






}
import java.util.*;
public class GameSession {
	//Attributes
	int gameID;
	int gameType;
	int diff_level;
	Grid2D grid;
	
	Inventory inventory;
	
	Piece selectedPiece;
	int selectedPieceIndex;
	
	//Shapes of pieces
	public static ArrayList<XYCoord> coord1 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(0,2),new XYCoord(1,2)));
	public static ArrayList<XYCoord> coord2 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(1,1),new XYCoord(1,2)));
	public static ArrayList<XYCoord> coord3 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(1,0),new XYCoord(1,1),new XYCoord(2,0)));
	public static ArrayList<XYCoord> coord4 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(-1,0),new XYCoord(-1,1),new XYCoord(0,-1),new XYCoord(1,-1)));
	public static ArrayList<XYCoord> coord5 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(1,0),new XYCoord(0,2),new XYCoord(1,-1)));
	public static ArrayList<XYCoord> coord6 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(0,-1),new XYCoord(-1,1),new XYCoord(0,-2)));
	public static ArrayList<XYCoord> coord7 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,-1),new XYCoord(1,0),new XYCoord(-1,0),new XYCoord(-2,0)));
	public static ArrayList<XYCoord> coord8 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(1,0)));
	public static ArrayList<XYCoord> coord9 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(-1,0),new XYCoord(0,-1),new XYCoord(1,-1)));
	public static ArrayList<XYCoord> coord10 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(0,1),new XYCoord(-1,0),new XYCoord(0,-1)));
	public static ArrayList<XYCoord> coord11 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(-1,0),new XYCoord(1,0),new XYCoord(-1,-1),new XYCoord(1,-1)));
	public static ArrayList<XYCoord> coord12 = new ArrayList<XYCoord>(Arrays.asList(new XYCoord(0,0), new XYCoord(-1,0),new XYCoord(0,1),new XYCoord(-2,0),new XYCoord(0,2)));
	
	//Creating pieces
	public static Piece piece1 = new Piece(1, 1, coord1);
	public static Piece piece2 = new Piece(1, 1, coord2);
	public static Piece piece3 = new Piece(1, 1, coord3);
	public static Piece piece4 = new Piece(1, 1, coord4);
	public static Piece piece5 = new Piece(1, 1, coord5);
	public static Piece piece6 = new Piece(1, 1, coord6);
	public static Piece piece7 = new Piece(1, 1, coord7);
	public static Piece piece8 = new Piece(1, 1, coord8);
	public static Piece piece9 = new Piece(1, 1, coord9);
	public static Piece piece10 = new Piece(1, 1, coord10);
	public static Piece piece11 = new Piece(1, 1, coord11);
	public static Piece piece12 = new Piece(1, 1, coord12);
	
	//All Pieces in an array
	public static Piece[] allPieces;
	
	//CurrentGameScorer scorer
	
	//Constructor
	public GameSession(int gameID, int gameType, int diff_level)
	{
		this.gameID = gameID;
		this.gameType = gameType;
		this.diff_level = diff_level;
		allPieces = new Piece[] {piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8 ,piece9, piece10, piece11, piece12};
		inventory = new Inventory(0);
		selectedPiece = null;
		selectedPieceIndex = 0;
	}
	
	//Methods
	public int checkFilled(int x, int y)
	{
		return grid.getCellContent(x, y);
	}
	
	public void generatePattern()
	{
		
	}
	public void createGridModels(int rows, int cols)
	{
		
	}
	public void selectNextPiece()
	{
		
	}
	public void selectPreviousPiece()
	{
		
	}
	public boolean placePiece(int headX, int headY)
	{
		return false;
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

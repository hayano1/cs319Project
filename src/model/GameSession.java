import java.util.*;
public class GameSession {
	//Attributes
	int gameID;
	int gameType;
	int diff_level;
	boolean toGrid[];
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
	public static Piece piece2 = new Piece(2, 2, coord2);
	public static Piece piece3 = new Piece(3, 3, coord3);
	public static Piece piece4 = new Piece(4, 4, coord4);
	public static Piece piece5 = new Piece(5, 5, coord5);
	public static Piece piece6 = new Piece(6, 6, coord6);
	public static Piece piece7 = new Piece(7, 7, coord7);
	public static Piece piece8 = new Piece(8, 8, coord8);
	public static Piece piece9 = new Piece(9, 9, coord9);
	public static Piece piece10 = new Piece(10, 1, coord10);
	public static Piece piece11 = new Piece(11, 1, coord11);
	public static Piece piece12 = new Piece(12, 1, coord12);
	
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
		toGrid = new boolean[] {true, true, true, false, true, false, true, true, true, true, false, true };
		inventory = new Inventory(0);
		selectedPiece = null;
		selectedPieceIndex = 0;
		grid = new Grid2D(5, 11);

        for(int count = 0; count < 12; count++){
            inventory.addPiece(allPieces[count]);
        }

        inventory.print();

        initializeChallenge();
        print();
	}
	
	//Methods
    public void initializeChallenge(){}
    {
            //1
            this.selectedPiece = inventory.getPiece(1);
            this.selectedPiece.rotateRespecttoY();
            this.selectedPiece.rotateCounterClock();
            placePiece(8, 0);
            inventory.removePiece(1);

            //2
            this.selectedPiece = inventory.getPiece(2);
            this.selectedPiece.rotateRespecttoY();
            placePiece(5, 4);
            inventory.removePiece(2);

            //3
            this.selectedPiece = inventory.getPiece(3);
            placePiece(6, 4);
            inventory.removePiece(3);

            //5
            this.selectedPiece = inventory.getPiece(5);
            this.selectedPiece.rotateRespecttoX();
            this.selectedPiece.rotateRespecttoY();
            placePiece(0, 1);
            inventory.removePiece(5);

            //7
            selectedPiece = inventory.getPiece(7);
            placePiece(3, 0);
            inventory.removePiece(7);

            //9
            selectedPiece = inventory.getPiece(9);
            placePiece(5, 1);
            inventory.removePiece(9);

            //10
            selectedPiece = inventory.getPiece(10);
            selectedPiece.rotateRespecttoY();
            placePiece(2, 2);
            inventory.removePiece(10);

            //12
            selectedPiece = inventory.getPiece(12);
            selectedPiece.rotateRespecttoY();
            placePiece(0, 4);
            inventory.removePiece(12);

        }

    public int checkFilled(int x, int y)
	{
		return grid.getCellContent(x, y);
	}
	

	public void selectNextPiece()
	{
		if(inventory.getNumOfPieces() > 1 && selectedPieceIndex < inventory.getNumOfPieces() - 1){
		    selectedPieceIndex++;
		    selectedPiece = inventory.getPiece(selectedPieceIndex);
        }
	}
	public void selectPreviousPiece()
	{
        if(inventory.getNumOfPieces() > 1 && selectedPieceIndex > 0){
            selectedPieceIndex++;
            selectedPiece = inventory.getPiece(selectedPieceIndex);
        }
	}
	public boolean pieceInRange(int headX, int headY){

        int indexX = headX;
        int indexY = headY;

        if(grid.getCellContent(headX,headY)!= 0)
            return false;

        for(int count = 0; count < selectedPiece.getSize();count++) {
            indexX = headX + selectedPiece.differenceX(count);
            indexY = headY + selectedPiece.differenceY(count);

            if((indexX > 10) || indexX < 0) {
                return false;
            }

            if((indexY > 4) || (indexY < 0)) {
                return false;
            }
        }
	    return true;
    }

	public boolean placePiece(int headX, int headY)
	{
	    int indexX;
	    int indexY;

        if(pieceInRange(headX,headY)) {
            for(int count = 0; count < selectedPiece.getSize();count++) {
                indexX = headX + selectedPiece.differenceX(count);
                indexY = headY + selectedPiece.differenceY(count);

                if(grid.getCellContent(indexX,indexY) != 0){
                    return false;
                }
            }

            for(int count = 0; count < selectedPiece.getSize();count++) {
                indexX = headX + selectedPiece.differenceX(count);
                indexY = headY + selectedPiece.differenceY(count);

                grid.setCellFilled(indexX, indexY, selectedPiece.getPieceID());
            }

            inventory.removePiece(selectedPiece.getPieceID());
            selectNextPiece();
        }

		return true;
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
	public void print(){
	    System.out.println("GRID:");
	    grid.print();
	    System.out.println("INVENTORY:");
	    inventory.print();
    }
}

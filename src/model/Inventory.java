import java.util.ArrayList;

public class Inventory {
	//attributes
	int inventoryID;
	int numOfPieces;
	ArrayList<Piece> pieces;
	
	//constructor
	public Inventory(int inventoryID)
	{
		this.inventoryID = inventoryID;
		numOfPieces = 0;
		pieces = new ArrayList<Piece>();
	}
	
	//METHODS
	
	//gets number of pieces
	public int getNumOfPieces()
	{
		return numOfPieces;
	}
	//adds a piece into the inventory
	public void addPiece(Piece newPiece)
	{
		this.pieces.add(newPiece);
		numOfPieces++;
	}
	//gets a piece from the inventory
	public Piece getPiece(int pieceID)
	{
		Piece getPiece = new Piece(0,0,new ArrayList<XYCoord>());
		for(int i = 0;i < pieces.size(); i++)
		{
			if(pieceID == pieces.get(i).getPieceID())
			{
				getPiece = pieces.get(i);
				break;
			}
		}
		return getPiece;
	}
	//removes a piece from the inventory
	public boolean removePiece(int pieceID)
	{
        for(int i = 0; i < pieces.size(); i++)
			{
				if(pieceID == pieces.get(i).getPieceID()) {
                    pieces.remove(i);
                    numOfPieces--;
                    return true;
                }
			}
		return false;
	}

	public void print(){
	    for(int count = 0; count < numOfPieces;count++){
	        System.out.print(pieces.get(count).getPieceID() + " ");
        }
    }
}

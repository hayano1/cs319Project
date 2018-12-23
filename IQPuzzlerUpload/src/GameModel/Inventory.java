package GameModel;
import java.util.ArrayList;

import Generated.Piece;

public class Inventory {
	//attributes
	int inventoryID;
	int numOfPieces;
	static public ArrayList<Piece> pieces;
	
	//constructor
	public Inventory(int inventoryID)
	{
		this.inventoryID = inventoryID;
		numOfPieces = 0;
		pieces = new ArrayList<Piece>();
	}
	
	
	//gets number of pieces
	public int getNumOfPieces()
	{
		return numOfPieces;
	}
	//adds a piece into the inventory
	public void addPiece(Piece newPiece)
	{
		pieces.add(newPiece);
		numOfPieces++;
	}
	//gets a piece from the inventory
	public Piece getPiece(int pieceID)
	{
		Piece getPiece = null;
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

	public ArrayList<Piece> getAllPieces(){
		return pieces;
	}
	
	
 	public void print(){
	    for(int count = 0; count < numOfPieces;count++){
//	        System.out.print(pieces.get(count).getPieceID() + " ~");
        }
    }
}

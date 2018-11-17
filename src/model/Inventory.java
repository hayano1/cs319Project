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
	public void addPiece(int color, ArrayList<XYCoord> listCoordinates)
	{
		Piece newPiece = new Piece(numOfPieces, color, listCoordinates);
		numOfPieces++;
		pieces.add(newPiece);
	}
	//gets a piece from the inventory
	public Piece getPiece(int pieceID)
	{
		Piece getPiece = new Piece();
		for(int i = 0;i < pieces.size(); i++)
		{
			if(pieceID == pieces.get(i).pieceID)
			{
				getPiece = pieces.get(i);
				break;
			}
		}
		return getPiece;
	}
	//removes a piece from the inventory
	public Piece removePiece(int pieceID)
	{
		Piece removedPiece = new Piece();
		try{
			for(int i = 0; i < pieces.size(); i++)
			{
				if(pieceID == pieces.get(i).pieceID)
				{
					removedPiece = pieces.get(i);
					pieces.remove(i);
					numOfPieces--;
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println("Piece ID not found to remove");
		}
		return removedPiece;
	}
}

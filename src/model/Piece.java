import java.util.ArrayList;

public class Piece {
	//attributes
	int pieceID;
	int color;
	int size;
	XYCoord coordinates[];
	
	//constructor
	
	public Piece(){};
	
	public Piece(int pieceID, int color, ArrayList<XYCoord> listCoordinates)
	{
		this.pieceID = pieceID;
		this.color = color;
		size = listCoordinates.size();
		coordinates = new XYCoord[size];
	}
	//gets piece ID
	public int getPieceID()
	{
		return pieceID;
	}
	//gets color
	public int getColor()
	{
		return color;
	}
	//rotates piece's Y coordinates
	public void rotateRespecttoX()
	{
		for(int i = 0; i < size; i++)
		{
			if(coordinates[i].getY() != 0)
			{
				int newY = coordinates[i].getY() * -1;
				coordinates[i].setY(newY);
			}
		}
	}
	//rotates piece's X coordinates
	public void rotateRespecttoY()
	{
		for(int i = 0; i < size; i++)
		{
			if(coordinates[i].getX() != 0)
			{
				int newX = coordinates[i].getX() * -1;
				coordinates[i].setY(newX);
			}
		}
	}
	//rotates 90 degrees, counter-clockwise
	public void rotateCounterClock()
	{
		int newX = 0;
		int newY = 0;
		for(int i = 1; i < size; i++)
		{
			newX = coordinates[i].getY();
			newY = coordinates[i].getX();
			coordinates[i].setX(newX);
			coordinates[i].setY(newY);
		}
		this.rotateRespecttoY();
	}
	//rotates 90 degrees, clockwise
	public void rotateClock()
	{
		int newX = 0;
		int newY = 0;
		for(int i = 1; i < size; i++)
		{
			newX = coordinates[i].getY();
			newY = coordinates[i].getX();
			coordinates[i].setX(newX);
			coordinates[i].setY(newY);
		}
		this.rotateRespecttoX();
	}
	//gets the coordinates of the balls on a piece
	public XYCoord[] getCoordinates()
	{
		return coordinates;
	}
}
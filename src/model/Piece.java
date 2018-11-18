package com.iqpuzzler.model;
import com.iqpuzzler.model.XYCoord;
import java.util.ArrayList;

public class Piece {
    //attributes
    int pieceID;
    int color;
    int size;
    ArrayList<XYCoord> coordinates;

    //constructor

    public Piece(){};

    public Piece(int pieceID, int color, ArrayList<XYCoord> listCoordinates)
    {
        this.pieceID = pieceID;
        this.color = color;
        size = listCoordinates.size();
        coordinates = listCoordinates;
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
            if(coordinates.get(i).getY() != 0)
            {
                int newY = coordinates.get(i).getY() * -1;
                coordinates.get(i).setY(newY);
            }
        }
    }
    //rotates piece's X coordinates
    public void rotateRespecttoY()
    {
        for(int i = 0; i < size; i++)
        {
            if(coordinates.get(i).getX() != 0)
            {
                int newX = coordinates.get(i).getX() * -1;
                coordinates.get(i).setY(newX);
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
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
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
            newX = coordinates.get(i).getY();
            newY = coordinates.get(i).getX();
            coordinates.get(i).setX(newX);
            coordinates.get(i).setY(newY);
        }
        this.rotateRespecttoX();
    }
    //gets the coordinates of the balls on a piece
    public ArrayList<XYCoord> getCoordinates()
    {
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
}
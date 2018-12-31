package Mechanics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Stack;
import GameModel.XYCoord;
import java.awt.Color;

public class GenerateRandom {
	
	private int boardWidth; 
	private int boardHeight;
	private int board[][];
	private String name;
        
        private ArrayList<String> allColor;
	
	private ArrayList<ArrayList<XYCoord>> allCords;
	
        
	int minNr = 3;
	int maxNr = 6;
	
	
	public GenerateRandom(int xWidth, int yHeight, String namee) {
		
		boardWidth = xWidth;
		boardHeight = yHeight;
		name = namee;
                
                allColor = new ArrayList<String>();
                allColor.add("#1c40a2");
                allColor.add("#ffe222");
                allColor.add(("#dbdbdb"));
                allColor.add(("#b10d88"));
                allColor.add(("#e11035"));
                allColor.add(("#05d105"));
                allColor.add(("#ff9742"));
                allColor.add(("#bc4567"));
                allColor.add(("#bc91ca"));
                allColor.add(("#1b01bf"));
                allColor.add(("#a4fcb1"));
                allColor.add(("#ff3d1e"));
                
                
		
		allCords =  new ArrayList<ArrayList<XYCoord>>();
		
		board = new int[yHeight][xWidth];
		
		for( int i = 0 ;  i < yHeight; i ++) {
			for( int j = 0; j < xWidth; j++) {
				
				board[i][j] = -1;
				
			}
		}
		
		generateCords();
		
		
		printAll();
		
		writeGene();
		
		
	}
	
	private void printAll() {
		for( int i = 0 ;  i < boardHeight; i ++) {
			for( int j = 0; j < boardWidth; j++) {
				
				System.out.printf(" %3d " ,board[i][j] ); 
				
			}
			System.out.println("");
		}
	}
	
	private void generateCords() {
		
		int pieceID = 0;
		
		for( int i = 0 ;  i < boardHeight; i ++) {	//iterate through all tiles in board
			for( int j = 0; j < boardWidth; j++) {	//same
				
				if( board[i][j] == -1 ) {		//if we find an empty tile we want to start a piece at it
					
					System.out.println("Potential for a new  piece at: " + j + "  "  + i  );
				
					ArrayList<XYCoord> tempCords = new ArrayList<XYCoord>();	//save an array list of coordinates for the piece
					
					
					int randomNrOfPieces = (int)(Math.random() * (maxNr +1 - minNr )+ minNr); //get how many components the piece will have
					//System.out.println("Random: " + randomNrOfPieces + " ========================================================");
					
					System.out.printf("From %d to %d choose: %d   ======================================================== \n" , minNr , maxNr , randomNrOfPieces);
					
					int tempI = i;
					int tempJ = j;
					
					Stack<XYCoord> myStack = new Stack<XYCoord>();
					int direction = -1;
				
					while( randomNrOfPieces > 0) {
						
						int dirNo = 0;
						boolean dirs[] = new boolean[4];	// -x	+x	-y	+y		directions
						
						if( tempI >=0 && tempI < boardHeight && tempJ >=0 && tempJ < boardWidth && board[tempI][tempJ] == -1) {	//we have a coordinate for a piece
							
							tempCords.add(new XYCoord(tempI, tempJ)); //saving coordinates
							board[tempI][tempJ] = pieceID;	//marking the tile as taken
						
						
							for( int k = 0; k < 4; k++) {	//Reseting directions
								dirs[k] = false;
							}
							
							if( tempJ - 1 >= 0 && board[tempI][tempJ-1] == -1  && direction != 1) {	//if we have a tile and we didn't go that way earlier
								dirs[0] = true;
								System.out.println("pot left");
								dirNo++;
							}
							
							if( tempJ + 1 < boardWidth && board[tempI][tempJ+1] == -1  && direction != 2) {
								dirNo++;
								System.out.println("pot right");
								dirs[1] = true;
							}
							
							if( tempI - 1 >= 0  && board[tempI-1][tempJ] == -1 && direction != 3) {
								dirNo++;
								System.out.println("pot up");
								dirs[2] = true;
							}
							
							if( tempI + 1 < boardHeight  && board[tempI+1][tempJ] == -1  && direction != 4) {
								dirNo++;
								System.out.println("pot down");
								dirs[3] = true;
							}
						}
						
						
						if( dirNo == 0) {
							//no where to go so we go back
							if( myStack.isEmpty()) {
								System.out.println("Sorry no where to go now");
								break;
							}
							else {
								XYCoord temp = myStack.pop();
								direction = -1;
								
								tempI = temp.getX();
								tempJ = temp.getY();	
							}
							
						}
						else {
							
							System.out.println(dirNo  + "  <- DirNo  " + tempI + "  "  + tempJ );
							int randomDirection = (int)(Math.random() * dirNo + 1);
							System.out.printf("From %d to %d choose %d: \n" , 1 , dirNo , randomDirection);
							
							System.out.printf("%s  %s  %s  %s \n" , dirs[0],dirs[1],dirs[2],dirs[3] );
							
							int count = 0;
							for( int m = 1; m <= 4 ; m ++) {
								
								if( dirs[m-1] == true) {
									count++;	//decrement so we know what direction we took
								}
								
								if( count == randomDirection) {
									
									if( m == 1) {
										System.out.println("going left");
										tempJ = tempJ - 1;
										randomNrOfPieces--;
									}
									else if( m == 2) {
										System.out.println("going right");
										tempJ = tempJ + 1;
										randomNrOfPieces--;
									}
									else if( m == 3) {
										System.out.println("going up");
										tempI = tempI -1;
										randomNrOfPieces--;
									}
									else if( m == 4) {
										System.out.println("going down");
										tempI = tempI +1;
										randomNrOfPieces--;
									}
									else {
										//direction = -1;
									}
									
									direction  = m;
									System.out.println("Direction: " + direction);
									
									
									
									myStack.push(new XYCoord(tempI, tempJ));
									
									//printAll();
									//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
										
									break;
								}
								
								
							}
						
						}
						
					}
					
					allCords.add(tempCords);
					
					myStack.clear();
					pieceID++;
				
				
				
				}
								
				
			}
		}
		
		
		
		
	}
	
	private ArrayList<XYCoord> fixCoords(ArrayList<XYCoord> cords){
		
		ArrayList<XYCoord> temp = cords;
		
		
		int xMax = -5000;
		int xMin =  5000;
		int yMax =  -5000;
		int yMin =  5000;
		
		for( int i = 0; i < temp.size(); i++) {
			
			if( xMax < temp.get(i).getX() ) {
				xMax = temp.get(i).getX();
			}
			
			if( xMin > temp.get(i).getX()) {
				xMin = temp.get(i).getX();
			}
			
			if( yMax < temp.get(i).getY() ) {
				yMax = temp.get(i).getY();
			}
			
			if( yMin > temp.get(i).getY()) {
				yMin = temp.get(i).getY();
			}
			
		}
		
		
		for( int i = 0; i < temp.size(); i++) {
			
			cords.get(i).setX( cords.get(i).getX() - xMin );
			cords.get(i).setY( cords.get(i).getY() - yMin );

		}
		
		
		
		
		
		//width = ( Math.abs(xMax) + Math.abs(xMin) +1 )* Tile.TileWidth + 5;
		//height =  ( Math.abs(yMax) + Math.abs(yMin) +1)* Tile.TileHeight + 5;
		
		//return  new Dimension( width, height );
		
		
		
		
		
		return cords;
	}

	private void writeGene() {
		
		
		Writer writer = null;

		System.out.println("===========================================================");
		
		try {

			
			File a = new File("Levels//Generated//" + name +".txt");
			if (a.createNewFile())
			{
			    System.out.println("File is created!");
			} else {
			    System.out.println("File already exists.");
			}
			System.out.println( a.exists()  + " _________________________________");
				
			
		   // writer = new BufferedWriter(new OutputStreamWriter(
		     //     new FileOutputStream("SavedGames//" + savedDate +".txt"), "utf-8"));
		    
			writer = new FileWriter(a , true);
			
			writer.write("30000");
			writer.write(System.getProperty( "line.separator" ));
			
		    int length =  allCords.size();
		    
                    int countColor = 0;
		    
		    for( int i = 0; i < length; i++,countColor++) {
		    	
		    	ArrayList<XYCoord> coords = allCords.get(i);
		    	
		    	
		    	coords = fixCoords(coords);
		    	
		    	int cordsLength =  coords.size();
		    	
		    	for( int j = 0; j < cordsLength; j++ ) {
		    		 writer.write( coords.get(j).getY()+ ","  +coords.get(j).getX());
		    		 	System.out.print(coords.get(j).getY()+ ","  +coords.get(j).getX());
		    		 writer.write(":");
		    		 	System.out.print(":");
		    	}
		    	
		    	//writer.write("#"+Integer.toHexString(temp.getColor().getRGB()).substring(2)  + "");
                        
                    
                        
		    	writer.write( allColor.get( countColor%12 ) );
		    		System.out.print("#2d2d2d");
		    	writer.write(";");
		    		System.out.print(";");
		    	
		    	writer.write("1");
		    		System.out.print("1");


		    	writer.write("/");
		    		System.out.print("/");
		    	
		    	writer.write("-1");
		    		System.out.print("-1");
		    		
		    		
		    	writer.write("/");
		    		System.out.print("/");
			    writer.write("-1");
		    		System.out.print("-1");
		    	
		    	writer.write("=0");
		    		System.out.print("=0");
		    	
		    	writer.write(System.getProperty( "line.separator" ));
		    	
		    }
		    
		    System.out.println("===========================================================");
		    	
		} catch (IOException ex) {
		   	ex.printStackTrace();
		} finally {
		   try {
			   writer.close();
		   }catch (Exception ex) {}
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}

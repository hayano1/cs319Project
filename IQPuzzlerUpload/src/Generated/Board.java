package Generated;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import GameModel.GameSession;
import GameModel.Indeces;
import GameModel.XYCoord;
import UI.main;
import UI.panelTemp;

public class Board extends panelTemp implements KeyListener {

	private static final long serialVersionUID = 1L;

	static public int boardWidth, boardHeight;
	static private int currHeight, currWidth;
	static int firstTileClickedX, firstTileClickedY;
	static public int totalMoves;
	static int x, y;
	static int oldTileX = 0, oldTileY = 0;

	static boolean insideGrid = false;
	static boolean eligibleForPlacement = false;

	public static int TileType;

	static Tile[][] tileArray;
	static ArrayList<Piece> piecesArray;
	static ArrayList<XYCoord> eligibleTilesForPlacement;
	static XYCoord eligibleForPlacementOriginCoords;

	public static MouseListenerForBoard mos;
	static public Piece selectedPiece;
	static public GameSession gameSesh;

	
	//Constructor
	public Board(int width, int height, int TileTypee) {
		setFocusable(true);
		addKeyListener(this);

		this.setLayout(new BorderLayout());

		boardWidth = width;
		boardHeight = height;
		totalMoves = 0;

		TileType = TileTypee;

		gameSesh = new GameSession(1, 1, 1, 1);

		eligibleTilesForPlacement = new ArrayList<XYCoord>();
		eligibleForPlacementOriginCoords = new XYCoord(-1,-1); ////////////////////////////////////////////////////////// <- doing this now
		piecesArray = gameSesh.inventory.getAllPieces();

		generateTiles();

		fixAllPiecesAndTiles();

		mos = new MouseListenerForBoard();
		addMouseListener(mos);
		addMouseMotionListener(mos);

	}

	public void keyPressed(KeyEvent evt) {
		//System.out.println("Key PRessed");
	}

	public void keyReleased(KeyEvent evt) {

		int keyCode = evt.getKeyCode();

		if (selectedPiece != null) {

			playMusic(3);

			if (keyCode == KeyEvent.VK_LEFT) {
				System.out.println("Left");
				Board.selectedPiece.rotateCounterClock();
				main.window.repaint();
			}

			else if (keyCode == KeyEvent.VK_RIGHT) {
				System.out.println("Right");
				Board.selectedPiece.rotateClock();
				main.window.repaint();
			}

			else if (keyCode == KeyEvent.VK_UP) {
				System.out.println("UP");
				Board.selectedPiece.rotateRespecttoY();
				main.window.repaint();
			}

			else if (keyCode == KeyEvent.VK_DOWN) {
				System.out.println("Down");
				Board.selectedPiece.rotateRespecttoX();
				main.window.repaint();
			}

			
		}
		else if (keyCode == KeyEvent.VK_ESCAPE) {
			// pause panel dont change this
			System.out.println("Escape Pressed");
			activatedPanel = 9;

		}
		
		
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void playMusic(int in) {

		try {
			String soundName = "";
			if (in == 1)
				soundName = "Music\\zika.wav";
			else if (in == 2)
				soundName = "Music\\zika1.wav";
			else if (in == 3)
				soundName = "Music\\rotate.wav";

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void generateTiles() {

		if (TileType == 0) {
			int id = 0;
			tileArray = new Tile[boardHeight][boardWidth];

			for (int i = 0; i < boardHeight; i++) {
				for (int j = 0; j < boardWidth; j++) {

					currHeight = i * Tile.TileHeight;
					currWidth = j * Tile.TileWidth;

					tileArray[i][j] = new Tile(currWidth, currHeight, id, -1, TileType, true);

					id++;
				}
			}
		} else if (TileType == 1) {

			boardHeight = boardWidth = 9;

			int illegalTile[] = new int[] { 1, 6, 7, 8, 9, 15, 16, 17, 18, 26, 27, 35, 36, 46, 47, 55, 56, 64, 65, 66,
					67, 73, 74, 75, 76, 81 };
			tileArray = new Tile[boardHeight][boardWidth];
			int id = 0;

			boolean boo = true;

			System.out.println("=============================================");
			for (int i = 0; i < boardHeight; i++) {
				for (int j = 0; j < boardWidth; j++) {
					boo = true;

					currHeight = i * Tile.TileHeight;
					currWidth = j * Tile.TileWidth;

					for (int k = 0; k < 26; k++) {
						if (id + 1 == illegalTile[k]) {
							boo = false;
							break;
						}
					}

					if (boo) {
						tileArray[i][j] = new Tile(currWidth, currHeight, id, -1, TileType, true);
						id++;
					} else {
						tileArray[i][j] = new Tile(currWidth, currHeight, id, -1, TileType, false);
						id++;
					}
				}
			}
			System.out.println("=============================================");

		}

	}
	
	private int[] getForTile1(MouseEvent e) {
		
		int ret[] = new int[2];
		
		double w = boardWidth * Tile.TileHeight*0.5;
		double h = boardHeight * Tile.TileHeight*0.2;
		
		double x1 =  e.getPoint().getX() -w;
		double y1 =  e.getPoint().getY() -h;
		
		double coss = Math.cos(Math.toRadians(-45));
		double sinn = Math.sin(Math.toRadians(-45));
		
		int xx = (int) (w +( ( x1 * coss ) + ( y1 *  sinn) ));
		int yy = (int) (h +( ( y1 * coss ) - ( x1 * sinn ) )); 
		
		
		xx = xx / Tile.TileWidth;
		yy = yy / Tile.TileHeight;
		
		ret[0] = xx;
		ret[1] = yy;
		
		return ret;
	}
	
	private void resetForPiece(int pieceID) {

		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (tileArray[j][i].pieceId == pieceID) {
					tileArray[j][i].pieceId = -1;
					tileArray[j][i].setState(Tile.TileStates.Normal);
				}
			}
		}

	}

	public void placePieceIntoBoard() {

		resetForPiece(selectedPiece.pieceID);

		int length = eligibleTilesForPlacement.size();
		
		System.out.println("PX: " + eligibleForPlacementOriginCoords.getX()  + "   PY: "  + eligibleForPlacementOriginCoords.getY()  );
		
		selectedPiece.setXCordsInBoard( eligibleForPlacementOriginCoords );

		for (int i = 0; i < length; i++) {

			int xc = eligibleTilesForPlacement.get(i).getX();
			int yc = eligibleTilesForPlacement.get(i).getY();

			Tile temp = tileArray[yc][xc];

			temp.setState(Tile.TileStates.Taken);
			temp.setTakenColor(selectedPiece.color);
			temp.pieceId = selectedPiece.pieceID;

			selectedPiece.placed = true;

		}

		printGrid();

		main.window.repaint();

	}

	public void printGrid() {

		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				System.out.print(tileArray[j][i].pieceId + " ");
			}
			System.out.println("");
		}
	}

	public int getTotalMoves() {
		return totalMoves;
	}

	public void generateTilesUnderPiece(MouseEvent e) {

		if (selectedPiece != null) {

			int x = e.getX();
			int y = e.getY();

			int xx = x / Tile.TileWidth;
			int yy = y / Tile.TileHeight;

			firstTileClickedX = xx;
			firstTileClickedY = yy;

			eligibleForPlacement = true;

			ArrayList<XYCoord> temp = selectedPiece.getCoordinates();
			int length = temp.size();

			int selectedPieceXCord = selectedPiece.clickedCircleOnShape.getX();
			int selectedPieceYCord = selectedPiece.clickedCircleOnShape.getY();

			for (int i = 0; i < length; i++) {

				int checkX = xx + temp.get(i).getX() - selectedPieceXCord;
				int checkY = yy + temp.get(i).getY() - selectedPieceYCord;

				if (checkX >= 0 && checkX < boardWidth && checkY >= 0 && checkY < boardHeight) {

					if (tileArray[checkY][checkX].pieceId == -1
							|| tileArray[checkY][checkX].pieceId == selectedPiece.pieceID) {

						eligibleTilesForPlacement.add(new XYCoord(checkX, checkY));

					} else {
						eligibleForPlacement = false;
						eligibleTilesForPlacement.clear();
						eligibleForPlacementOriginCoords.setX(-1);
						eligibleForPlacementOriginCoords.setY(-1);
						break;
					}
				} else {
					eligibleForPlacement = false;
					eligibleTilesForPlacement.clear();
					eligibleForPlacementOriginCoords.setX(-1);
					eligibleForPlacementOriginCoords.setY(-1);
					break;
				}
			}

		}

		main.window.repaint();

	}

	public boolean checkForEndGame() {

		boolean fullBoard = true;

		System.out.println(boardWidth + " " + boardHeight);

		for (int i = 0; i < boardHeight; i++) {
			for (int j = 0; j < boardWidth; j++) {

				if (tileArray[i][j].pieceId == -1 && tileArray[i][j].visible) {
					fullBoard = false;
					break;
				}

			}
		}

		if (fullBoard) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("                   Game Won  With: " + totalMoves + " moves");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}

		return fullBoard;
	}

	public void fixAllPiecesAndTiles() {
		int length = gameSesh.allPieces.size();

		for (int i = 0; i < length; i++) {
			
			ArrayList<Object> thisPieceInfo =  gameSesh.allPieces.get(i);
			
			
			if (!(Boolean) thisPieceInfo.get(Indeces.InBoard)) {

				int xCord = (Integer) thisPieceInfo.get(Indeces.xInBoaard);
				int yCord = (Integer) thisPieceInfo.get(Indeces.yInBoaard);

				System.out.println("ASDFASDF " + xCord + "  " + yCord +  "  "+ boardWidth + " " + boardHeight);
				piecesArray.get(i).setConstructorXandY(xCord * Tile.TileWidth, yCord * Tile.TileHeight);
				
				
				piecesArray.get(i).setPermaPlaced( (Boolean) thisPieceInfo.get(Indeces.permaPlaced) );
				piecesArray.get(i).placed = true;
				piecesArray.get(i).xInGrid = xCord;
				piecesArray.get(i).yInGrid = yCord;
				
				
				
				piecesArray.get(i).returnToOrigin();

				ArrayList<XYCoord> tempCoords = piecesArray.get(i).getCoordinates();

				int lengthh = tempCoords.size();

				for (int j = 0; j < lengthh; j++) {

					int yTemp = yCord + tempCoords.get(j).getY();
					int xTemp = xCord + tempCoords.get(j).getX();

					tileArray[yTemp][xTemp].occupied = true;
					tileArray[yTemp][xTemp].setState(Tile.TileStates.Taken);
					tileArray[yTemp][xTemp].setTakenColor(piecesArray.get(i).getColor());
					tileArray[yTemp][xTemp].pieceId = piecesArray.get(i).pieceID;
				}

			}
			
		
		}

	}

	//Paint Component
	public void paintComponent(Graphics g) {

		for (int i = 0; i < boardHeight; i++) {
			for (int j = 0; j < boardWidth; j++) {

				tileArray[i][j].paintComponent(g);

			}
		}

		ArrayList<Piece> temp = piecesArray;
		int length = temp.size();

		for (int i = 0; i < length; i++) {
			//System.out.print(temp.get(i).pieceID + " -");
			 temp.get(i).paintComponent(g);
		}

	}
	
	public double[] getTiltedCoordsForPiece(int xC, int yC) {
		
		
		double ret[] = new double[2];
		
		double w = boardWidth * Tile.TileHeight*0.5;		//rotation points
		double h = boardHeight * Tile.TileHeight*0.2;		//rotation points
		
		double x1 =  (xC)*Tile.TileWidth -w;
		double y1 =  (yC)*Tile.TileHeight -h;
		
		double coss = Math.cos(Math.toRadians(+45));
		double sinn = Math.sin(Math.toRadians(+45));
		
		int xx = (int) (w +( ( x1 * coss ) + ( y1 *  sinn) ));
		int yy = (int) (h +( ( y1 * coss ) - ( x1 * sinn ) )); 

		
		ret[0] = xx;
		ret[1] = yy;
		
		return ret;
	}
	
	public void saveGame(int theTileType) {
		
		
		Writer writer = null;

		System.out.println("===========================================================");
		
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
			Date date = new Date();
			String savedDate = dateFormat.format(date);
			
			File a = new File("SavedGames//" + savedDate +".txt");
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
			
			writer.write("Time left on the saved game is here");
			writer.write(System.getProperty( "line.separator" ));
			
		    int length =  piecesArray.size();
		    
		    
		    for( int i = 0; i < length; i++) {
		    	
		    	Piece temp = piecesArray.get(i);
		    	
		    	ArrayList<XYCoord> coords = temp.getCoordinates();
		    	
		    	
		    	int cordsLength =  coords.size();
		    	
		    	for( int j = 0; j < cordsLength; j++ ) {
		    		 writer.write( coords.get(j).getX()+ ","  +coords.get(j).getY());
		    		 	System.out.print(coords.get(j).getX()+ ","  +coords.get(j).getY());
		    		 writer.write(":");
		    		 	System.out.print(":");
		    	}
		    	
		    	writer.write("#"+Integer.toHexString(temp.getColor().getRGB()).substring(2)  + "");
		    		System.out.print("#"+Integer.toHexString(temp.getColor().getRGB()).substring(2)  + "");
		    	writer.write(";");
		    		System.out.print(";");
		    	
		    	if( temp.placed ) {
		    		writer.write("0");
		    			System.out.print("0");
		    	}
		    	else {
		    		writer.write("1");
		    			System.out.print("1");
		    	}
		    	
		    	
		    	
		    	
		    	writer.write("/");
		    		System.out.print("/");
		    	
		    	writer.write(temp.xInGrid+"");
		    		System.out.print(temp.xInGrid);
		    		
		    		
		    	writer.write("/");
		    		System.out.print("/");
		    	writer.write(temp.yInGrid+"");
		    		System.out.print(temp.yInGrid);
		    		
		    	
		    	

		    	if( temp.permaPlaced ) {
		    		writer.write("=1");
		    			System.out.print("=1");
		    	}
		    	else {
		    		writer.write("=0");
		    			System.out.print("=0");
		    	}
		    	
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
	
	
	class MouseListenerForBoard extends MouseAdapter implements MouseMotionListener {

		public void mouseClicked(MouseEvent e) {

			System.out.println("Clicked the board !!");
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("Entered");
			Board.this.requestFocusInWindow();
			
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {

			int length = piecesArray.size();

			for (int i = 0; i < length; i++) {

				if (piecesArray.get(i).insideShape(e) && !piecesArray.get(i).permaPlaced) {

					eligibleForPlacement = true;

					selectedPiece = piecesArray.get(i);

					System.out.println("Inside Ppiece number " + selectedPiece.pieceID);

					selectedPiece.setFirstPoint(e.getX(), e.getY());
					selectedPiece.setPieceFocus(true);

					repaint();
					break;
				} else {
					piecesArray.get(i).setPieceFocus(false);
					repaint();
				}
			}

			generateTilesUnderPiece(e);

		}

		public void mouseReleased(MouseEvent e) { // done coloring problems

			int x = 0;
			int y = 0;
			//saveGame(0);
			
			
			if( TileType == 0) {
				x = e.getX() / Tile.TileWidth;
				y = e.getY() / Tile.TileHeight;
			}
			else if(TileType == 1) {
				
				int ret[] = getForTile1(e);
				
				System.out.println(ret[0] + " ~released~  " + ret[1]);
				
				x = ret[0] ;
				y = ret[1] ;
				
			}
			
			if (selectedPiece != null) {
				selectedPiece.setPieceFocus(false);

				if (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) {

					if (firstTileClickedX == x && firstTileClickedY == y) {
						if (totalMoves > 0)
							totalMoves--;
					}

					int pXCord = selectedPiece.clickedCircleOnShape.getX();
					int pYCord = selectedPiece.clickedCircleOnShape.getY();
					
					System.out.println(pXCord + " ~sele  " + pYCord);
					
					Point p  = null;

					if( TileType == 0) {
						x = x - pXCord;
						y = y - pYCord;
	
						p = new Point(x * Tile.TileHeight, y * Tile.TileWidth);
					}
					else if(TileType == 1) {
						
						x = x - pXCord;
						y = y - pYCord;
						
						double ret[] = getTiltedCoordsForPiece(x,y);
						
						p = new Point((int)ret[0], (int)ret[1]);
						
					}

					selectedPiece.setPosition(p);

					if (eligibleForPlacement) {
						
						placePieceIntoBoard();
						totalMoves++;
						playMusic(1);
						checkForEndGame();

					} else {
						
						selectedPiece.returnToOrigin();
						resetForPiece(-1);
						playMusic(2);
					
					}

				} else {

					if (selectedPiece != null) {
						playMusic(2);
						resetForPiece(selectedPiece.pieceID);
						selectedPiece.placed = false;
					}

				}

			}

			saveGame(0);
			
			main.window.repaint();

			// resetting values now
			eligibleTilesForPlacement.clear();
			eligibleForPlacementOriginCoords.setX(-1);
			eligibleForPlacementOriginCoords.setY(-1);
			eligibleForPlacement = false;
			selectedPiece = null;
			// ===============

			System.out.println("current number of moves: " + totalMoves);

		}

		public void mouseDragged(MouseEvent e) {

			mouseMoved(e);

			if (selectedPiece != null) {

				selectedPiece.setSecondPoint(e.getX(), e.getY());
				main.window.repaint();

			}
		}

		public void mouseMoved(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();
			
			int xx = 0;
			int yy = 0;

			if(TileType == 0 ) {
				xx = x / Tile.TileWidth;
				yy = y / Tile.TileHeight;
			}
			else if( TileType == 1) {
				
				int ret[] = getForTile1( e);
				
				xx = ret[0];
				yy = ret[1];
				
				//System.out.println("XX: " + xx + "  YY: " + yy);
				
			}
			if (xx >= 0 && xx < boardWidth && yy >= 0 && yy < boardHeight) { // if we are inside the grid we now can do all the operations to make the grid and the pieces work together

				// set inside grid as true, in order to get an old value for X
				// and Y in order to trace mouse movement
				if (!insideGrid) {
					insideGrid = true;
					oldTileX = xx;
					oldTileY = yy;
				}


				// if the mouse changes tile, then we want to make all tiles
				// that are not occupied normal again and the ones that are
				// occupied paint them as taken
				if (oldTileX != xx || oldTileY != yy) {
					if (tileArray[oldTileY][oldTileX].pieceId == -1)

						for (int i = 0; i < boardWidth; i++) {
							for (int j = 0; j < boardHeight; j++) {

								if (tileArray[j][i].pieceId == -1) {
									tileArray[j][i].setState(Tile.TileStates.Normal);
								}

							}
						}

					main.window.repaint();
					oldTileX = xx; // assigning new old values for x
					oldTileY = yy; // assigning new old values for y
				}

				tileArray[yy][xx].mouseEntered(e);

				if (selectedPiece != null) {

					eligibleTilesForPlacement.clear();
					eligibleForPlacement = true;
					
					eligibleForPlacementOriginCoords.setX(-1);
					eligibleForPlacementOriginCoords.setY(-1);
					

					ArrayList<XYCoord> temp = selectedPiece.getCoordinates();
					int length = temp.size();

					int selectedPieceXCord = selectedPiece.clickedCircleOnShape.getX();
					int selectedPieceYCord = selectedPiece.clickedCircleOnShape.getY();

					for (int i = 0; i < length; i++) {

						int checkX = 0;
						int checkY = 0;
						
						checkX = xx + temp.get(i).getX() - selectedPieceXCord;
						checkY = yy + temp.get(i).getY() - selectedPieceYCord;

						if (checkX >= 0 && checkX < boardWidth && checkY >= 0 && checkY < boardHeight) {

							if ( (tileArray[checkY][checkX].pieceId == -1 || tileArray[checkY][checkX].pieceId == selectedPiece.pieceID) && tileArray[checkY][checkX].visible) {
								

								eligibleForPlacementOriginCoords.setX(xx - selectedPieceXCord);
								eligibleForPlacementOriginCoords.setY(yy - selectedPieceYCord);

								//System.out.printf("XX: %d  YY: %d  checkX: %d  checkY: %d \n" , xx , yy, selectedPieceXCord, selectedPieceYCord);

								tileArray[checkY][checkX].setState(Tile.TileStates.PotentialSelection);
								
								eligibleTilesForPlacement.add(new XYCoord(checkX, checkY));

							} else {
								tileArray[checkY][checkX].setState(Tile.TileStates.Unavailable);
								eligibleForPlacement = false;
								break;
							}
						} else {
							eligibleForPlacement = false;
							break;
						}

					}

					main.window.repaint();
				}

			}else if (insideGrid) { // if outside the grid we want to set insideGrid = false, and repaint every selected tile as normal
				
				insideGrid = false;
				tileArray[oldTileY][oldTileX].mouseExited(e);
				main.window.repaint();
				
			}

		}
	}

}

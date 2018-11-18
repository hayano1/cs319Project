package Generated;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final int boardWidth;
	public final int boardHeight;
	public final int polBoardHeight = 9;
	public final int polBoardWidth = 15;
	private final int TileType;
	static private int currHeight;
	static private int currWidth;
	static int x;
	static int y;

	static public boolean whatColor;
	static Tile[][] a;

	static private MouseListener mos;
	static public MouseListener tileListener;
	static public MouseListener inventoryListener;
	
	
	static private JPanel tablePanel;
	static private JPanel inventoryPanel;

	public Board(int width, int height, int TileTypee) {
		
		boardWidth = width;
		boardHeight = height;
		TileType = TileTypee;
		whatColor = true;

		//=========================== LISTENERSSS =========================
		tileListener = new MouseListener() {

			public void mouseClicked(MouseEvent e) {

				if (Tile.state != Tile.TileStates.Clicked)
					Tile.state = Tile.TileStates.Clicked;
				else
					Tile.state = Tile.TileStates.Normal;
				//System.out.println(Tile.state);
				
				//((Tile) e.getSource()).onMouseClick(e.getPoint());
				
				((Tile) e.getSource()).repaint();
			}

			public void mouseEntered(MouseEvent e) {

				Tile.state = Tile.TileStates.Hovered;
				((Tile) e.getSource()).repaint();
				//System.out.println(Tile.state);

			}

			public void mouseExited(MouseEvent e) {

				Tile.state = Tile.TileStates.Normal;
				//System.out.println(Tile.state);

				((Tile) e.getSource()).repaint();
			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("The tile you let go is: " + ((Tile) e.getSource()).tileId );
			}

		};

		mos = new MouseListener() {

			public void mouseClicked(MouseEvent e) {

				System.out.println("Clicked the board !!");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("Entered");
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

		};
		
		inventoryListener = new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				//(arg0.getSource())
			}

			public void mouseEntered(MouseEvent arg0) {
				
			}

			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent arg0) {
				
			}

			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		};
		//=========================== LISTENERSSS =========================
		
		
		tablePanel = new JPanel();
		inventoryPanel = new Inventory();

		Dimension tableDim = new Dimension((boardWidth + 2) * Tile.TileWidth, boardHeight * Tile.TileHeight + 40);

		tablePanel.setPreferredSize(tableDim);
		tablePanel.setMaximumSize(tableDim);
		tablePanel.setSize(tableDim);
		
		Dimension inventoryDim = new Dimension((boardWidth + 1) * Tile.TileWidth, 5 * Tile.TileHeight + 40);

		inventoryPanel.setPreferredSize(inventoryDim);
		inventoryPanel.setMaximumSize(inventoryDim);
		inventoryPanel.setSize(inventoryDim);
		
		this.setLayout(new BorderLayout());
		this.addMouseListener(mos);

		//this.setSize(1000,1000);
		
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(inventoryPanel, BorderLayout.SOUTH);
		
		
		
		
		
		//AddPiecesToBoard();
		
		AddTilesToBoard();
		

	}
	
	private void AddPiecesToBoard() {
		
		ArrayList<XYCoord> cords = new ArrayList<XYCoord>();
		cords.add( new XYCoord(0,0));
		cords.add( new XYCoord(0,1));
		cords.add( new XYCoord(0,2));
		cords.add( new XYCoord(1,2));
		
		ArrayList<XYCoord> cords1 = new ArrayList<XYCoord>();
		cords1.add( new XYCoord(0,0));
		cords1.add( new XYCoord(0,1));
		cords1.add( new XYCoord(0,2));
		cords1.add( new XYCoord(0,3));
		
		final Piece a = new Piece(1,1, cords , 50,50);
		final Piece b = new Piece(1,1, cords1 , 50,50);
		
		
		KeyListener keyy = new KeyListener() {

			public void keyPressed(KeyEvent e) {
			    	
			    	System.out.println("ASDFASDFASDFasdlkfgahjsdfjhasdghjfgahjsdfasdf");
			    }
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		
		a.addKeyListener(keyy);
		b.addKeyListener(keyy);
	
		
		inventoryPanel.add(b);
		inventoryPanel.add(a);
		
	}

	private void AddTilesToBoard() {

		int id = 0;

		if (TileType == 0) {
			a = new Tile[boardHeight][boardWidth];

			for (int i = 0; i < boardHeight; i++) {
				for (int j = 0; j < boardWidth; j++) {

					currHeight = i * Tile.TileHeight;
					currWidth = j * Tile.TileWidth;

					a[i][j] = new Tile(currWidth, currHeight, id, id, TileType, true);

					a[i][j].addMouseListener(tileListener);

					tablePanel.setLocation(currWidth, currHeight);
					tablePanel.add(a[i][j]);
					id++;
				}
			}

		} else if (TileType == 1) {
			String allVal = "000100010001000|001010101010100|010101010101010|101010101010101|010101010101010|101010101010101|010101010101010|001010101010100|000100010001000";

			String all = allVal.replace("|", "");
			System.out.println(all);

			int one = 0;
			int zero = 0;

			a = new Tile[polBoardHeight][polBoardWidth];

			boolean[][] Tiles = new boolean[9][15];

			for (int i = 0; i < 135; i++) {
				if (all.charAt(i) == '0') {
					Tiles[i / 15][i % 15] = false;
					zero++;
				} else {
					Tiles[i / 15][i % 15] = true;
					one++;
				}
			}

			for (int i = 0; i < polBoardHeight; i++) {
				for (int j = 0; j < polBoardWidth; j++) {

					currHeight = i * Tile.TileHeight;
					currWidth = j * Tile.TileWidth;

					boolean as = Tiles[i][j];

					a[i][j] = new Tile(currWidth, currHeight, id, id, TileType, as/* , mos */);
					a[i][j].addMouseListener(tileListener);
					
					tablePanel.setLocation(currHeight, currWidth); // does not work properly
					tablePanel.add(a[i][j]);

					id++;
				}
			}

		}

		this.repaint();

	}

	public void paintComponent(Graphics g) {

		//System.out.println("Board Paint");
		//g.drawLine(0, 0, 500, 500);

	}

}

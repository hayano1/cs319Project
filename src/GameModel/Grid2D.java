package GameModel;

public class Grid2D {
    private int dimensionX;
    private int dimensionY;
    private int[][] cells;

    Grid2D(int rows, int cols){
        this.cells = new int[rows][cols];
        for (int outer = 0; outer < rows; outer++){
            for (int inner = 0; inner < cols; inner++){
                this.cells[outer][inner] = 0;
            }
        }
    }

    public int getCellContent(int row, int col){
        return this.cells[row][col];
    }

    public void setCellFilled(int row, int col, int pieceID){
        cells[row][col] = pieceID;
    }
    public void print()
    {
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 11; col++)
			{
				System.out.print(this.getCellContent(row, col));
			}
			System.out.println();
		
		}
    }
}

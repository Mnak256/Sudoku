//Soumyarup
import java.util.Scanner;

public class Board {

    private int board[][];

    public static void main(String[]args) {
    	System.out.println("Enter Sudoku");
        Scanner scanner = new Scanner(System.in);
        Board boardObj = new Board();
        int board[][] = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        boardObj.setBoard(board);
        boardObj.checkBoard();
        System.out.println();
        //boardObj.display();
    }

    private void setBoard(int board[][]) {
        this.board = board;
    }

    private void display() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                System.out.print(this.board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void checkBoard() {
        for (int row = 0; row < this.board.length; row++) {
            if (!checkRow(row)) {
                System.out.print("Failed for Row "+ row);
                return;
            }
        }
        for(int column = 0; column < this.board[0].length; column++)
        {
            if(!checkColumn(column))
            {
                System.out.println("Failed for Column " + column);
                return;
            }
        }
        for (int subBoxIndex = 0; subBoxIndex < this.board.length; subBoxIndex++) {
            if (!checkSubBox(subBoxIndex)) {
                System.out.println("Failed for Sub Box " + subBoxIndex);
                return;
            }
        }
        System.out.print("success");
    }

    private boolean checkRow(int row) {
        //to check a row, go through all the columns.
        int reference[] = {1, 2, 3, 4, 5 ,6, 7, 8, 9};
        //int reference[] = {1, 1, 1, 1, 1 , 1, 1, 1, 1}; //this will also work.
        for (int col = 0; col < this.board[row].length; col++) {
            int temp = board[row][col];
            
            if(reference[temp-1]==0)
            {
            	return false;
            }
            
            else
            	reference[temp - 1] = 0;
        }
        return true;
    }
    
    private boolean checkColumn(int column)
    {
    	int reference[] = {1, 2, 3, 4, 5 ,6, 7, 8, 9};
    	
    	boolean flag= true;
    	
    	for(int row = 0; row < this.board.length;row++)
    	{
    		int temp = board[row][column];
    		
    		if(reference[temp-1] == 0)
    		{
    			flag = false;
    			break;
    		}
    		
    		else
    			reference[temp-1]=0;
    	}
		return flag;
    }

    /*

    Index reference of sub boxes -

    - - - - - - - - - - 
    |     |     |      |
    |  0  |  1  |  2   |
    |_____|_____|______|
    |     |     |      |
    |  3  |  4  |  5   |
    |_____|_____|______|
    |     |     |      |
    |  6  |  7  |  8   |
    |     |     |      |
    - - - - - - - - - - 

     */

    private boolean checkSubBox(int index) { //index according to the reference above.
        int loc[] = getLocationOfSubBox(index); //loc[0] = row, loc[1] = column.
        int row = loc[0], col = loc[1];
        int reference[] = {1, 2, 3, 4, 5 ,6, 7, 8, 9};
        for (int i = 0; i < this.board.length; i++) { //board.length is same as sub box length or size.
            int temp = this.board[row][col];
            if (reference[temp - 1] == 0) {
                return false;
            } else {
                reference[temp - 1] = 0;
            }

            //updating row and col.
            col++;
            if (col >= loc[1] + 3) { // if col++ is done more than 2 times then col value will go out of this sub box, so putting it back to this sub box and incrementing the row value.
                col = loc[1];
                row++;// And because of the outer for loop, row++ will occur only 2 times.
            }
        }
        return true;
    }
    
    private int[]getLocationOfSubBox(int index) { //returns starting location of the sub box.
        int loc[] = new int[2]; //loc[0] = row, loc[1] = column.
        switch (index) {
            case 0:
                loc[0] = 0;
                loc[1] = 0;
                break;
            case 1:
                loc[0] = 0;
                loc[1] = 3;
                break;
            case 2:
                loc[0] = 0;
                loc[1] = 6;
                break;
            case 3:
                loc[0] = 3;
                loc[1] = 0;
                break;
            case 4:
                loc[0] = 3;
                loc[1] = 3;
                break;
            case 5:
                loc[0] = 3;
                loc[1] = 6;
                break;
            case 6:
                loc[0] = 6;
                loc[1] = 0;
                break;
            case 7:
                loc[0] = 6;
                loc[1] = 3;
                break;
            case 8:
                loc[0] = 6;
                loc[1] = 6;
                break;
            default:
                System.err.println("Invalid Index of Sub Box");
        }
        return loc;
    }
        
}


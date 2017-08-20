import java.util.Scanner;

public class Board {

    private int board[][];
    //private int reference[] = {1, 2, 3, 4, 5 ,6, 7, 8, 9};

    public static void main(String[]args) {
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
        boardObj.display();
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
                System.out.print("fail");
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
            reference[temp - 1] = 0;
        }//after this loop, all the elements of reference should be zero.
        for (int refIndex = 0; refIndex < reference.length; refIndex++) {
            if (reference[refIndex] != 0) {
                return false;
            }
        }
        return true;
    }
}

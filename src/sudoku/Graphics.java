import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Graphics implements ActionListener
{
	private JButton button;
	private JTextField[][] board;
	private JLabel label1;
	private JFrame frame;
	
	public Graphics()
	{
		frame = new JFrame("Sudoku");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(17, 125, 152 ));
		
		
		board = new JTextField[9][9];
		
		Font font;
		
		/*Font font = board[0][0].getFont();
		font = font.deriveFont((float)28); //deriving a new font*/
		//edtText.setFont(font);
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				board[i][j] = new JTextField();

				board[i][j].setBounds(500 + j*43,200 + i*41,42,41);     //size and position of each textboard
				
				font = board[i][j].getFont();
				board[i][j].setFont(font.deriveFont((float)20));		 //font size of each textboard
				
				board[i][j].setHorizontalAlignment(JTextField.CENTER); //text position in each board
				
				
				frame.add(board[i][j]);
			}
		}
		
		
		label1 = new JLabel("SUDOKU");
		//Font fontLabel = new Font("Courier", Font.ITALIC,25);
		Font fontLabel = new Font("Dialog", Font.BOLD,40);
		label1.setFont(fontLabel);
		label1.setBounds(600 , 25 , 200 , 150);
		
		
		button = new JButton("Finish");
		button.setBounds(600 , 600 , 200 , 50);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.addActionListener(this);
		
		frame.add(label1);
		frame.add(button);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	public int[][] getBoard() 
	{
		int[][] tempBoard = new int[9][9];
		
		for(int i=0;i< tempBoard.length ;i++)
		{
			for(int j=0;j<tempBoard.length;j++)
			{
				tempBoard[i][j] = Integer.parseInt(board[i][j].getText());
			}
		}
		
		return tempBoard;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Board obj = new Board();
		
		obj.setBoard(getBoard());
		
		if(obj.checkBoard())
			JOptionPane.showMessageDialog(frame,"Success");
		
		else
			JOptionPane.showMessageDialog(frame,"Faliure");
		
	}
}

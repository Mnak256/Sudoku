import java.awt.*;

import javax.swing.*;


public class Graphics 
{
	JButton button;
	JTextField[][] box;
	JLabel label1;
	
	public Graphics()
	{
		JFrame frame = new JFrame("Sudoku");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(17, 125, 152 ));
		
		
		box = new JTextField[9][9];
		
		Font font;
		
		/*Font font = box[0][0].getFont();
		font = font.deriveFont((float)28); //deriving a new font*/
		//edtText.setFont(font);
		
		for(int i=0;i<box.length;i++)
		{
			for(int j=0;j<box[0].length;j++)
			{
				box[i][j] = new JTextField();

				box[i][j].setBounds(500 + j*43,200 + i*41,42,41);     //size and position of each textbox
				
				font = box[i][j].getFont();
				box[i][j].setFont(font.deriveFont((float)20));		 //font size of each textbox
				
				box[i][j].setHorizontalAlignment(JTextField.CENTER); //text position in each box
				
				
				frame.add(box[i][j]);
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
		
		frame.add(label1);
		frame.add(button);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
}

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame("Tic-Tac-Toe Game");
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JPanel title_panel = new JPanel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("MV Boli",Font.BOLD,70));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.gray);
		
		for(int index = 0 ; index < 9 ; index++ ) {
			buttons[index] = new JButton();
			button_panel.add(buttons[index]);
			buttons[index].setFont(new Font("Consolas",Font.PLAIN,100));
			buttons[index].setFocusable(false);
			buttons[index].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int index = 0;index<9;index++) {
			
			if(e.getSource()==buttons[index]) {
				if(player1_turn) {
					if(buttons[index].getText()=="") {
						buttons[index].setForeground(Color.red);
						buttons[index].setText("X");
						player1_turn = false;
						textfield.setText("0 Turn");
						check();
					}
				}
			else {
					if(buttons[index].getText()=="") {
						buttons[index].setForeground(Color.blue);
						buttons[index].setText("0");
						player1_turn = true;
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn()  {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textfield.setText("X Turn");
		}
		else {
			player1_turn = false;
			textfield.setText("0 Turn");
		}
	}
	
	public void check() {
		//check X win condition
		if( 
				(buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
				) {
			xWin(0,1,2);
		}
		if( 
				(buttons[3].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")
				) {
			xWin(3,4,5);
		}
		if( 
				(buttons[6].getText()=="X")&&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWin(6,7,8);
		}
		if( 
				(buttons[0].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWin(0,4,8);
		}
		if( 
				(buttons[2].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xWin(2,4,6);
		}
		if( 
				(buttons[0].getText()=="X")&&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xWin(0,3,6);
		}
		if( 
				(buttons[1].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")
				) {
			xWin(1,4,7);
		}
		if( 
				(buttons[2].getText()=="X")&&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWin(2,5,8);
		}
		//check 0 win condition
		if( 
				(buttons[0].getText()=="0")&&
				(buttons[1].getText()=="0")&&
				(buttons[2].getText()=="0")
				) {
			oWin(0,1,2);
		}
		if( 
				(buttons[3].getText()=="0")&&
				(buttons[4].getText()=="0")&&
				(buttons[5].getText()=="0")
				) {
			oWin(3,4,5);
		}
		if( 
				(buttons[6].getText()=="0")&&
				(buttons[7].getText()=="0")&&
				(buttons[8].getText()=="0")
				) {
			oWin(6,7,8);
		}
		if( 
				(buttons[0].getText()=="0")&&
				(buttons[4].getText()=="0")&&
				(buttons[8].getText()=="0")
				) {
			oWin(0,4,8);
		}
		if( 
				(buttons[2].getText()=="0")&&
				(buttons[4].getText()=="0")&&
				(buttons[6].getText()=="0")
				) {
			oWin(2,4,6);
		}
		if( 
				(buttons[0].getText()=="0")&&
				(buttons[3].getText()=="0")&&
				(buttons[6].getText()=="0")
				) {
			oWin(0,3,6);
		}
		if( 
				(buttons[1].getText()=="0")&&
				(buttons[4].getText()=="0")&&
				(buttons[7].getText()=="0")
				) {
			oWin(1,4,7);
		}
		if( 
				(buttons[2].getText()=="0")&&
				(buttons[5].getText()=="0")&&
				(buttons[8].getText()=="0")
				) {
			oWin(2,5,8);
		}
		
	}
	
	public void xWin(int a,int b,int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int index = 0 ;index < 9 ;index++) {
			buttons[index].setEnabled(false);
		}
		
		textfield.setText("Booyah X Wins");
		
	}
	
	public void oWin(int a,int b,int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int index = 0 ;index < 9 ;index++) {
			buttons[index].setEnabled(false);
		}
		
		textfield.setText("Booyah 0 Wins");
		
	}

}

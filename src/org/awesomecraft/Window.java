package org.awesomecraft;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {
	
	JTextField[][] fields = new JTextField[6][7];
	JButton bts[] = new JButton[7];
	public boolean tx = true;
	
	public Window()
	{
      this.setLayout(new GridLayout(7,6));
	  this.setSize(900, 900);
	  boolean def = true;
	  for(int i = 0; i <= 5; i++)
	  {
       for(int j = 0; j <= 6; j++) 
       {
		fields[i][j] = new JTextField();
		fields[i][j].setText(" ");
		fields[i][j].setEditable(false);
		if(def)
		{	
		System.out.print("Defining fields ");
		def = false;
		}
		System.out.print("[" +Integer.toString(i) + "][" + Integer.toString(j) + "] ");
		fields[i][j].setHorizontalAlignment(JTextField.CENTER);
		this.add(fields[i][j]);
	   }
	  }
	  System.out.println();
	  for(int i = 0; i <= 6; i++)
	  {
		  bts[i] = new JButton(Integer.toString(i + 1));
		  bts[i].addActionListener(this);
		  this.add(bts[i]);
	  }
	  
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

     JButton p = (JButton) e.getSource();
     for(int i = 5; i >= 0; i--)
     {
     if(tx)
     {
    	 if(fields[i][Integer.parseInt(p.getText()) - 1].getText().equals(" "))
    	 {
       fields[i][Integer.parseInt(p.getText()) - 1].setText("X");
       tx = !tx;
       break;
    	 }
     } 
     else if(!tx)
     {
    	 if(fields[i][Integer.parseInt(p.getText()) - 1].getText().equals(" "))
    	 {
       fields[i][Integer.parseInt(p.getText()) - 1].setText("O"); 
       tx = !tx; 
       break;
    	 }
     }
     
	}
     
     for(int i = 0; i <= 4; i++)
	  {
      
    	 for(int j = 0; j <= 6; j++) 
       {
    	 if(fields[i][j].getText().equals("X") && fields[i][j + 1].getText().equals("X") && fields[i][j + 2].getText().equals("X") && fields[i][j + 3].getText().equals("X"))
    	 {
    		 JOptionPane.showMessageDialog(null, "X Wins!");
    	 }
    	 if(fields[i][j].getText().equals("O") && fields[i][j + 1].getText().equals("O") && fields[i][j + 2].getText().equals("O") && fields[i][j + 3].getText().equals("O"))
    	 {
    		 JOptionPane.showMessageDialog(null, "O Wins!");
    	 }
    	 if(fields[i][j].getText().equals("X") && fields[i - 1][j].getText().equals("X") && fields[i - 2][j].getText().equals("X") && fields[i - 3][j].getText().equals("X"))
    	 {
    		 JOptionPane.showMessageDialog(null, "X Wins!");
    	 }
    	 if(fields[i][j].getText().equals("O") && fields[i - 1][j].getText().equals("O") && fields[i - 2][j].getText().equals("O") && fields[i - 3][j].getText().equals("O"))
    	 {
    		 JOptionPane.showMessageDialog(null, "O Wins!");
    	 }
    	 
       }
	  
	  }
     
	}
	public static void main(String args[])
	{
		new Window();
	}

}
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
     if(tx && fields[5][Integer.parseInt(p.getText()) - 1].equals(null))
     {
     fields[5][Integer.parseInt(p.getText()) - 1].setText("X");
     } else if(!tx && fields[5][Integer.parseInt(p.getText()) - 1].equals(null))
     {
     fields[5][Integer.parseInt(p.getText()) - 1].setText("O"); 
     }
    
     tx = !tx;
		
	}
	public static void main(String args[])
	{
		new Window();
	}

}

package ch01.apps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Banker extends JFrame implements ActionListener {

	private JPanel exceptiontext;
	private JLabel bankException;
	private BankAccount bankofFong;
	private JTextField accountNum;
	private JTextField accountAmount;
	
	public Banker() 
	{
		super("Bank of Fong"); 
		setLookAndFeel();
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		JPanel buttons = new JPanel();
		JPanel labeltext = new JPanel();
		exceptiontext = new JPanel();
		
		labeltext.setLayout(flo);
		buttons.setLayout(flo);
		exceptiontext.setLayout(flo);
		
		JLabel accountLabel = new JLabel("Bank Account #", JLabel.RIGHT);
		accountNum = new JTextField("",3);
		JLabel amountLabel = new JLabel("Amount", JLabel.RIGHT);
		accountAmount = new JTextField("",5);
		labeltext.add(accountLabel);
		labeltext.add(accountNum);
		labeltext.add(amountLabel);
		labeltext.add(accountAmount);
		add(labeltext);

		JButton deposit = new JButton("Deposit");
		JButton withdrawl = new JButton("Withdrawl");
		JButton balance = new JButton("Balance");
		buttons.add(deposit);
		buttons.add(withdrawl);
		buttons.add(balance);		
		add(buttons);		

		bankException = new JLabel("", JLabel.RIGHT);
		exceptiontext.add(bankException);
		add(exceptiontext);
		
		deposit.addActionListener(this);
		withdrawl.addActionListener(this);
		balance.addActionListener(this);
		
		setVisible(true);
		
		bankofFong = new BankAccount(10);
	}
	
	
	public void actionPerformed(ActionEvent event) 
	{ 
		String command = event.getActionCommand(); 
		try
		{
			if (command.equals("Deposit")) 
			{ 				
				bankofFong.deposit(Integer.parseInt(accountNum.getText()), Integer.parseInt(accountAmount.getText()));
				bankException.setText("Successful deposit");
			}         
			if (command.equals("Withdrawl")) 
			{ 
				bankofFong.withdrawl(Integer.parseInt(accountNum.getText()), Integer.parseInt(accountAmount.getText()));
				bankException.setText("Successful withdrawl");
			} 
			if (command.equals("Balance")) 
			{ 
				bankException.setText("Balance " +
					bankofFong.toString(Integer.parseInt(accountNum.getText())) );
			} 			
		}
		catch (BankAccountException e)
		{
				bankException.setText(e.getMessage());
		}
		catch (Exception e)
		{
			if (accountNum.getText().equals(""))
				bankException.setText("Missing account number");
			else if (accountAmount.getText().equals(""))
				bankException.setText("Missing amount value");			
			else
				bankException.setText(e.getMessage());
		}
	}
	
	private void setLookAndFeel() 
	{         
		try 
		{	             
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			// ignore error         
		}
	}
	
	public static void main(String[] args) 
	{
		Banker bankOfFong = new Banker();
	}

}

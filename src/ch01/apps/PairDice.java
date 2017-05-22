package ch01.apps;

import java.util.*;

public class PairDice {

	private int dice1, dice2;
	
	public void PairDice()
	{
		dice1 = 0;
		dice2 = 0;
	}
	
	public void roll()
	{
		dice1 = (int) Math.floor(Math.random() * 6 + 1);
		dice2 = (int) Math.floor(Math.random() * 6 + 1);
	}
	
	public int value()
	{
		return (dice1+dice2);
	}
	
	@Override
	public String toString()
	{
		String myString = new String();
		
		myString = dice1 + ":" +
				   dice2 + "=" + 
				   this.value();
		
		return myString;
	}
}

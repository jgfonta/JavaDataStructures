package ch01.apps;

import java.util.*;

public class CrapsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairDice myDice = new PairDice();
		int firstRoll = 0, lastRoll = 0;
		int wins = 0, losses = 0;
		int playerWon = 0, houseWon = 0;
		
		System.out.println("Welcome to the game");
		
		for (int j=1; j<101; j++)
		{
			for (int i=1; i<100001; i++)
			{
				myDice.roll();
				firstRoll = myDice.value();
				//System.out.println("Roll #" + i + " " + myDice.toString());
				if (firstRoll == 7 | 
				    firstRoll == 11)
				{
					wins++;
				}
				else if (firstRoll == 2 | 
					firstRoll == 3 |
					firstRoll == 12)
				{
					losses++;
				}
				else
				{
					boolean moreRolls = true;
					do
					{
						myDice.roll();
						lastRoll = myDice.value();
						if (lastRoll == firstRoll)
						{
							wins++;
							moreRolls = false;
						}
						else if (lastRoll == 7)
						{
							losses++;
							moreRolls = false;
						}
					}
					while (moreRolls); 
				}
			}
			if (wins > losses)
				playerWon++;
			else
				houseWon++;
			//System.out.println("Won " + wins);
			//System.out.println("Lost " + losses);
		}
		System.out.println("Player won majority of 100,000 games " + playerWon);
		System.out.println("Player lost majority of 100,000 games " + houseWon);
	}

}

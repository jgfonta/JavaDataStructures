package ch06.hw;

import java.util.Random;
import java.util.Scanner;

import ch06.lists.ABList;
import support.cards.Card;
import support.cards.CardDeck;

public class BridgeGame {

	//*********************************
	//*   Problem # 26
	//*********************************
	//In a “hand” of bridge a deck of cards is dealt to four players,
	//each receiving 13 cards. The players then proceed to bid on who will
	//get to play the hand—player’s bid partially based on how highly he
	//or she evaluates their hand and partially based on what their opponents
	//and their partner bid. There are many different ways to evaluate
	//a bridge hand, including various point counting systems. A simple
	//point counting system is as follows: count each ace as 4 points,
	//each king as 3 points, each queen as 2 points, and each jack as 1
	//point. Then add 1 additional point for each suit in which you have
	//five cards, 2 points for a six-card suit, 3 points for a seven-card suit,
	//and so on. For example, if your hand consists of the ace, queen, five,
	//four, and three of clubs, the jack of diamonds, and the ace, king,
	//queen, jack, ten, nine, and two of spades, your hand’s point value
	//would be 21 points.

	//1. Create an application BridgeHand that allows a user to arrange
	//a hand of 13 cards, much like the CardHand application.
	//The program then prompts the user to enter the point
	//value of the hand, using the counting approach described. Finally,
	//the program reads in the user’s response and provides
	//appropriate feedback (“Correct” or “Incorrect, the actual
	//point value is . . .”).

	//2. Create an application HandsCounts that generates 1,000,000
	//bridge hands and outputs the smallest, largest, and average
	//point value, using the counting approach described above.

	//3. Expand HandsCounts so that when finished it also prints out
	//one hand with the smallest point value and one hand with the
	//highest point value.
	
	final static int HANDSIZE = 52;
	final static int NUMGAMES = 1000000;
	final static int AUTOSTAKE = 1000000;
	private BridgePlayer[] player; 
	CardDeck myDeck;

	public BridgeGame ()
	{
		myDeck = new CardDeck();
		myDeck.shuffle();	
		player = new BridgePlayer[4];
	}
	

	public void createPlayer(int playerNum, Scanner inputStream, boolean autoCreate)
	{
		String playerName;
		int playerStake;

		if (autoCreate)
		{				
			player[playerNum - 1] = new BridgePlayer(AUTOSTAKE, ("Player #" + playerNum));
		}
		else
		{
			System.out.print("What is player #" + playerNum + "'s name?");
			playerName = (inputStream.next()).toLowerCase();
			if (playerName.length() > 1)
				playerName = (playerName.substring(0,1).toUpperCase()) + playerName.substring(1);	
			do
			{
				System.out.print("\nHow many chips do you want (in whole dollars)?");
				playerStake = inputStream.nextInt();
			}
			while (playerStake < 0);
			player[playerNum - 1] = new BridgePlayer(playerStake, playerName);
		}
		
	}
	
	public void dealPlayerHand(int playerNum, boolean autoPlay, Scanner inputStream)
	{	
		int slot;
		Card card;
		ABList<Card> currHand; 

		//Deal hand
		currHand = new ABList<Card>(BridgePlayer.HANDSIZE);
	    for (int j = 0; j < BridgePlayer.HANDSIZE; j++)
	    {
	      slot = j;
		  card = myDeck.nextCard();
	      if (!autoPlay)
	      {
	    	  System.out.println("\nYour hand so far:");
	          slot = 0;
	          for (Card c: currHand)
		      {
		        System.out.println(slot + "\t  " + c);
		        slot++;
		      }
		      System.out.println(slot);

		      System.out.print("Slot between 0 and " + j + " to put " + card + " > ");
		      slot = inputStream.nextInt();
		      if (slot > currHand.size())
		      {
		    	  System.out.println("Too big, just used last slot instead");
		    	  slot = currHand.size();
		      }
	      }
	      currHand.add(slot, card);
	    }	
	    
		player[playerNum-1].setHand(currHand);
		
		if (autoPlay)
		{
			player[playerNum-1].arangeHand();
		}
		else 
		{
			System.out.println("Here is your sorted hand:");
			for (Card c: currHand)
			      System.out.println(c);
		}
	}
	
	public void determineWinner(boolean autoPlay)
	{
		int highHandTotal = 0, highHandPlayer = -1, totalPot = 0;
		
		for (int i = 0; i<4; i++)
		{
			if (autoPlay)
				player[i].placeBet(10);
			if (player[i].handValue() > highHandTotal)
			{
				highHandTotal = player[i].handValue();
				highHandPlayer = i;
			}
		}
		
		for (int i = 0; i<4; i++)
		{	
			player[i].releaseHand();
			if (i != highHandPlayer)
			{
				totalPot += player[i].getBet();
				player[i].lost();
				if (!autoPlay)
					System.out.println("Sorry " + player[i].getName() + 
							" you lost.  You have $" + player[i].getChips());				
			}
		}
		player[highHandPlayer].placeBet(totalPot);
		player[highHandPlayer].won();
		if (!autoPlay)
			System.out.println("Congrats " + player[highHandPlayer].getName() + 
					" you won.  You have $" + player[highHandPlayer].getChips());
		

		//Last thing to do is shuffle
		myDeck.shuffle();
	}
	
	
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		String userInput;
		int playerHandValue;
 		boolean autoPlay = false;
 		

		System.out.println("Welcome to the game of Bridge");

		System.out.print("Do you want automatically build the players and play the game (yes or no)?");
		userInput = (myInput.next()).toLowerCase();
		if ((userInput.substring(0, 1)).equals("y"))
			autoPlay = true;

		BridgeGame myGame = new BridgeGame();
		for (int i=1;i<=4;i++)
		{	
			myGame.createPlayer(i, myInput, autoPlay);
		}
		
		//Play a game
		for (int i=1;i<=NUMGAMES;i++)
		{
			for (int j=1;j<=4;j++)
			{
				myGame.dealPlayerHand( ( ( (j+i) %4) +1) ,autoPlay,myInput);
				if (!autoPlay)
				{
					System.out.println("How many points do you think your hand is worth?");
	
					playerHandValue = myInput.nextInt();
					if (playerHandValue == myGame.player[((j+i)%4)].handValue())
					{
					   System.out.println("Correct! Your hand is worth " + playerHandValue);
					}
					else
					{
					   System.out.println("Wrong!  It is worth " + myGame.player[((j+i)%4)].handValue());
					}
				}
			}
			myGame.determineWinner(autoPlay);
		}

		//Games done, print summary
		for (int i=0;i<4;i++)
		{
			System.out.println(myGame.player[i].getName() + 
					" has $" + myGame.player[i].getChips() +
					". Won " + myGame.player[i].totWins() + " games." + 
					" Lost " + myGame.player[i].totLost() +  " games.");
		}
	

	

	}

}

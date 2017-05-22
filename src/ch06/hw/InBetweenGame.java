package ch06.hw;
import java.util.*;

import ch06.lists.ABList;
import support.cards.*;

//*********************************
//*   Problem # 23
//*********************************
//In-Between is a well-known card game. Many variations exist—
//we define it as follows. One deck of cards is used. A game consists
//of one or more “hands.” A player starts with a certain number
//of chips called the “stake” (say 100) and must risk one or more
//chips on each hand, before seeing any cards. As long as the player
//still has chips and there are three or more cards left in the deck
//(enough to play a hand), the game continues. For each hand the
//player must risk between one and their total number of chips. Two
//cards are dealt “face up.” Then a third card is dealt. If the third card
//is “in-between” the first two cards, based on the ranks of the cards,
//the player’s chips are increased by the amount risked. Otherwise
//they are decreased by that amount.

//1. Implement the game. The application user is the “player.”

//2. If the first two cards dealt are the same rank, that hand is over
//and the player is awarded two chips.

//3. Allow the player at his or her discretion to double the risk after
//seeing the first two cards.

public class InBetweenGame {
	
	final static String rules = "The game consists of one or more hands of 3 cards.\n" 
			+ " A player sets their initial stake, usually 100 and risks\n" 
			+ " risks one or more chips on each hand, before seeing any\n"
			+ " cards. As long as the player still has chips and there\n"
			+ " are three or more cards left in the deck the game continues.\n\n"
			+ "For each hand the player must risk between one and their\n"
			+ " total number of chips.  Next two cards are dealt face up.\n"
			+ " If the third card is “in-between” the first two cards then\n"
			+ " the player won the bet otherwise they lost their bet.";
	final static int HANDSIZE = 3;
	public static void main(String[] args) 
	{
		Scanner myInput;
		String userInput;
		String playerName;
		int playerStake;

		
		myInput = new Scanner(System.in);

		//**************************************
		//***  Start-up section                
		//**************************************
		System.out.println("Welcome to the In-Between game");
		
		System.out.print("Do you know the rules (yes or no)?");
		userInput = (myInput.next()).toLowerCase();
		
		if ((userInput.substring(0, 1)).equals("n"))
			System.out.println(rules);

		System.out.print("\nWhat is your name (IRS wants to know if you win)?");
		userInput = (myInput.next()).toLowerCase();
		playerName = (userInput.substring(0,1).toUpperCase()) + userInput.substring(1);
		

		System.out.print("\nHow many chips do you want (in whole dollars)?");
		playerStake = myInput.nextInt();
		
		if (playerStake > 100)
		{
			System.out.print("\nGlad to meet you " + playerName);
			System.out.println(".  The game will be starting now.");
		}
		else if (playerStake == 100)
		{
			System.out.println("\nHave a set and let us get started on the game");
		}
		else
		{
			System.out.println("\nRemain standing... this won't take long");
		}
		
		//**************************************
		//***  Initialize game info             
		//**************************************
		IBPlayer player;
		player = new IBPlayer(playerStake, playerName);
		CardDeck myDeck = new CardDeck();
		Card currCard;
		ABList myHand = new ABList<Card>(HANDSIZE);  //Create an array of 3 entries to save space vs 100
		int totHands = 0;
		boolean fullHand = false;
		int compare10,compare20,compare21, currBet = 0;
		boolean autoBets = false;
		Random myRando = new Random();

		System.out.print("Do you want automatic bets of at most 1/3 of your pot (yes or no)?");
		userInput = (myInput.next()).toLowerCase();
		
		if ((userInput.substring(0, 1)).equals("y"))
			autoBets = true;


		myDeck.shuffle();
		//**************************************
		//***  Mainline section              
		//**************************************
		//Keep going while there are more cards

		while (player.getChips() > 1 && myDeck.hasNextCard())
		{
			fullHand = false;
			for (int i=0; i<3;i++)
			{
				if (myDeck.hasNextCard())
				{
				   myHand.add(i,myDeck.nextCard());
				   if (i==2)
					   fullHand = true;
				}
			}
			
			//If there were enough cards in the deck to play a game then play a round
			if (fullHand)
			{
				if (autoBets)
				{
					currBet = (myRando.nextInt(player.getChips() - 1) % ((player.getChips() / 3) + 1) ) + 1;					
				}
				else
				{
					System.out.print("\nPlace your bet (in whole dollars)?");
					currBet = myInput.nextInt();
				}
				
				player.placeBet(currBet);
				
				System.out.println(player.getName() + " bet $" + player.getBet());
				
				compare10 = ((Card)myHand.get(1)).compareTo((Card)myHand.get(0));
				compare21 = ((Card)myHand.get(2)).compareTo((Card)myHand.get(1));
				compare20 = ((Card)myHand.get(2)).compareTo((Card)myHand.get(0));
				if ( compare10  > 0)
				{
					//First Card is less than Second Card
					if (  compare20 > 0 &&
						  compare21 < 0)
					{
						player.won();
						System.out.print(myHand.get(0) + " < ");
						System.out.print(myHand.get(2) + " < ");				
						System.out.println(myHand.get(1));
					}
					else 
					{
						System.out.print(myHand.get(2) + " is not > ");
						System.out.print(myHand.get(0) + " & < ");				
						System.out.println(myHand.get(1));						
						player.lost();
					}
				}
				else
				{
					//Second Card is less than First Card
					if ( compare20 < 0 &&
						 compare21 > 0)
					{
						System.out.print(myHand.get(1) + " < ");
						System.out.print(myHand.get(2) + " < ");				
						System.out.println(myHand.get(0));
						player.won();
					}
					else 
					{
						player.lost();
						System.out.print(myHand.get(2) + " is not > ");
						System.out.print(myHand.get(1) + " & < ");				
						System.out.println(myHand.get(0));						
						player.lost();
					}

				}
			}
			if (!myDeck.hasNextCard())
			{
				System.out.print("Do you want to play again (yes or no)?");
				userInput = (myInput.next()).toLowerCase();
				
				if ((userInput.substring(0, 1)).equals("y"))
					myDeck.shuffle();			
			}
		}
		System.out.println("Thank you for playing " + player.getName() + " you are left with $" + player.getChips());
		if (player.getChips() < playerStake )
			System.out.println("Thanks for helping pay for my kids college");
	}
	
	
	

}

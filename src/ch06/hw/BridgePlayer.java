package ch06.hw;

import ch06.lists.ABList;
import support.cards.Card;
import support.cards.Card.Rank;
import support.cards.Card.Suit;

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

public class BridgePlayer {
	
	private int chips, bet, wins, losses;
	private String name;
	final static private int DEFAULT_CHIPS = 100;
	final static public int HANDSIZE = 13;
	ABList<Card> myHand; 
	boolean nameSet;
	boolean stakeSet;

	
	public BridgePlayer(int stake, String playerName)
	{
		chips = stake;
		bet = 0;
		wins = 0;
		losses = 0;
		name = playerName;
		nameSet = true;
		stakeSet = true;
		ABList myHand = new ABList<Card>(HANDSIZE);  //Create an array of 3 entries to save space vs 100
	}
	
	
	public BridgePlayer()
	{
		chips = DEFAULT_CHIPS;
		bet = 0;
		name = "TBD";
		nameSet = false;
		stakeSet = false;
		ABList myHand = new ABList<Card>(HANDSIZE);  //Create an array of 3 entries to save space vs 100

	}
	
	public boolean setName(String playerName)
	{
		if (nameSet)
			return false;
		name = playerName;
		nameSet = true;
		return nameSet;
	}
	
	public boolean setChips(int stake)
	{
		if (stakeSet)
			return false;
		chips = stake;
		stakeSet = true;
		return stakeSet;
	}
	
	public boolean placeBet(int myBet)
	{
		if (myBet > chips)
			return false;
		bet = myBet;
		return true;
	}


	public int getBet()
	{
		return bet;
	}
	
	public String getName()
	{
		return name;
	}
	public int getChips()
	{
		return chips;
	}
	
	public int totWins()
	{
		return wins;
	}
	
	public int totLost()
	{
		return losses;
	}
	public void won()
	{
		chips += bet;
		bet = 0;
		wins++;
	}
	
	public void lost()
	{
		chips -= bet;
		bet = 0;
		losses++;
	}
	
	public boolean releaseHand()
	{
		if (myHand != null && myHand.size() != 0)
		{
			myHand = null;
			return true;
		}
		return false;		
	}
	
	public boolean setHand(ABList hand)
	{
		if (myHand == null)
		{
			myHand = hand;
			return true;
		}
		return false;
	}
	
	//A simple
	//point counting system is as follows: count each ace as 4 points,
	//each king as 3 points, each queen as 2 points, and each jack as 1
	//point. Then add 1 additional point for each suit in which you have
	//five cards, 2 points for a six-card suit, 3 points for a seven-card suit,
	//and so on. 
	public int handValue()
	{
		int totHand = 0;
		int[] totSuit = {0,0,0,0};
	    for (Card c: myHand)
	    {
	    	switch ( c.getRank() )
	    	{
	    	case Ace:
	    		  totHand += 4;
	    		  break;
	    	case King:
	    		  totHand += 3;
	    		  break;
	    	case Queen:
	    		  totHand += 2;
	    		  break;
	    	case Jack:
	    		  totHand += 1;
	    		  break;
	    	default:
	    		  break;
	    	}
  		    totSuit[(c.getSuit()).ordinal()]++;  	        
	    }
	    for (int suitCount: totSuit)
	    {
	    	if (suitCount > 4)
	    		totHand += suitCount - 4;
	    }
		return totHand;
	}
	
	public void arangeHand()
	{
	  int slot, autoSlot, loopCardRank, lowestRank, currRank;
	  Card currCard, loopCard;
	  boolean foundSuit;
	  
	  for (int j = 0; j < HANDSIZE; j++)
	  {
		  currCard = myHand.get(j);
	  	  autoSlot = j;
	  	  foundSuit = false;
	  	  currRank = (currCard.getRank()).ordinal();
	  	  lowestRank = currRank;
	  	  for (int i = 0; i < HANDSIZE; i++) //Card c: myHand)
	  	  {
	  		  loopCard = myHand.get(i);
	  		  //If card is the same suit then find the lowest
	  		  //  valued card in the hand
	  		  if (currCard.getSuit() == loopCard.getSuit())
	  		  {  
	  			  if (i < j)
	  			     foundSuit = true;
	  			  loopCardRank = (loopCard.getRank()).ordinal();
	  			      
	  			  if (currRank < loopCardRank    //Current card less than this one
	  					  && foundSuit           //In the sorted suit section
	  					  && autoSlot > i)       //Lowest Found greater than this one
	  			  {
	  				  autoSlot = i;
	  			  }
	  			  else if (lowestRank > loopCardRank && !foundSuit)
	  			  {
	  				  lowestRank = loopCardRank;
	  				  autoSlot = i;
	  			  }	  
	  		  }
	  		  else if (foundSuit)
	  		  {
	  			  //Found a different suit
	  			  //  Our card should replace this card
	  			  //  unless our card was already in 
	  			  //  the correct spot
	  			  if (autoSlot == j && (i-1) != j)
	  			     autoSlot = i;
	  			  i = HANDSIZE;  //All done
	  		  }
	  	  }
	  	  if (autoSlot != j)
	  	  {
	  		  //If swap will occur past sorted section then shift 
	  		  if (autoSlot < j)
	  		  {
		  		  for (int i = j; i>autoSlot;i--)
		  			  myHand.set(i, myHand.get(i-1));
	  		  }
	  		  //Just swap
	  		  else
	  		  {
	  			  myHand.set(j, myHand.get(autoSlot));	  			  
	  		  }
		  	  myHand.set(autoSlot, currCard);
	  	  }
		}
	}
	
	
}

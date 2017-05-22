package ch06.hw;

import java.io.*;
import java.util.*;
import ch06.lists.*;
import support.cards.*;
import support.cards.Card.Rank;
import support.cards.Card.Suit;

//*********************************
//*   Problem #33
//*********************************
//These applications should create random five card poker
//hands using the CardDeck class. You may find that sorting the
//hand in various ways aids in the determination of the hand rank.
//
//1. PokerValue should generate a single five-card poker hand
//and output the best rank associated with the hand—is it a
//“three of a kind” or a “straight flush,” and so forth? Hand
//ranks are listed from best to worst on page 370.
//
public class PokerValue {

	final static int ROYALFLUSH = 10;
	final static int STRAIGHTFLUSH = 9;
	final static int FOUROFAKIND = 8;
	final static int FULLHOUSE = 7;
	final static int FLUSH = 6;
	final static int STRAIGHT = 5;
	final static int THREEOFAKIND = 4;
	final static int TWOPAIR = 3;
	final static int ONEPAIR = 2;
	final static int HIGHESTCARD = 1;
	final static int MAXHANDS = 52 / 5;
	
	private int highCard, highCard2;
	private boolean pairCards;  //When true HighCard2 has a value
	private CardDeck myDeck;
	public int[] handType;
	private int handsLeft;
	
	final static String myFile = "c:\\pokervalue.txt";
	private PrintStream myFileOutput;
	
	final static public int HANDSIZE = 5;
	ABList<Card> myHand; 

	public PokerValue ()
	{
		highCard = -1;
		highCard2 = -1;
		pairCards = false;
		myHand = new ABList<Card>(HANDSIZE);  
		myDeck = new CardDeck();
		myDeck.shuffle();	
		handType = new int[ROYALFLUSH+1];
		handsLeft = MAXHANDS;
		Arrays.fill(handType,0);
		try
		{
			myFileOutput = new PrintStream(myFile);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		//This routine will be used to test this class
		//It is intended to be used temporarily during development or unit testing
		PokerValue myPoker = new PokerValue();
		
		for (int i = 0; i < 100000; i++)
		{
			if ((i % 10000) == 0)
				System.out.println("Completed " + i + " hands");
			myPoker.dealPlayerHand();
		}
		
		System.out.println("\n\n");
		System.out.println("Royal Flush \t" + myPoker.handType[ROYALFLUSH]);
		System.out.println("Straight Flush \t" + myPoker.handType[STRAIGHTFLUSH]);
		System.out.println("Four of a kind \t" + myPoker.handType[FOUROFAKIND]);
		System.out.println("Full house \t" + myPoker.handType[FULLHOUSE]);
		System.out.println("Flush \t\t" + myPoker.handType[FLUSH]);
		System.out.println("Straight \t" +	myPoker.handType[STRAIGHT]);
		System.out.println("Three of a kind " + myPoker.handType[THREEOFAKIND]);			
		System.out.println("Two pair \t" + myPoker.handType[TWOPAIR]);
		System.out.println("One pair \t" + myPoker.handType[ONEPAIR]);
		System.out.println("Highest card \t" + myPoker.handType[HIGHESTCARD]);

		
		myPoker.myFileOutput.println("Royal Flush \t" + myPoker.handType[ROYALFLUSH]);
		myPoker.myFileOutput.println("Straight Flush \t" + myPoker.handType[STRAIGHTFLUSH]);
		myPoker.myFileOutput.println("Four of a kind \t" + myPoker.handType[FOUROFAKIND]);
		myPoker.myFileOutput.println("Full house \t" + myPoker.handType[FULLHOUSE]);
		myPoker.myFileOutput.println("Flush \t\t" + myPoker.handType[FLUSH]);
		myPoker.myFileOutput.println("Straight \t" +	myPoker.handType[STRAIGHT]);
		myPoker.myFileOutput.println("Three of a kind " + myPoker.handType[THREEOFAKIND]);			
		myPoker.myFileOutput.println("Two pair \t" + myPoker.handType[TWOPAIR]);
		myPoker.myFileOutput.println("One pair \t" + myPoker.handType[ONEPAIR]);
		myPoker.myFileOutput.println("Highest card \t" + myPoker.handType[HIGHESTCARD]);
		
	}
	
	
	//10 Royal Flush All cards of the same suit. Ranks from 10 through Ace.
	//9  Straight Flush All cards of the same suit. Rank in sequence.
	//8  Four of a Kind Four cards with the same rank.
	//7  Full House Three cards of one rank, and two cards of a second rank.
	//6  Flush All cards of the same suit.
	//5  Straight All cards with ranks in sequence (e.g., 4-5-6-7-8). 
	//   Note that Ace can be used low or high.
	//4  Three of a Kind Three cards with the same rank.
	//3  Two Pair Two sets of cards of the same rank (e.g., 8-8-3-3-9).
	//2  One Pair Two cards of the same rank.
	//1  High Card If we have none of the above, the highest-ranking card in our hand is the “high card.”
	
	public int handValue2()
	{
		SortedABList<Card> tempHand = new SortedABList<Card>();
		Rank myRank = null;
		Suit mySuit = null;
		
		//At most there can be 
		// 2 pairs
		Rank[] pairs = {null,null};
		boolean onePair = false;
		boolean twoPair = false;
		boolean fullHouse = false;
		// 1 three kind
		Rank threeKind = null;
		// 1 four kind
		Rank fourKind = null;
		// 1 straight (sequential)
		boolean straight = true;
		Rank straightRank = null;
		// 1 flush  (same suit)
		boolean flush = true;
		// 1 royal flush
		boolean royalFlush = true;
		// 1 highest single card
		Card highestCard = myHand.get(0);
		// Current suit
		Suit flushSuit = null;
		int pairIndex = -1;
		

		//Loop thru all the cards		
		
		for (Card c: myHand)
		{
			myRank = c.getRank();
			mySuit = c.getSuit();
			if (c.compareTo(highestCard) > 0)
				highestCard = c;
			//Check for pairs, full house, 3 of a kind and 4 of a kind
			if (tempHand.contains(c))
			{
				//More than a pair of matching ranks found making 3 or 4 
				if (onePair || (threeKind != null && threeKind == myRank))
				{
					if (threeKind == myRank)
					{
						fourKind = myRank;
						threeKind = null;
					}
					else
				    //onePair && threeKind == null
					{
						pairIndex = -1;
						if (pairs[0] == myRank)
							pairIndex = 0;
						else if (pairs[1] == myRank)
							pairIndex = 1;
						if (pairIndex != -1)
						{
							threeKind = myRank;							
							pairs[pairIndex] = null;
							if ((pairIndex == 1 && pairs[0] != null) || 
								(pairIndex == 0 && pairs[1] != null))
							{
								fullHouse = true;
								onePair = false;
								twoPair = false;
							}
							else
							{
								onePair = false;
								twoPair = false;
							}
						}
						else
						{
							twoPair = true;
							if (pairs[0] == null)
								pairs[0] = myRank;
							else if (pairs[1] == null)
								pairs[1] = myRank;
						}
					}
				}
				//First pair found
				else
				{
					onePair = true;
					if (threeKind != null)
					{
						fullHouse = true;
					}
					if (pairs[0] == null)
						pairs[0] = myRank;
					else if (pairs[1] == null)
						pairs[1] = myRank;
				}
			}
			//Check for flush
			if (flushSuit == null)
			{
				flushSuit = mySuit;
			}
			else if (flushSuit != mySuit)
			{
				flush = false;
				royalFlush = false;
			}
			
			//Check for straights
			if (royalFlush && myRank.compareTo(Rank.Ten) < 0)
				royalFlush = false;

			//Add this card to temp hand
			tempHand.add(c);
		}
		
		//Run cards sorted by rank
		for (Card c: tempHand)
		{
			myRank = c.getRank();
			if (straightRank == null)
			{
				straightRank = myRank;
			}
			else if ((straightRank.ordinal()+1) == myRank.ordinal())
			{
				straightRank = myRank;
			}
			else
			{
				straight = false;
				royalFlush = false;				
			}
		}

		//Display the various hands
		String outputString;
		Boolean writeToScreen = false;
		if (straight)
		{
			if (royalFlush)
			{
				outputString = "Royal Flush " + flushSuit;
				handType[ROYALFLUSH]++;
			}
			else if (flush)
			{
				outputString = "Straight Flush " + flushSuit;
				handType[STRAIGHTFLUSH]++;
			}
			else
			{
				outputString = "Straight";
				handType[STRAIGHT]++;
			}
		}
		else if (flush)
		{
			outputString = ("Flush " + flushSuit);
			handType[FLUSH]++;

		}
		else if (fourKind != null)
		{
			outputString = "Four of a kind " + fourKind;
			handType[FOUROFAKIND]++;
		}
		else if (fullHouse)
		{
			outputString = ("Full house " + threeKind + " " + pairs[0]);
			handType[FULLHOUSE]++;
		}
		else if (threeKind != null)
		{
			outputString = ("Three of a kind " + threeKind);
			handType[THREEOFAKIND]++;			

		}
		else if (twoPair)
		{
			outputString = ("Two pair " + pairs[0]  + " " + pairs[1]);
			handType[TWOPAIR]++;
		}
		else if (onePair)
		{
			outputString = ("One pair " + pairs[0]);
			handType[ONEPAIR]++;
		}
		else
		{
			outputString = ("Highest card " + highestCard);
			handType[HIGHESTCARD]++;
		}
		
		if (writeToScreen)
		{
			System.out.println(outputString);
		}
		else
		{
			try
			{
				//myFileOutput.println(outputString);
				//myFileOutput.println(" ");
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return 0;
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
	

	public void dealPlayerHand()
	{	
		int slot;
		Card card;

		//Establish fresh hand of cards
		if (myHand != null && myHand.size() > 0)
			while (myHand.size() > 0 )
		      myHand.remove(0);
		

		
		//Deal hand
		for (int i = 0; i < HANDSIZE; i++)
	    {
		  if (!myDeck.hasNextCard())
		     myDeck.shuffle();
		  card = myDeck.nextCard();
	      myHand.add(i, card);
	    }		    
		
		this.arangeHand();
		//System.out.println("Here is your sorted hand:");
		for (Card c: myHand)
		{
			try
			{
				//myFileOutput.println(c);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}

			//System.out.println(c);
		}
		//System.out.println("\n");
		this.handValue2();
	}

}

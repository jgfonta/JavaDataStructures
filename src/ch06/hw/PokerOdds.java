package ch06.hw;

import java.util.*;
import ch06.lists.*;
import support.cards.*;

//*********************************
//*   Problem #33
//*********************************
//These applications should create random five card poker
//hands using the CardDeck class. You may find that sorting the
//hand in various ways aids in the determination of the hand rank.
//
//2. PokerOdds should generate 10 million five-card poker hands
//and output the relative percentage of times each of the card
//ranks listed on page 370 occurs. Each hand contributes only
//to the count of its highest possible rank. Do some research
//and compare your result to the known probabilities for poker
//hands.

public class PokerOdds {

	public static void main(String[] args) {
		PokerValue myPoker = new PokerValue();
		
		
		
		for (int i = 0; i < 10000000; i++)
		{
			if ((i % 1000000) == 0)
				System.out.println("Completed " + i + " hands");
			myPoker.dealPlayerHand();
		}
		
		System.out.println("\n\n");
		System.out.println("Royal Flush \t" + myPoker.handType[myPoker.ROYALFLUSH]);
		System.out.println("Straight Flush \t" + myPoker.handType[myPoker.STRAIGHTFLUSH]);
		System.out.println("Four of a kind \t" + myPoker.handType[myPoker.FOUROFAKIND]);
		System.out.println("Full house \t" + myPoker.handType[myPoker.FULLHOUSE]);
		System.out.println("Flush \t\t" + myPoker.handType[myPoker.FLUSH]);
		System.out.println("Straight \t" +	myPoker.handType[myPoker.STRAIGHT]);
		System.out.println("Three of a kind " + myPoker.handType[myPoker.THREEOFAKIND]);			
		System.out.println("Two pair \t" + myPoker.handType[myPoker.TWOPAIR]);
		System.out.println("One pair \t" + myPoker.handType[myPoker.ONEPAIR]);
		System.out.println("Highest card \t" + myPoker.handType[myPoker.HIGHESTCARD]);
		
		double[] handPercent = new double[myPoker.ROYALFLUSH+1];
		
		for (int i = 1; i<myPoker.ROYALFLUSH;i++)
		{
			handPercent[i] = myPoker.handType[i];
			handPercent[i] = handPercent[i] / 10000000;
			handPercent[i] = handPercent[i] * 100;
		}
		
		System.out.println("\n\n");
		System.out.println("Royal Flush \t" + handPercent[myPoker.ROYALFLUSH] + "%");
		System.out.println("Straight Flush \t" + handPercent[myPoker.STRAIGHTFLUSH] + "%");
		System.out.println("Four of a kind \t" + handPercent[myPoker.FOUROFAKIND] + "%");
		System.out.println("Full house \t" + handPercent[myPoker.FULLHOUSE] + "%");
		System.out.println("Flush \t\t" + handPercent[myPoker.FLUSH] + "%");
		System.out.println("Straight \t" +	handPercent[myPoker.STRAIGHT] + "%");
		System.out.println("Three of a kind " + handPercent[myPoker.THREEOFAKIND] + "%");			
		System.out.println("Two pair \t" + handPercent[myPoker.TWOPAIR] + "%");
		System.out.println("One pair \t" + handPercent[myPoker.ONEPAIR] + "%");
		System.out.println("Highest card \t" + handPercent[myPoker.HIGHESTCARD] + "%");



	}

}

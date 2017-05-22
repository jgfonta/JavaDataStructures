package ch02.hw;

import java.util.Scanner;

//Use the LinkedStack class to support an application that tracks the 
//status of an online auction. Bidding begins at 1 (dollars, pounds, euros, or whatever) 
//and proceeds in increments of at least 1. 
//If a bid arrives that is less than the current bid, it is discarded. 

//If a bid arrives that is more than the current bid, but less than the maximum bid 
//by the current high bidder, then the current bid for the current high bidder is 
//increased to match it and the new bid is discarded. 

//If a bid arrives that is more than the maximum bid for the current high bidder, 
//then the new bidder becomes the current high bidder, at a bid of one more than the 
//previous high bidder’s maximum. 

//When the auction is over (the end of the input is reached), a history of the actual 
//bids (the ones not discarded), from high bid to low bid, should be displayed. 

//For example:
//I/O 		Bid	Result			High Bidder		High Bid	Maximum Bid
//7 John	New high bidder		John			1			7
//5 Hank	High bid increased	John			5			7
//10 Jill	New high bidder		Jill			8			10
//8 Thad	No change			Jill			8			10
//15 Joey	New high bidder		Joey			11			15

//The bid history for this auction would be
//Joey	11
//Jill	8
//John	5
//John	1


public class AuctionHouse {

	public static void main(String[] args) {
		System.out.println("Welcome to Fongs auction house");
		
		Auction fongAuction = new Auction("Fong Auction",1);
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.println("Place a bid");
		System.out.println("Format is name maximum bid amount, e.g. Jeff 20 or DONE to end");
		
		String bidString = "";
		do 
		{
			try
			{
				bidString = myInput.nextLine();
				fongAuction.placeBid(
					bidString.substring(0, bidString.indexOf(" ")),
					Integer.parseInt((bidString.substring(bidString.indexOf(" ")+1, bidString.length())))
					);
			} catch (Exception e)
			{
				//nothing
			}
		}while(!bidString.equals("DONE"));
		System.out.println("Congratulations " +
				fongAuction.winningBidder() + " $" + 
				fongAuction.winningBidAmount());
		System.out.println(fongAuction.bidHistory());
		
	}

}

package ch02.hw;

import ch02.stacks.LinkedStack;
import ch02.stacks.StackInterface;

public class Auction {

	protected String auctionName;
	protected StackInterface bidStack;
	private int bidIncrement;
	
	public Auction(String name, int increment)
	{
		this.auctionName = name;
		bidIncrement = increment;
		bidStack = new LinkedStack<AuctionBid>();
	}

	public String bidHistory()
	{
		String history;
		
		history = "";
		while (!bidStack.isEmpty())
		{
			history += ((AuctionBid)bidStack.top()).getName() 
					+ "$" + ((AuctionBid)bidStack.top()).currentBid
					+ "\n";
			bidStack.pop();
		}	
		return history;
	}
	public int winningBidAmount()
	{
		return ((AuctionBid)bidStack.top()).currentBid;
	}
	
	public String winningBidder()
	{
		return ((AuctionBid)bidStack.top()).getName();
	}
	
	public int placeBid(String name,int maxbid)
	{
		AuctionBid thisBid = new AuctionBid(name,maxbid);
		return(checkBid(thisBid));
	}
	
	
	private int checkBid(AuctionBid mybid)
	{
		if (bidStack.isEmpty())
		{
			bidStack.push((AuctionBid)mybid);
			mybid.setCurrentBid(bidIncrement);
			return mybid.currentBid();
		}
		else
		{
			if (!((AuctionBid)bidStack.top()).setCurrentBid(mybid.getMaxBid()+bidIncrement))
			{
				mybid.setCurrentBid((((AuctionBid)bidStack.top()).getMaxBid())+bidIncrement);
				bidStack.push((AuctionBid)mybid);
			}
		}
		
		return 0;
	}
}

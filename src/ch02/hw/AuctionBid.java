package ch02.hw;

public class AuctionBid {

	protected String bidderName;
	protected int maxBid, currentBid;
	
	public AuctionBid(String bidder, int max)
	{
		bidderName = bidder;
		maxBid = max;
		currentBid = 0;
	}
	
	public String getName()
	{
		return this.bidderName;
	}
	
	public int getMaxBid()
	{
		return this.maxBid;
	}
	
	public int currentBid()
	{
		return this.currentBid;
	}

	public boolean setCurrentBid(int newBid)
	{
		if (newBid <= maxBid) 
		{
			this.currentBid = newBid;
			return true;
		}
		return false;
	}
}

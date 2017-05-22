package ch02.hw;

public interface AuctionInterface {

	boolean placeBid(AuctionBid myBid);
	AuctionBid getHigest();
	String getPreviousBid(AuctionBid myBid);
}

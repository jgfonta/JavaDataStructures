package ch06.hw;

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

public class IBPlayer {
	
	private int chips, bet;
	private String name;
	final static private int DEFAULT_CHIPS = 100;
	
	public IBPlayer(int stake, String playerName)
	{
		chips = stake;
		bet = 0;
		name = playerName;
	}
	
	public IBPlayer()
	{
		chips = DEFAULT_CHIPS;
		bet = 0;
		name = "Andy";
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
	
	public void won()
	{
		chips += bet;
		bet = 0;
	}
	
	public void lost()
	{
		chips -= bet;
		bet = 0;
	}
	
	
	
}

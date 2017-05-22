package ch01.apps;

public class TicTacToe {

	String[] board = new String[] {"1","2","3","4","5","6","7","8","9"};
	public TicTacToe ()
	{
		//nothing required
	}
	
	public String returnBoard()
	{
		String displayBoard = new String("");
		int middleLine = 0;

		for (int i = 0; i < 9; i++)
		{		
			displayBoard = displayBoard + board[i];
			if ( ((i+1) %  3) == 0 )
			{
			   displayBoard = displayBoard + "\n";
			   if (middleLine < 2)
			   {
				   displayBoard = displayBoard + "-----\n";
				   middleLine++;
			   }
			}
			else
				displayBoard = displayBoard + "|";
	    }
		return displayBoard;
	}
		
	public boolean setXO(int slot, String marker)
	{
		if (marker.equals("X") | marker.equals("O"))
		{
			if (slotAvailable(slot)) 
			{
				board[slot] = marker;
			}
		}
		return (board[slot].equals(marker));
	}
	
	private boolean slotAvailable(int slot)
	{
		if (board[slot].equals("O") | board[slot].equals("X"))
			return false;
		else
			return true;
	}
    public String statusGame()
    {
    	//Vertical 
		for (int i = 0; i < 9; i = i+3)
		{		
			if (  board[i].equals("O") 
				& board[i+1].equals("O")
				& board[i+2].equals("O"))
				return board[i];
			if (  board[i].equals("X") 
				& board[i+1].equals("X")
				& board[i+2].equals("X"))
				return board[i];
		}
   	
    	//Across 
		for (int i = 0; i < 3; i++)
		{		
			if (  board[i].equals("O") 
				& board[i+3].equals("O")
				& board[i+6].equals("O"))
				return board[i];
			if (  board[i].equals("X") 
				& board[i+3].equals("X")
				& board[i+6].equals("X"))
				return board[i];
		}

    	//Diagonal
		for (int i = 0; i < 3; i = i+2)
		{		
			if (  board[i].equals("O") 
				& board[4].equals("O")
				& board[8-i].equals("O"))
				return board[i];
			if (  board[i].equals("X") 
				& board[4].equals("X")
				& board[8-i].equals("X"))
				return board[i];
		}
		
    	//Tie
		for (int i = 0; i < 9; i++)
		{		
			if (!board[i].equals("O") & !board[i].equals("X") )
				return "Continue";
		}
		return "Tie";
    }

}

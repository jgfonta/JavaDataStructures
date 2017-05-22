package ch01.apps;

import java.util.*;


public class TicTacToeGame {

	public static void main(String[] args) 
	{
		TicTacToe mygame = new TicTacToe();
		int playerPos;
		String playerMark = new String("X");
		String winningPlayer = new String();
	    Scanner scan1 = new Scanner(System.in);
	    do
	    {
		    do
		    {
			    System.out.println(mygame.returnBoard());
			    System.out.println("Player " + playerMark + " choose a position:");
			    playerPos = scan1.nextInt() - 1;
		    }
		    while (!mygame.setXO(playerPos,playerMark));
		    if (playerMark.equals("X"))
		    	playerMark = "O";
		    else
		    	playerMark = "X";
		    winningPlayer = mygame.statusGame();
		}
	    while (winningPlayer.equals("Continue"));
	    
	    System.out.println(mygame.returnBoard());
	    if (winningPlayer.equals("Tie"))
	   	    System.out.println("Good try, tie game");
	   	else
	   		System.out.println("Player " + winningPlayer + " won!");	   	    	
	   	}

}

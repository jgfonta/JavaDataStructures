package ch06.hw;


//Jeff must do these problems
// 23, 26, 28, 29 and 33

//*********************************
//*   Problem # 23  done
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

//*********************************
//*   Problem # 26  done
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

//*********************************
//*   Problem # 28  done
//*********************************
//Create an application (that uses the SortedABList) that
//reads a list of strings from a file and outputs them in alphabetical
//order.

//*********************************
//*   Problem #29  done
//*********************************
//Create an application (that uses the SortedABList) that
//allows a user to enter a list of countries that he or she has visited
//and then displays the list in alphabetical order, plus a count of how
//many countries are on the list. If the user mistakenly enters the
//same country more than once, the program should inform the user
//of their error and refrain from inserting the country into the list a
//second time.

//*********************************
//*   Problem #33 done
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
//2. PokerOdds should generate 10 million five-card poker hands
//and output the relative percentage of times each of the card
//ranks listed on page 370 occurs. Each hand contributes only
//to the count of its highest possible rank. Do some research
//and compare your result to the known probabilities for poker
//hands.

//*******************************************
// Jeff should do these problem for practice
//*******************************************

//*********************************
//*   Problem #22
//*********************************
//Implement a graphical user interface-based version of the
//Higher-Lower application.

//*********************************
//*   Problem #41
//*********************************
//Consider the multiplication of large integers.
//1. Describe an algorithm.
//2. Implement a multiply method for the LargeInt class.
//3. Add multiplication to the Large Integer Application.

//*********************************
//*   Problem #32
//*********************************
//A bridge hand consists of 13 playing cards. Many bridge players
//arrange their hands left to right first by decreasing suit (spades,
//hearts, diamonds, clubs) and within each suit by decreasing rank
//(ace through 2). Add a method bridgeComparator to the Card
//class of the support package that returns a Comparator<Card>
//object that can be used to sort cards in this fashion. Demonstrate by
//creating an application that instantiates a deck of cards, deals four
//bridge hands, and then displays the hands side by side, for example
//the output might start with something such as:
//Ace of Spades 	Ace of Hearts 	Jack of Hearts 		Ace of Diamonds
//Queen of Hearts 	Ace of Clubs 	Ten of Clubs 		King of Clubs
//Queen of Clubs 	King of Spades 	Nine of Diamonds 	Ten of Hearts
//. . . . . . . . . . . .

//*********************************
//*   Problem #21
//*********************************
//The following enhancements to the HigherLower application
//are intended to be completed in the sequence listed:

//1. It accepts upper- or lowercase H and L replies from the user.

//2. It repeatedly deals a hand until there are no more cards left in
//the deck.

//3.  The user starts with a “stake” of 100 chips. After seeing the
//first card the user can risk from one to their total number of
//chips. If the user predicts correctly their number of chips is
//increased by the number of chips they risked; if they are incorrect
//it is decreased by that amount. The game ends when
//all the cards are dealt or when they run out of chips.

//4. If the second card is equal to the first card the user “loses”
//double their risk.

//*********************************
//*   Problem #20 (& 25)
//*********************************
//The CardHandCLI application allows the user to “arrange”
//a hand of five cards. However, some poker games use seven cards
//per hand and in a game such as bridge there are 13 cards per hand.
//Change the CardHandCLI application so that the number of cards
//in the hand is passed to the application as a command line argument

//*********************************
//*   Problem #25 (& 20)
//*********************************
//Similar to Exercise 20, change the Pairs application so that
//the number of cards in a hand is passed to the application as a command
//line argument. Use the new program to investigate the probability
//of getting at least a pair in a seven-card poker hand. Calculate
//the theoretical probability of the same (or have your program do it
//for you!), using the approach described in this section, and compare
//it to the output of your program. Is it close?

//*********************************
//*   Problem #30
//*********************************
//Currently the FamousPerson class defines the natural order
//of its elements to be based on the alphabetical order of people
//names (last name, then first name). It also provides a Comparator
//that defines order based on increasing year of birth. Augment the
//class to include more public static methods that return Comparators
//as described below. Augment the CSPeople application to
//demonstrate that the new Comparators work properly.
//
//1. Order alphabetically by name (first name, then last name)
//
//2. Order by year of birth—decreasing
//
//3. Order by length of “fact”—increasing

//*********************************
//*   Problem #19
//*********************************
//Add the following methods to the CardDeck class, and create
//a test driver for each to show that they work correctly.

//1. int cardsRemaining() returns a count of the number of
//undealt cards remaining in the deck.

//2. Card peek() returns the next card from the deck without removing
//it— precondition is that hasNext returns true.

//3. void reset() resets the deck back to its original order, that
//is, to the order exhibited by a new deck.

//*********************************
//*   Problem #15
//*********************************
//Application: This chapter specifies and implements a List
//ADT.
//1. Design an algorithm for an application-level method compare
//that accepts two String lists as arguments and returns an
//int representing a count of the number of elements from the
//first list that are also on the second list. The signature for the
//method should be
//     int compare(ListInterface<String> list1,
//     ListInterface<String> list2)
//2. Devise a test plan for your algorithm.
//3. Implement and test your algorithm.

//*********************************
//*   Problem #14
//*********************************
//Application: This chapter specifies and implements a List
//ADT.

//1. Design an algorithm for an application-level method last
//that accepts a String list as an argument and returns a
//String. If the list is empty, the method returns null. Otherwise,
//it returns the last element of the list. The signature for
//the method should be:
//  String last(ListInterface<String> list)

//2. Devise a test plan or your algorithm.

//3.  Implement and test your algorithm.

//*********************************
//*   Problem #11
//*********************************
//Consider the indexed operation: removeAll(T target,
//int start, int end)—removes all elements from the list that
//are equal to target that are held in between index start and index
//end.
//
//1. The removeAll method is not well specified. Carefully define
//your detailed vision for removeAll including preconditions
//and exceptions that will be thrown.
//
//2. Implement removeAll for the ABList class and create a
//driver application that demonstrates it works correctly.
//
//3. Implement removeAll for the LBList class and create a
//driver application that demonstrates it works correctly.

//*********************************
//*   Problem #9
//*********************************
//Repeat the below exercises for the LBList class.
//Programming tasks:
//1. Add a toString method to the ABList class that returns the
//contents of the list as a nicely formatted string. You should
//then use the toString method, as appropriate, in the rest of
//this exercise.
//2. Create an application TestBasic that demonstrates that the
//“basic” list operations (add, remove, contains, get, and
//size) supported by ABList work as expected.
//3. Create an application TestIndexed that demonstrates that
//the index-related list operations supported by ABList work
//as expected.
//4. Create an application TestIterator that demonstrates that
//the iterator-related list operations supported by ABList work
//as expected.

//*********************************
//*   Problem #8
//*********************************
//Programming tasks:
//1. Add a toString method to the ABList class that returns the
//contents of the list as a nicely formatted string. You should
//then use the toString method, as appropriate, in the rest of
//this exercise.
//2. Create an application TestBasic that demonstrates that the
//“basic” list operations (add, remove, contains, get, and
//size) supported by ABList work as expected.
//3. Create an application TestIndexed that demonstrates that
//the index-related list operations supported by ABList work
//as expected.
//4. Create an application TestIterator that demonstrates that
//the iterator-related list operations supported by ABList work
//as expected.




public class ch6homework {

}

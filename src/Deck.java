////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     Deck
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

// Class to simulate a deck of 52 playing cards
// with rank and suit

public class Deck extends MyArrayList<Card>
{
	private static final int NUMCARDS = 52; // the total number poker card in deck is 52 cards
	private Card [] deck;         // An array to store 52 cards

	// Default Constructor: Create a deck of 52 cards
	// by passing 52 to the MyArrayList constructor 
	// and then calling the generateDeck method
	public Deck()
	{
		deck = new Card [NUMCARDS];
		generateDeck(); // calling the generate methods
	}

	// Generates the 52 Cards and adds them to the Deck
	// Use a nested loop: Rank: 1-13 and Suit: 1-4

	public void generateDeck()
	{
		// code todo
	}

	// Shuffle the 52 Cards: 
	// See Lesson2 Source Code DeckOfCards for Hint
	// Loop through each card in the Deck:
	//   a. Generate a random index (0-51)
	//   b. Swap the card with the one at the random index


	public void shuffle()
	{
		for (int i = 0; i < deck.length; i++)
		{
			// Generate an index randomly 0 - 51
			int index = (int)(Math.random() * deck.length);
			// Swap cards
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
	}

	// Print the Deck: 13 cards per line
	// Call the Card's toString

	@Override
	public String toString()
	{
		String deckStr = "";

		for (int c = 0; c < size(); c++)
		{
			deckStr = deckStr + get (c).toString() +
					  ((((c+1) % 13) == 0) ? '\n' : ' ');
		}

		return deckStr;
	}    
}


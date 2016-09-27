import java.io.PrintWriter;
import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     Table
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
///////////////////////////////////////////////////////////////////////////////

// The Table holds each of the piles (ArrayList of Stacks) of Cards	as 
//   they are placed on the piles using the rules of the game.
// The Table also holds a list of ordered subsequences (ArrayList of 
//   LinkedLists)
// It creates the ArrayList of Card Stacks (piles) from the Deck of 
//   Cards.
// It creates the ArrayList of Card LinkedLists (subsequences) as the 
//   Cards are added to the piles. 
// The list of linked Cards contains a subset of the longest ordered 
//   subsequences from the Deck.
// These longest decreasing and increasing subsequences are printed.
// The Cards are retrieved from the piles in a new Deck in sorted order
//   and the new Deck is printed.

public class Table
{
	// Holds the stacks of cards in an ArrayList of Card Stacks

	private MyArrayList<MyStack<Card>> piles;

	// Holds a list of sequences in an ArrayList of Card Linked Lists

	private MyArrayList<MyLinkedList<Card>> subSeqs;

	// The number of Stacks of Cards in the ArrayList

	private int numPiles;

	// Constructor: initialize instance variables

	public Table()
	{
		// code todo
	}

	// This method creates the piles (stacks) from the Deck of Cards,
	// according to the following rules:
	//  A. Initially, there are no piles. The first Card dealt
	//     forms a new pile consisting of the first Card.
	//  B. Each new Card picked from the Deck must be placed on top
	//     of the leftmost pile (lowest MyArrayList index), whose
	//     top Card has a value higher than the new Card's value.
	//  C. If there are only piles with top Cards that are lower
	//     in value than the new Card's value, then use the new
	//     Card to start a new pile to the right of all the
	//     existing piles (at end of MyArrayList of MyStack piles)
	//  D. Save card in ArrayList of LinkedList subsequences (See below)
	//  E. The game ends when all the cards have been dealt.
	//
	// Dealing the cards in this way provides us a way of retrieving
	// a subset of the longest increasing and decreasing subsequences.
	//  A. The number of piles is the length of a longest subsequence.
	//  B. For each new Card, add a copy of that card to the list of
	//     subsequences and link it to the top Card in the previous
	//     pile to the left of this pile - the one with the lower 
	//     ArrayList index - By design, the pile's top Card has a 
	//     lower value than the value of the new Card.
	//
	// The Algorithm:
	// Loop retrieving each card in the Deck
	//   1. Retrieve the card from the Deck: cardFromDeck
	//   2. Set a flag to indicate if we placed the 
	//      cardFromDeck in an existing pile
	//   3. Loop through each pile starting from the 
	//      leftmost pile - ArrayList index 0 - to find 
	//      the correct one on which to place the cardFromDeck
	//      a. Retrieve top Card on the Stack using peek
	//      b. If there exists a pile whose top Card is
	//         is higher than the cardFromDeck, then
	//         i.   Set flag to say we have found a pile on
	//              which to place the cardFromDeck
	//         ii.  Retrieve a reference to the top Card 
	//              on the previous pile - the one to the 
	//              left of where you just placed the 
	//              cardFromDeck: (one less index value 
	//                             in ArrayList)
	//         iii. Add the cardFromDeck to the list of
	//              subsequences using the addCardToSubSeq method
	//         iv.  Push the cardFromDeck onto the pile
	//   4. Check the flag:
	//      If we haven't found a place for the cardFromDeck 
	//      in an existing pile, then
	//   	a. Create a new pile (in ArrayList of Stacks)
	//   	b. Retrieve a reference to the top Card on the 
	//         previous pile, - the one to the left of where 
	//         you just placed the cardFromDeck: (one less 
	//         index value in ArrayList), unless this first 
	//         card from the Deck: numPiles equal 0
	//   	c. Add the cardFromDeck to the list of 
	//         subsequences using the addCardToSubSeq method
	//      d. Add the cardFromDeck onto the pile
	//      e. Increment the pile count

	public void constructCardPiles (Deck deck)
	{
		// code todo
	}

	// Use the passed in PrintWriter to print each pile
	// on the ArrayList of Card Stacks

	public void printCardPiles (PrintWriter writer)
	{
		// code todo
	}

	// Use the passed in PrintWriter to print each of the decreasing
	// and increasing subsequences
	//
	// The Algorithm:
	// 1. Loop through the subsequence list and obtain each 
	//    subsequence whose size equals the number of piles - 
	//    the longest subsequences - Use the PrintWriter to 
	//    print each of these subsequence
	// 2. Loop through the subsequence list again and obtain 
	//    each subsequence whose size equals the number of piles 
	//    - this time reverse the subsequence and use the 
	//    PrintWriter to print it

	public void printLongestSubSeqs (PrintWriter writer)
	{
		// code todo
	}

	// Builds a sorted Deck by looking at the top Card of each pile
	// (stack) and grabbing the card with the lowest value; thus,
	// Cards are picked up in sorted order and added to the new Deck
	//
	// Algorithm:
	// Loop for each card in the deck
	//   1. Keep an index to the pile with the lowest card, so far
	//   2. Keep the lowest Card found so far - initialize it to
	//      the highest card for starters
	//   3. Walk across the piles - skipping empty ones - and find
	//      the ArrayList index of the Stack with smallest card by
	//      comparing the top card in the pile to the current
	//      lowest card by using the Card compareTo method -
	//      Dont' pop the card yet; it may not be the overall
	//      lowest - Update the the lowest Card and its ArrayList
	//      index along the way
	//   4. Now that we have exited the walk of the piles, we know
	//      the index of the stack with the lowest Card - pop that
	//      Card from the stack and put it on the new sorted Deck

	public void makeSortedDeck (Deck deck)
	{
		// code todo
	}

	// Adds a copy of the currentCard to one of the subsequences  
	// in the subsequence list. The correct subsequence on which to  
	// add the currrentCard is the one on which the previousCard 
	// currently resides.
	//
	// The Algorithm:
	// 1. Make a copy of the currentCard, using Card's copy 
	//    constructor.
	// 2. Find the subsequence containing the previousCard
	//    by calling the findSubSeq method
	// 3. If there is no subsequence (null), create a new 
	//    subsequence LinkedList and add the copy of the 
	//    currentCard to the new subsequence and add the new 
	//    subsequence to the ArrayList of LinkedList of subsequences
	// 4. If there was a subsequence containing the previousCard,
	//    then check to see if the previousCard is at the front 
	//    of the subsequence LinkedList:
	//    a. If the previousCard is at the head, then just add the
	//       the copy of the currentCard to the front of the
	//       subsequence LinkedList, thus linking the two Cards
	//    b. If the previousCard is not at the head, 
	//       then we must
	//       i.   Copy the subsequence containing the previousCard
	//            by calling the copySubSeq method
	//       ii.  Add the copied subsequence to the ArrayList of
	//            subsequences
	//       iii. Traverse the copied subsequence from the head,
	//            removing each Card that is not the previousCard.
	//            Break out of the loop when finding the previousCard.
	//           - Hint: You can use a FOR EACH loop
	//       iv.  Now, the previousCard is at the front of the 
	//            subsequence, so we can add the copy of the 
	//            currentCard to the front of the subsequence, 
	//            thus linking the two Cards

	private void addCardToSubSeq (Card currentCard, Card previousCard)
	{
		// code todo
	}

	// Find the first subsequence in the ArrayList of 
	// subsequences that contains the Card passed in
	// The Algorithm:
	// 1. Make sure the card passed in is not null, 
	//    if so return null.
	// 2. Traverse the ArrayList of subsequence LinkedLists, 
	//    checking to see if the subsequence contains the 
	//    card passed in - Hint: You can use a FOR EACH loop
	// 3. Return the subsequence when found

	private MyLinkedList<Card> findSubSeq (Card card)
	{
		// code todo
	}

	// Make a copy of a subsequence LinkedList by copying each Card
	// and adding the new copy to the new subsequence.
	//
	// The Algorithm:
	// 1. Create a new LinkedList to hold the new subsequence
	// 2. Traverse the passed in LinkedList, create a new Card from
	//    each Card using the Card copy constructor and then add
	//    each new Card to the end of the new subsequence LinkedList
	//    Hint: You can use a FOR EACH loop
	// 3. Return the new subsequence.

	private MyLinkedList<Card> copySubSeq (MyLinkedList<Card> subSeq)
	{
		// code todo
	}

	// Reverse the given subsequence using a stack
	//
	// The Algorithm:
	// 1. Create a new LinkedList to hold the new subsequence
	// 2. Create a Stack to use to do the reversing
	// 3. Traverse the passed in LinkedList and place each
	//    Card on the Stack - Hint: You can use a FOR EACH loop
	// 4. Loop through the Stack, popping off the Cards and
	//    adding them to the end of the new subsequence LinkedList
	// 5. Return the new subsequence.

	public MyLinkedList<Card> reverseSubSeq (MyLinkedList<Card> subSeq)
	{
		// code todo
	}
}


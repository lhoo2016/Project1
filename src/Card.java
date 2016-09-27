////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     Card
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

// Simple class to represent a playing card with 
// rank (1-13): Aces low = 1, Kings high and 
// suit (1-4): CLUB=1, DIAMOND=2, HEART=3, SPADE=4

public class Card implements Comparable<Card>
{
    // For printing the card rank

    public static String[] RANKS =
    {
        " A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"
    };

    // For printing the card suit

    public static String[] SUITS =
    {
        "-C", "-D", "-H", "-S"
    };
    
    // private instance variables

    private int rank;
    private int suit;

    // Default Constructor: initialize to Ace of Clubs
    
    public Card()
    {
        // code todo
    }

    // Two-Param Constructor : initialize rank and suit
    
    public Card (int initRank, int initSuit)
    {
        // code todo
    }

    // Copy constructor: Copies a Card from another Card
    
    public Card (Card otherCard)
    {
        // code todo
    }
    
    // Returns relative position of this Card to someCard.
    // This compares the Cards, first by rank: Aces low, King High
    // then Suit within rank: CLUB=1, DIAMOND=2, HEART=3, SPADE=4
    
    public int compareTo (Card someCard)
    {
        // code todo
    }

    // Determines whether this Card has the same rank and suit
    // as another Card passed in - Note cast of obj to Card
    
    @Override
    public boolean equals (Object obj)
    {
        Card someCard = (Card) obj;
        return (someCard.compareTo (this) == 0);
    }

    // Print the card's rank and suit using the static
    // String arrays defined about
    
    public String toString()
    {
        String printString = RANKS[rank - 1] + SUITS[suit - 1];
        return printString;
    }
}

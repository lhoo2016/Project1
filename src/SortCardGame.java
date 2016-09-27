import java.io.File;
import java.io.PrintWriter;

////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     SortCardGame
//   
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

// Simulates playing the sort card game:
//   1. Places each Card from a shuffled Deck on a Stack on the Table
//      using the rules of the game.
//   2. At the same time a copy of the Card is placed on the top of a 
//      sequence LinkedList such that it is pointing to the top
//      Card of the stack previous to the stack on which it is placed 
//   3. Prints a longest decreasing subsequence for each Card in last stack
//   4. Uses an additional stack to reverse the subsequence and pring the 
//      corresponding longest increasing subsequence    
//   5. Uses the Card pile stacks on the Table to return a sorted Deck
//   6. Passes in the PrintWriter object to the playGame method 
//      to make it easier to print the output to File.

public class SortCardGame
{
	private static final String OUTPUT_FILE = "./src/SortGameOut.txt";

	public static void main(String[] args) throws Exception
	{
		int runs = 5;			 // number of games to play,

		// Create an output File writer

		File outFile = new File (OUTPUT_FILE);
		PrintWriter writer = new PrintWriter (outFile, "Unicode");

		// Display number of runs

		System.out.println ("Playing " + runs + " games.");

		// Loop to play the game for the number of specified runs
		// Display the Begin Game and End Game messages

		for (int run = 1; run <= runs; run++)
		{
			writer.println("\n=========== Begin Game " + run + " ==========");

			playGame (writer);	  // Play the Game

			writer.println("=========== End   Game " + run + " ==========");          
		}

		writer.close();

		System.out.println ("Simulation complete.");

		return;
	}

	// Simulates playing the sort card game and finding longest subsequences:
	//  1. As each Card is placed on the correct stack on the Table, it is
	//     also placed correctly in a linked list of Cards forming an 
	//     ordered longest subsequence.   
	//  2. Prints a longest decreasing and increasing subsequence for 
	//     each Card in last stack
	//  3. After the Cards have all been placed on the Table in their 
	//     correct stack, they are picked back up in sorted ordrer.
	//
	//  Algorithm:
	//    1.Create the Table and Deck objects
	//    2.Print the Deck before shuffling
	//    3.Shuffle the deck 7 times, calling the Deck shuffle method
	//    4.Print the Deck after shuffling
	//    5.Construct the card piles on the Table, calling the
	//      Table constructCardPiles method
	//    6.Print the card piles before doing the sort
	//      calling the Table printCardPiles method
	//    7.Print the longest subsequences, calling 
	//      the Table printLongestSubSeqs method 
	//    8.Use the piles on the Table to make a sorted Deck,
	//      calling the Table makeSortedDeck method
	//    9.Display the sorted Deck

	public static void playGame (PrintWriter writer)
	{
		// code todo
	}
}



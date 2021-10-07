package project1;

import java.util.Scanner;
import java.util.Random;

public class HelloWorld {
	public static void main(String[] args) {
		
		String playerCharacter, previousNPC = null;
		String nonplayerCharacter = null;
		String choice;
		Boolean playAgain = true, choice2 = true, previousRound = false;
		int generateRank, win = 0, lose = 0;
		
		// Used to get input from user and RNG.
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		
		System.out.println("Welcome to Hunter-Bear-Ninja!\n");
		
		while (playAgain){	
			
		// Randomly select NPC's character.
		if (previousRound == false){
			generateRank = generator.nextInt(3);
			if (generateRank == 0)
				nonplayerCharacter = "H";
			else if (generateRank == 1)
				nonplayerCharacter = "B";
			else if (generateRank == 2)
				nonplayerCharacter = "N";
			else
				System.out.println("Something went wrong with the RNG");
		}
		
		// If user wins previous round, NPC selects a different character from previous round.
		if (previousRound == true){
			while (nonplayerCharacter.equals(previousNPC)){
				generateRank = generator.nextInt(3);
			if (generateRank == 0)
				nonplayerCharacter = "H";
			else if (generateRank == 1)
				nonplayerCharacter = "B";
			else if (generateRank == 2)
				nonplayerCharacter = "N";
			else
				System.out.println("Something went wrong with the RNG");
			}
		}
				
		previousNPC = nonplayerCharacter;
		
		System.out.println("Select your player\n" + "Hunter = H\n" + "Bear = B\n" + 
				"Ninja = N\n" + "Note: Use capital letters\n");
		
		// User selects character.
		playerCharacter = scan.next();
		if (!playerCharacter.equals("H") && 
			!playerCharacter.equals("B") && 
			!playerCharacter.equals("N"))
			System.out.println("Invalid input!!!");
			
		System.out.println("You have selected " + playerCharacter);
		System.out.println("The computer has selected " + nonplayerCharacter);
	
		// Determines outcome of each round, keeps track of wins/loses.
		if (playerCharacter.equals(nonplayerCharacter))
				System.out.println("Tie!");
		else if (playerCharacter.equals("H") && nonplayerCharacter.equals("B")){
				System.out.println("Hunter shoots bear! You win!");
				win++;
				previousRound = true;
				}
		else if (playerCharacter.equals("H") && nonplayerCharacter.equals("N")){
				System.out.println("Ninja kills hunter! You lose!");
				lose++;
				previousRound = false;
				}
		else if (playerCharacter.equals("B") && nonplayerCharacter.equals("H")){
				System.out.println("Hunter kills bear! You lose!");
				lose++;
				previousRound = false;
				}
		else if (playerCharacter.equals("B") && nonplayerCharacter.equals("N")){
				System.out.println("Bear eats ninja! You win!");
				win++;
				previousRound = true;
				}
		else if (playerCharacter.equals("N") && nonplayerCharacter.equals("B")){
				System.out.println("Bear eats ninja! You lose!");
				lose++;
				previousRound = false;
				}
		else if (playerCharacter.equals("N") && nonplayerCharacter.equals("H")){
				System.out.println("Ninja kills hunter! You win!");
				win++;
				previousRound = true;
				}	
		else
			System.out.println("Invalid input");
		
		System.out.println("Your win to lose ratio is " + win + ":" + lose);
		
		// Asks user if they want to play again.
		System.out.println("Would you like to play again? Y/N");
		choice = scan.next();
		
		while (choice2){
			if (choice.equals("Y") || choice.equals("y")){
				playAgain = true;
				break;
				}
			else if (choice.equals("N") || choice.equals("n")){
				playAgain = false;
				System.out.println("Thanks for playing Hunter-Bear-Ninja!");
				break;
				}
			else 
				System.out.println("Invalid input, please try again.");
			}
		}
	}
}
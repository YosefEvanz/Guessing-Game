//Yosyp Vasyliev
//CS&145
//Lab 1: Guessing Game

import java.util.Random;
import java.util.Scanner;

public class YVGuessingGame {
    private static final int MaxNumber = 100;
    //Maximum constant for a number 
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        introduceGame();
        
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = Integer.MAX_VALUE;
        
        boolean playAgain;
        do {
            int guessesThisGame = playOneGame(console);
            totalGames++;
            totalGuesses += guessesThisGame;
            if (guessesThisGame < bestGame) {
                bestGame = guessesThisGame;
            }//end of if statement

            playAgain = askToPlayAgain(console);
        } while (playAgain);
        
        reportOverallResults(totalGames, totalGuesses, bestGame);
    }//end of main

    // Method that will introduce the game to the user
    public static void introduceGame() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println();
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();
    }//end of the introduction method

    // Plays one game with the user
    public static int playOneGame(Scanner console) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(MaxNumber) + 1;
        int guessCount = 0;
        int userGuess = 0;
        
        System.out.println("I'm thinking of a number between 1 and " + MaxNumber + "...");
        //Displaying a message stating the maximum possible number 
        
        while (userGuess != numberToGuess) {
            System.out.print("Your guess? ");
            userGuess = console.nextInt();
            guessCount++;
            if (userGuess < numberToGuess) {
                System.out.println("It's higher."); //if the number entered by user is lower that the needed number "It's higher" is displayed 
            } else if (userGuess > numberToGuess) {
                System.out.println("It's lower."); //if the number entered by user is lower that the needed number "It's lower" is displayed
            } else {
                System.out.println("You got it right in " + guessCount + " guess" + (guessCount > 1 ? "es" : ""));
                //if the number entered by user is right, the message displays

            }//end of if/else

        }//end of while loop
        
        return guessCount;
    }//end of playOneGame

    // Asks the user if they want to play again
    public static boolean askToPlayAgain(Scanner console) {
        System.out.print("Do you want to play again? ");
        String response = console.next();
        return response.toLowerCase().startsWith("y");
    }//end of askToPlayAgain

    // Reports the overall results to the user in case they don't want to play the game
    private static void reportOverallResults(int totalGames, int totalGuesses, int bestGame) {
        double guessesPerGame = (double) totalGuesses / totalGames;
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("    total games   = " + totalGames);
        System.out.println("    total guesses = " + totalGuesses);
        System.out.printf("    guesses/game  = %.1f%n", guessesPerGame);
        System.out.println("    best game     = " + bestGame);
    }//end of reportOverallResults
}//end of YVGuessingGame
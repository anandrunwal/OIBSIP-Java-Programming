package com.oasis;

import java.util.*;

public class NumberGuessingGame {
	
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------ Welcome to the number game -------------");
        System.out.println("1. Play the Game");
        System.out.println("2. Score Board");
        System.out.println("3. Exit the game");
        System.out.println();
        try {
            System.out.print("Enter your choice :  ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n" + "Range of Numbers : ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n" + "------------------ Bye! --------------------");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.\nCould you please Try again later");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("\nEnter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Guess Lower Number");
            } else if (userGuess < randomNumber) {
                System.out.println("Guess Higher Number");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You Guessed Correct Number in " + guess + " try!");
        } else {
            System.out.println("You Guessed Correct number in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    public void displayScoreBoard() {
    	System.out.println("------------------- Score Board ----------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("Your fastest games today out of all tries is : " + "\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
    
    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }
}
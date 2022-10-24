package com.example.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 */
public final class App {
    public App() {
    }

    private static List<String> words;
    private static String letterChoice;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean bothArraysMatch = false;
    private static char[] foundLettersArray;
    private static Set<Character> notFoundLettersArray = new TreeSet<>();
    private static char[] wordAsCharArray;
    private static int StartingLives = 0;
    private static int livesLeft = 0;
    private static String wordToFind;

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        populateWordsList();
        printPopulatedWordList();
        chooseRandomWordFromPopulatedList();

        setUpLives();

        do {
            displayLivesLeft();
            displayWord(foundLettersArray, true);
            displayGuessSet(notFoundLettersArray);
            String usersLetterGuess = askUserForALetter();
            checkIfLetterIsInWord(usersLetterGuess);

            System.out.println();

            bothArraysMatch = checkIfAllLettersFound(wordAsCharArray, foundLettersArray);

            if (bothArraysMatch) {
                System.out.println("They match, all letters found!!");
                endSuccessGame();
            }

            

        } while (!bothArraysMatch && livesLeft > 0);

        endNotFoundGame();

    } // end of class

    private static void displayGuessSet(Set<Character> setToPrint) {
        if (!setToPrint.isEmpty()) {
            System.out.printf("Letters Chosen %s", setToPrint.toString());
        }
    }

    private static void displayLivesLeft() {
        if (StartingLives != livesLeft) {
            System.out.printf("Lives remaining [%d]\n", livesLeft);
        }
    }

    private static void setUpLives() throws IOException {
        System.out.print("Please enter how many lives you would like ");
        StartingLives = Integer.valueOf(reader.readLine());
        livesLeft = StartingLives;
        System.out.printf("You will play with [%d] lives\n", StartingLives);
    }

    private static void endNotFoundGame() {
        System.out.println("No lives left, you've been hanged");
        System.out.print("You guessed as   ");
        displayWord(foundLettersArray, false);
        System.out.println("GAME OVER MAN, GAME OVER!!!");
        terminateProgram();
    }

    private static void endSuccessGame() {
        System.out.println("Well done you guessed the word");
        System.out.print("Word to find was ");
        displayWord(wordAsCharArray, false);
        System.out.print("You guessed as   ");
        displayWord(foundLettersArray, false);

        System.out.println("\n~~~ GAME OVER ~~~");
        terminateProgram();
    }

    private static void terminateProgram() {
        System.exit(0);
    }

    private static void checkIfLetterIsInWord(String usersLetterGuess) {
        int letterCounter = 0;
        for (char c : wordAsCharArray) {
            if (c == usersLetterGuess.charAt(0)) {
                foundLettersArray[letterCounter] = c;
            } 
            letterCounter++;
        } 
        if (wordToFind.contains(usersLetterGuess) == false) {
            notFoundLettersArray.add(usersLetterGuess.charAt(0));
            livesLeft--;
        }
    }

    private static void displayWord(char[] arrayToDisplay, boolean gameHasNotEnded) {
        if (gameHasNotEnded){ 
        System.out.print("Whats the word?\t");
        }
            for (char c : arrayToDisplay) {
                System.out.print(c + " ");
            }
            System.out.println();
    }

    private static void chooseRandomWordFromPopulatedList() {
        int min = 0;
        int max = words.size();
        int numberChoice = (int) (Math.random() * (max - min));
        // System.out.printf("\n\tword at [%s] is [%s]\n", numberChoice, words.get(numberChoice));
        wordToFind = words.get(numberChoice);

        setUpWordCharArrays(numberChoice);

    }

    private static void setUpWordCharArrays(int numberChoice) {
        // gets random word from list and stores in a char[] array
        wordAsCharArray = words.get(numberChoice).toCharArray();
        System.out.println("Word length is " + wordAsCharArray.length);

        // sets up user guessed letter array
        foundLettersArray = new char[wordAsCharArray.length];
        // populate blank array with underline
        for (int i = 0; i < foundLettersArray.length; i++) {
            foundLettersArray[i] = '_';
        }
    }

    private static void printPopulatedWordList() {
        for (String str : words) {
            // System.out.println("\t" + str);
        }
        System.out.printf("\n\tword list entries is %s\n", words.size());
    }

    private static void populateWordsList() {
        words = Arrays.asList("hello", "horse", "lily", "daddy", "pony", "sylvanian families");
    }

    public static boolean checkIfAllLettersFound(char[] wordAsCharArray, char[] foundLettersArray) {

        return Arrays.equals(wordAsCharArray, foundLettersArray);
    }

    public static String askUserForALetter() throws IOException {

        System.out.print("\nEnter a letter : ");
        letterChoice = reader.readLine();

        if (letterChoice.length() != 1) {
            System.out.print("\nLetter, not letterS!!!!");
            askUserForALetter();
        } else {
            System.out.printf("\n\tYour letter choice was [%s]\n", letterChoice);
        }

        return letterChoice;
    }
}

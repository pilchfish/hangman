// package com.example.hangman;

// public class backup {
    

//     package com.example.hangman;

//     import java.io.BufferedReader;
//     import java.io.IOException;
//     import java.io.InputStreamReader;
//     import java.util.Arrays;
//     import java.util.List;
    
//     /**
//      * Hello world!
//      */
//     public final class App {
//         public App() {
//         }
    
//         /**
//          * Says hello to the world.
//          * 
//          * @param args The arguments of the program.
//          * @throws IOException
//          */
//         public static void main(String[] args) throws IOException {
//             System.out.println("Hello World!");
    
//             // List<String> words = new ArrayList<>();
//             List<String> words = Arrays.asList("hello", "world");
    
//             // words.add("Hello");
//             // words.add("World");
    
//             for (String str : words) {
//                 System.out.println(str);
//             }
    
//             System.out.printf("\n\t word size is %s", words.size());
//             // System.out.printf("\n\tword at [1] is %s", words.get(0) );
//             // System.out.printf("\n\tword at [2] is %s", words.get(1) );
//             System.out.printf("\n\n");
    
//             int min = 0;
//             int max = 2;
//             int numberChoice = (int) (Math.random() * (max - min));
//             // System.out.println( numberChoice );
//             System.out.printf("\n\tword at [%s] is %s", numberChoice, words.get(numberChoice));
    
//             // for (int i = 1 ; i < 20 ; i++) {
//             // int num = (int) (Math.random()*(max)+1);
//             // System.out.println( num );
//             // }
    
//             // read as string
//             InputStreamReader isr = new InputStreamReader(System.in);
//             BufferedReader br = new BufferedReader(isr);
//             // System.out.println("\nEnter a letter :");
//             // String letterChoice = br.readLine();
//             // System.out.printf("\n\tYour letter choice was [%s]\n", letterChoice);
    
//             System.out.println("\nEnter a letter :");
//             String letterChoice = br.readLine();
//             while (letterChoice.length() != 1) {
//                 System.out.println("\nLetter, not letterS!!!!");
//                 System.out.println("\nEnter a letter :");
//                 letterChoice = br.readLine();
//             }
//             System.out.printf("\n\tYour letter choice was [%s]\n", letterChoice);
    
//             boolean wasLetterFoundInWord = false;
//             wasLetterFoundInWord = words.get(numberChoice).contains(letterChoice);
//             System.out.println("Letter was found = " + wasLetterFoundInWord);
    
//             char[] wordAsCharArray = words.get(numberChoice).toCharArray();
    
//             for (char c : wordAsCharArray) {
//                 System.out.printf("Letter [%s]\n", c);
//             }
    
//             System.out.println("Word length is " + wordAsCharArray.length);
//             for (int i = 0; i < wordAsCharArray.length; i++) {
//                 System.out.print("_ ");
//             }
    
//             System.out.println();
    
//             for (char c : wordAsCharArray) {
//                 if (c == letterChoice.charAt(0)) {
//                     System.out.print(c + " ");
//                 } else {
//                     System.out.print("_ ");
//                 }
//             }
    
//             char[] foundLettersArray = new char[wordAsCharArray.length];
//             int counter = 0;
//             for (char c : wordAsCharArray) {
//                 if (c == letterChoice.charAt(0)) {
//                     foundLettersArray[counter] = c;
//                 } else {
//                     foundLettersArray[counter] = '_';
//                 }
//                 counter++;
//                 checkIfAllLettersFound(wordAsCharArray, foundLettersArray);
//             }
    
    
    
            
    
//         } // end of class
    
//         public static boolean checkIfAllLettersFound(char[] wordAsCharArray, char[] foundLettersArray) {
    
//             boolean bothArraysMatch = false;
    
//             for ( int i = 0 ; i < wordAsCharArray.length ; i++) {
//                 if (wordAsCharArray[i] == foundLettersArray[i]) {
//                     bothArraysMatch = true;
//                 }
//                 else {
//                     bothArraysMatch = false;
//                 }
//             }
    
//             System.out.println("Did you find all the letters " + bothArraysMatch);
    
//             return bothArraysMatch;
//         }
    
//         public static void askUserForALetter() throws IOException {
    
//             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
//             System.out.println("\nEnter a letter :");
//             String letterChoice = reader.readLine();
    
//             if (letterChoice.length() != 1) {
//                 System.out.println("\nLetter, not letterS!!!!");
//                 askUserForALetter();
//             } else {
//                 System.out.printf("\n\tYour letter choice was [%s]\n", letterChoice);
//             }
//         }
//     }
    


// }

package com.example;

import java.util.Scanner;

/*
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */

public class TASK1 {
	
    // Function to check if a word, phrase, number, or other sequence of characters is a palindrome
    public static boolean isPalindrome(String input) {
    	
        // Reversing the input string
        String reversedInput = reverseString(input);
        
        // Comparing the reversed input string with the original
        return input.equalsIgnoreCase(reversedInput);
    }

    // Function to reverse a string
    private static String reverseString(String input) {
    	
        // Using StringBuilder to reverse the string
        return new StringBuilder(input).reverse().toString();
    }
    
    // Main Function
    public static void main(String[] args) {
    	
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Asking the user to enter a word, phrase, number, or other sequence of characters
        System.out.print("Digite uma palavra, frase, número, ou uma sequência qualquer de caracteres: ");
        String input = scanner.nextLine();
        
        // Checking if the user input is a palindrome
        boolean isPalindrome = isPalindrome(input);
        
        // Reversing the user input
        String reversedInput = reverseString(input);
        
        // Displaying the reversed user input
        System.out.println("Invertendo: " + reversedInput);
        
        // Displaying the user if the input word, phrase, number, or other sequence of characters is a palindrome or not
        if (isPalindrome) {
            System.out.println("É um palíndromo.");
        } else {
            System.out.println("Não é um palíndromo.");
        }
        
        // Closing the Scanner
        scanner.close();
    }
}

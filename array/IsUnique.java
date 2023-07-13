package com.shubhaga.algo.arrays;

import java.util.Arrays;

public class IsUnique {
    public static void main(String[] args) {
        String inputString = "hi seldom";
        System.out.println(isUniqueCharsBV(inputString));
    }

    /**
     * Checks if the characters in the input string are unique using a bit vector approach.
     *
     * @param inputString The input string to check for uniqueness.
     * @return True if the characters are unique, false otherwise.
     */
    private static boolean isUniqueCharsBV(String inputString) {
        int checker = 0; // Initially set to 0
        for (int i = 0; i < inputString.length(); i++) {
            int val = inputString.charAt(i) ;
            // This ensures each value is represented by only 1 bit, shifting by that many places
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = checker | (1 << val); // This accumulates all the positions in one bit vector
            // For example, 'a' with 0, 'b' with 1, and so on
        }
        return true;
    }

    /**
     * Checks if the characters in the input string are unique using a boolean array approach.
     *
     * @param str The input string to check for uniqueness.
     * @return True if the characters are unique, false otherwise.
     */
    private static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];

        for (int i = 0; i < str.length(); i++) { // Time complexity is O(n)
            int charValue = str.charAt(i);
            if (charSet[charValue]) {
                return false;
            }
            charSet[charValue] = true;
        }
        return true;
    }
}

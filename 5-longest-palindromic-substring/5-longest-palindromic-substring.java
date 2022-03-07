/*

Brute force is to find all the sub strings which will take O(N^2) and to check if it is palindrome O(N). Final O(N^3)

Time complexity : O(n^2) Since expanding a palindrome around its center could take O(n), the overall complexity is O(n^2)

Space complexity : O(1)
*/
class Solution {
    // core logic: with one character and 2 characters as center, find the palindrome for each case, and whenever you encounter the longest palindrome, update it
    // two cases are needed to handle the odd and even cases separately
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1 || s.equals("")) {
            return s;
        }

        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            String temp = palindromeHelper(s, i, i);  // odd length
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            temp = palindromeHelper(s, i, i + 1);  // even length
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        
        return longest;
    }

    // given a string and the CENTER(S) of the palindrome (i and i+1), find the longest possible palindrome
    // from center, go left and right till characters are same and return the longest palindromic substring
    private static String palindromeHelper(String string, int begin, int end) {
        
        while (begin >= 0 && end < string.length() && string.charAt(begin) == string.charAt(end))         {
            begin--;
            end++;
        }
        
        return string.substring(begin + 1, end);
        //begin + 1 because after 0 the begin will be -1 and the substring method begin index is inclusive.
        // we need not do to end + 1 because end will point  to s.length when it reaches end of string and the substring method end index is exclusive.

    }
}
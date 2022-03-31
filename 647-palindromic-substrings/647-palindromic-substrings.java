/*
Start with one letter and two letter strings and expand on both sides.
These are the smallest substrings which can be checked with simple first and last char check and then further checks are built on top of them. 
When you start with single letter strings, the build up for odd length strings and
when you start with two lettered strings they build up for even length strings. 
These are the first and second countSubstrings function calls in the loop.
T/S: O(n²)/O(1). Time & Memory beats 100%, faster than DP and needs no extra space.
*/
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            //count odd length palindrome, 
            //only one center character
            count += countPalindromesAroundCenter(s, i, i);
            
            //count even length palindrome, 
            //two center character
            count += countPalindromesAroundCenter(s, i, i + 1);
        } 
        
        return count;
    }
    
    
    private int  countPalindromesAroundCenter(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length()){
            //just return count, as we found first mismatch
            if(s.charAt(l--) != s.charAt(r++))  return count;
            
            count++;
        }
        return count;
    }
}
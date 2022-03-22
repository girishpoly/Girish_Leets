/*
This is the explanation of the solution:

Create a dictionary to hold the mapping of phone number to digit.
Ex: 2 means "abc", 3 means "def" and so on.
If digits length is zero -> return empty array list
We will go through the digits one by one.
Ex: for "23", first 2, then 3.
We will use a helper function called combine.
combine will take character array of all the letters corresponding to current digit and the result up till now.
We will run 2 loops - outer loop goes through each character in the char array like 'a', 'b', 'c'. and inner loop will go through already present strings in result like "ad", "ae", "af" etc.
Will simply concatenate and store in new array list.
Return result
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)    return new ArrayList<String>();
        
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ArrayList<String> result = new ArrayList<>();
        
   /*
   The string is a number.This code will convert the string into an integer array.
string.charAt(i) will return a character and string.charAt(i)- '0' will return the actual integer value.
For e.g. string="12345",this method will return an integer array [1,2,3,4,5].
   */
        
        for(int i=0; i<digits.length(); i++) {
            result = combine(dict[digits.charAt(i)-'0'].toCharArray(), result);
        }
        
        return result;
    }
    
    public ArrayList<String> combine(char[] toBeAdded, ArrayList<String> result) {
        
        if (result.isEmpty()) {
            for(char tba: toBeAdded)
                result.add(String.valueOf(tba));
            return result;
        }
        
        ArrayList<String> result2 = new ArrayList<String>();
        
        for(String res: result) {
            for(char tba: toBeAdded)
                result2.add(res+String.valueOf(tba));
        }
        
        return result2;
    }
}
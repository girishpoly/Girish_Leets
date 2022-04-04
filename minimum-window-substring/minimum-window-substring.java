/*
Intuition:
Finding a window that has all characters from target and check if the length is min or not. 
The count of characters in t should match with the count of characters in the window in s. 
Since the requirement is to find the min length of the string, so whenever a valid substring is found,
then shrink the window from start and check if a smaller window is available or not.

Algorithm:

Start iterating from the first character in s and try to find a valid window of characters.
Once a valid window is found then increment the start pointer and check if the window is still valid or not.
If valid, then increment start pointer further.
If not valid then increment the end pointer and try to find a valid window again.
Every time a valid window is found check if that is smaller the previously computed small window. If it is smaller then update that as the latest smallest window.
TC : O(S+T)
SC : O(S+T)

 s = "ADOBECODEBANC", t = "ABC"
 
 lets have an array to store the start and end index of string to return minmum string
 
  s    e
  ADOBEC  
  
  we can maintain two hashmaps for s string and t string and insert character with frequency for t string. insert all 0 for s.
  s : A-0, B-0, C-0   t : A-1, B-1, C-1
  
  as we loop throgh the s string check if each character is present in t. if it is present then update frequency in s
  
  s    e
  ADOBEC  at this stage we will have s : A-1, B-1, C-1   t : A-1, B-1, C-1
  lets maintain another variable matched to keep track of how many matched. At this point matched = 3
  
   if(matched == tMap.size()){
    that means a valid window is found, we need to find out if there is a smaller window in the string
    reduce the window by moving the start poniter to the right
    s   e
    DOBEC , since A is removed then update the sMap and the matched variable. matched < tMap.size
    now there is no valid window
   }
   
   store last valid window values with start and end . it will be start - 1 and end
   
   //Now move the end pointer to right to find another valid window
    
    DOBECODEBA - this is not a smaller string than previously found string 
    OBECODEBA
    BECODEBA
    ECODEBA
    CODEBA
    ODEBA - window fails again. Update the sMap values and the matched values
    
    move the next end pointer to find another valid winow and find a smaller string until matched == tMapSize
    ODEBAN
    ODEBANC - valid window
    can we go smaller ?
    DEBANC - wont' overide min length 6 yet
    EBANC - min length 5 found. record start and end
    BANC - length 4 found
    remove B , valid window failed
    moved end - but can't move
    
    stop here and return the sub string with start and end values recorded in the result array 
    
    
    
    
*/
class Solution {
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length() || t.equals(""))
            return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            sMap.put(c, 0);
        }
        
        int start=0, matched=0;
        int minLength = s.length();
        int[] result = new int[]{-1,-1};
		
        for (int end=0; end < s.length(); end++){
            char curr = s.charAt(end);
            
            // Check if current char is present in target, then update character count in source map
            if(tMap.containsKey(curr)){
                sMap.put(curr, sMap.get(curr) + 1);            
                if(sMap.get(curr).equals(tMap.get(curr)))
                    matched++;
            }
            
            // When a valid window is found, try to reduce it until a valid window is not found
            if(matched == tMap.size()){
                // Iterate until the window is not valid
                while(matched == tMap.size()){
                    char first = s.charAt(start++);
                    // If current char is a character in target, 
                    // then reduce its count from the sMap as we'll reduce its count
                    if(sMap.containsKey(first)){
                        sMap.put(first, sMap.get(first) - 1);
                        // If count of first char in window < count in tMap, then reduce the matched count
                        if(sMap.get(first) < tMap.get(first))
                            matched--;
                    }
                }
                // Update length if current length is smaller than previous
                // Note - Check 1 character before start index as the start idx was already incremented in the while loop
                if (end - (start - 1) < minLength){
                    minLength = end - (start - 1) + 1;
                    result[0] = start - 1;
                    result[1] = end;
                }
            }
        }
        return result[0] != -1 ? s.substring(result[0], result[1] + 1) : "";
    }
}
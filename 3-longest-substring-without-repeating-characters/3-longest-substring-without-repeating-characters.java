class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> result = new HashSet<>();
        
        int i = 0 ;
        int j = 0 ;
        int max = 0;
        
        while(j < s.length()){
            
            if(!result.contains(s.charAt(j))){
                result.add(s.charAt(j));
                j++;
                max = Math.max(result.size(),max);
            }
            else{
                result.remove(s.charAt(i));
                i++;
            }  
            
        }
        return max;
    }
}
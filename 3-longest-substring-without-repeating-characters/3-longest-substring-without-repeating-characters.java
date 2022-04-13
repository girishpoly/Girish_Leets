class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //since we want the length, find the longest string without repeating characters.
        //store max and find the max between set.size() and max
        int i=0;//pointer in the beginning
		int j=0;//pointer that will be moving
		int max=0;//max substring length
		HashSet<Character> set=new HashSet<Character>();
		while(j<s.length())
		{
		  if(!set.contains(s.charAt(j)))
		  {
			  set.add(s.charAt(j));//if its unique character add it
			  j++;
			  max=Math.max(set.size(), max);//to keep track of length
		  }
		  else
		  {
			  set.remove(s.charAt(i));
			  i++;
		  }
		}
        return max;
    }
}
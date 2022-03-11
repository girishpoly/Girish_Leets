class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        //2 pointers to track index of word1 and word2
        int word1Index = -1 ;
        int word2Index = -1 ;
        
        //int variable to caculate shortest distance
        int minDistance = Integer.MAX_VALUE;
        
        //loop through all words
        for(int i= 0 ; i< words.length; i++)
        {
            
            if(words[i].equals(word1))
            {
                word1Index = i;
            }
            
            if(words[i].equals(word2))
            {
                word2Index = i;
            }
            //as we loop through all the elements in the array , we can calculate another time 
            //when we encounter the same word. If the difference in index is min then we select that
            if(word1Index != -1 && word2Index != -1)
                minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
           
        }
        
        return minDistance;
    }
}
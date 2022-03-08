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
                //if both words are found  calculate distance
                if(word2Index!=-1)
                {
                    minDistance = Math.min(minDistance,word1Index-word2Index);
                }
                //if recetly word1 is found the next try to find word2
                word2Index=-1;
            }
            
            if(words[i].equals(word2))
            {
                word2Index = i;
                if( word1Index!=-1)
                {
                    minDistance = Math.min(minDistance,word2Index-word1Index);
                }
                //if recetly word2 is found the next try to find word1
                word1Index = -1;
            }
            
           
        }
        
        return minDistance;
    }
}
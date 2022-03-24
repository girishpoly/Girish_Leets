/*
https://medium.com/@ethannam/understanding-the-levenshtein-distance-equation-for-beginners-c4285a5604f0


*/
class Solution {
    public int minDistance(String word1, String word2) {
        /*
         * Construct a 2D-dp array which dp[i][j] means the steps required 
         * for mapping the first is charaters in word1 to  
         * the first js charaters in word2.Note that dp[0][0]=0 for ""="" needs 0 cost
         */
        int word1_length=word1.length();
        int word2_length=word2.length();
        int[][] dp=new int[word1_length+1][word2_length+1];
        // Row initialization
        for (int i=1;i<=word1.length();i++) {
            dp[i][0]=i;
        }                               
        // Column initialization
        for (int j=1;j<=word2.length();j++) {
            dp[0][j]=j;
        }
       /*
        * Dp process: If dp[i]=dp[j], then dp[i][j]=dp[i-1][j-1] since no manipulation is 
        * needed for this. Otherwise, take the minimum cost from deletion, insertion or             
        * replace where replace is just:    
                dp[i][j]=dp[i-1][j-1] + 1, 
        * insert a character to word1 or delete a character from word2 is:   
                dp[i][j]=dp[i][j-1] + 1     (since word1="a", word2="ab" dp[1][2]=dp[1][1]+1)
        * delete a character from word1 or insert a character to word2 is: 
                dp[i][j]=dp[i-1][j] + 1     (since word1="ab", word2="a" dp[1][2]=dp[1][1]+1)
        * Complexity Analysis:
        *
        * Time Complexity: O(mn) for two loops in the 2D array
        * Space Complexity O(mn) for the 2D array
        */
        for (int i = 1; i <= word1_length; i++) {
            for (int j = 1; j <= word2_length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
            }
        return dp[word1_length][word2_length]; 
    }
}
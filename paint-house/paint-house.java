//https://leetcode.com/problems/paint-house/discuss/1787489/JAVA-Multiple-approaches-explained-with-comments



/*
The brute force way is to generate every valid permutation, remove the invalid ones and find the best one.
The time complexity will be exponential. O(2^n)



Using dynamic programming 2D-tabulation dp[N][M] N- Number of Houses M-Number of Colors to choose from

This problem can be solved using dynamic programming in either bottom up or top down approach. Represented bewlow is a top down approach using 2d tabulation. Using btute force approach there would be 2^n possible ways in which you can paint n houses with given m=3 colors as at each index(house) you have 3 options for the first house and 2 options for all other houses.

So it would be 2^n or (m-1)^n where m#colors n#houses in general. if you draw the recursive tree you would see there is a possibility to avoid repeated calculations. As all you would need is to find out what would be the min cost to paint a house h with a given color represented by index 0-m (h,[0-m]).

The base case would be we assume we paint House 0( 0 based indexing) with given 3 possible colors

Time complexity : O(nm^2)
we iterate over each of n.m cells. for each cell we are finding the minimum of the k values in the row above. multiply by O(m). O(nm^2)

Space complexity : O(1) in place
Finding the minimum of two values and adding it to another value is an O(1) operation. We are doing these O(1) operations for 3(n - 1) cells in the grid. Expanding that out,3⋅n−3. The constants don't matter in big-oh notation, so we drop them, leaving us with O(n).

A word of warning: This would not be correct if there were mm colors. For this particular problem we were told there's only 33 colors. However, a logical follow-up question would be to make the code work for any number of colors. In that case, the time complexity would actually be O(n⋅m), because mm is not a constant, whereas 3 is. .

*/
class Solution {
    public int minCost(int[][] costs) {
        
        int H = costs.length; // houses
        int C = costs[0].length; //colors
        
        int[][]dp = new int[H][C];
        
        //base case for topdown approach first first row
        for(int i = 0 ; i < C ; i++) dp[0][i] = costs[0][i];
        
        //for the other H-1 houses
        for(int i = 1 ; i < H ; i++){
            for(int j = 0 ; j < C ; j++){
                //min cost of painting house i with color j 
                int prevCost = getMinCost(dp, j , i -1, C);
                //sum of painting it cost at [i][j] + prev house min cost
                dp[i][j] = prevCost + costs[i][j];
            }
        }
        
        //get the minimum cost by finding the min cost in the last row of dp[H-1]
        int minCost = Integer.MAX_VALUE;
        for(int cost : dp[H-1]){
            minCost = Math.min(cost, minCost);
        }
        
        return minCost;
    }
    
    //get min cost of painting house at prev row excluding curr column
    private int getMinCost(int[][] dp, int currCol, int prevRow, int C){
        int minCost = Integer.MAX_VALUE;
        //iterate prev row other than curr col index and get mininmum cost
        for(int j = 0 ; j < C ; j++){
            if(j != currCol){
                minCost = Math.min(minCost, dp[prevRow][j]);
            }
        }
        return minCost;
    }
}
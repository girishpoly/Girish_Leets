class Solution {
     public int minCostII(int[][] costs) {
        
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
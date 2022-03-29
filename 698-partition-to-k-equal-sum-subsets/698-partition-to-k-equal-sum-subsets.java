/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/1772704/Java-Solution-(with-comments)-oror-100-faster-oror-1ms


Let NN be the number of elements in the array and kk be the number of subsets.

Time complexity: O(k 2^n)

We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it,

Space complexity: O(N)
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Not possible to divide into equal subsets, if sum of all 
        // nums[] is not a multiple of k.
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--)  sum += nums[i];
        if ((sum % k) != 0)  return false;
        
        // Determine the target number that each subset must total.
        // Then start recursion to find if possible to have k equal 
        // subsets.
        int target = sum / k;
        return dfs(k, 0, 0, nums, target);
    }
    
    
    private boolean dfs(int kRemainingToFill, int curSum, int numsIdx, int[] nums, int target) {
        if (kRemainingToFill <= 0)  return true;        // If no more subsets to fill, then done.
        for (int i = numsIdx; i < nums.length; i++) {   // Loop in nums[] values to find next unused.
            if (nums[i] != 0 && curSum + nums[i] <= target) {
                int temp = nums[i];
                nums[i] = 0;                            // Mark this nums value as "used".
                if (curSum + temp == target) {          // If subset exactly filled, start new subset.
                    if (dfs(kRemainingToFill - 1, 0, 0, nums, target))  return true;
                } else {                                // Else subset not filled, find more to fill it.
                    if (dfs(kRemainingToFill, curSum + temp, i + 1, nums, target))  return true;
                }
                nums[i] = temp;                         // This nums[i] value didn't result in a good 
            }                                           //   solution, so "unuse" this nums[] value and  
        }                                               //   loop back to try another nums[] value
        return false;
    }
}
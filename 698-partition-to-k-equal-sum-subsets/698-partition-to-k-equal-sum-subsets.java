/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/1772704/Java-Solution-(with-comments)-oror-100-faster-oror-1ms


Let N be the number of elements in the array and k be the number of subsets.

Time complexity: O(k 2^n)

We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it,

Space complexity: O(N)
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        //calcualte the total of all the nums
        for(int el: nums){
            total+=el;
        }

        //total should be divisible by k inorder to divide the nums array into k subsets
        if(total%k !=0){
            return false;
        }

        //if we have to divide the array than array size return false
        if (nums.length < k) return false;

        //target sum for each subset, in this case it is 5
        int subsetSum = total/k;
        
        boolean[] visited = new boolean[nums.length];
        
        return canPartition(nums, visited, 0, k, 0, subsetSum);

    }

    //add visited later
    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) return true;
        if (curSum > subsetSum) return false;
        if (curSum == subsetSum)  {
            //if currSum becomes equal to subsetSum that means we found one bucket, reduce k
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;
        }

        return false;
    }
}
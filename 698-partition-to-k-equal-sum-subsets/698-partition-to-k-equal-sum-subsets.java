/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/1772704/Java-Solution-(with-comments)-oror-100-faster-oror-1ms
if we sort the nums , it is faster

Let N be the number of elements in the array and k be the number of subsets.

Time complexity: O(k 2^n)

We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it,

Space complexity: O(N)


nums = [4,3,2,3,5,2,1]
tottal = 20 
target = 20/4 = 5

we need to find k subsets in the array that add up to 5

start with 4 and do a scan if we can add any other element in the nums and can reach target sum = 5
if the sum is greater return 
if the sum is less, keep going until we find 1
we found 4 + 1 = 5
we need to mark 4 and 1 as visited so we don't use it again 
reduce k by 1 since we found 1 solution.
after finding the solution reset the curSum and subsetSum

check each time if a number is visited
next time we skip 4 and start with 3 
we found 3 + 2 = 5 
mark both 3 and 2 as visited
k = 2
reset curSum = 0 

skip 4,3,2 and start with 3 
we can find 3 + 2 = 5 
reduce k = 1
reset curSum = 0
so far we have 4,3,2,2,2 as visited

we find 5 equal to subset sum , k = 0 
k == 0 return true we found the solution
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
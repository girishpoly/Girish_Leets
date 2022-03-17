/*
// basic idea is to keep track of current maximum , current minimum and global maximum
//current minimum may result in maximum value too if both the number multiplied are negative

        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1 ; i < nums.length ;i++){
            
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            
        }
        
        return maxSum;
        
Case1 :- All the elements are positive : Then your answer will be product of all the elements in the array.

Case2 :- Array have positive and negative elements both :
If the number of negative elements is even then again your answer will be complete array because on multiplying all the negative numbers it will become positive.
If the number of negative elements is odd then you have to remove just one negative element and for that u need to check your subarrays to get the max product.

Case3 :- Array also contains 0 : Then there will be not much difference...its just that your array will be divided into subarray around that 0. What u have to so is just as soon as your product becomes 0 make it 1 for the next iteration, now u will be searching new subarray and previous max will already be updated.

For each index i keep updating the max and min. We are also keeping min because on multiplying with any negative number your min will become max and max will become min. So for every index i we will take max of (i-th element, prevMax * i-th element, prevMin * i-th element).
*/	

class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0], min = nums[0], ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            int temp = max;  // store the max because before updating min your max will already be updated
            
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            
            if (max > ans) {
                ans = max;
            }
        }
        
        return ans;

    }
}
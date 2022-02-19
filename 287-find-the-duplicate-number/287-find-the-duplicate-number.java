/**
*The idea behind this problem is transforming the values to index (given in the problem range [1, n] inclusive.)
then mark the place by negating it
* Now if there is a duplicate it will also go and try to negate but find it to be already negated that means
we got our duplicate number.
**/

class Solution {
   
    public int findDuplicate(int[] nums) {
    
        int val = 0;
        
        for(int i = 0; i < nums.length; i++) {
            val = Math.abs(nums[i]);
            val--;
            if(nums[val] < 0) {
                return  Math.abs(nums[i]);
            } else {
                nums[val] = -nums[val];
            }
            
        }
        return -1;
    }
}
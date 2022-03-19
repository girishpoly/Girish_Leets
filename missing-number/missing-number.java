class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        
        int sum = (len * (len +1))/2;
        
        int givenSum = 0 ;
        
        for(int i = 0 ; i < len ; i++){
            givenSum = givenSum + nums[i];
        }
        
        return sum - givenSum;
        
    }
}
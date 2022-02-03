class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        
        int leftP = 1;
        int rightP = 1;
        
        for(int i = 0 ; i < nums.length ; i++){
            
            leftProduct[i] = leftP;
            
            leftP = leftP * nums[i];
                
        }
        
        for(int j = nums.length - 1 ; j>=0; j--){
            
            rightProduct[j] = rightP;
            rightP = rightP * nums[j];
            
        }
        
        
        for(int i = 0 ; i < nums.length ; i++){
            leftProduct[i] = leftProduct[i] * rightProduct[i];
        }
        
        return leftProduct;
        
    }
}
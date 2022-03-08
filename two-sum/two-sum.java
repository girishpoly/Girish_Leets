class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums.length == 0){
            return new int[0];
        }
        
        HashMap<Integer, Integer> result = new HashMap<>();
        int[] arr = new int[2];

        for(int i = 0 ; i < nums.length ; i++){
            result.put(nums[i], i);
        }
        
        for(int j = 0 ; j < nums.length ; j++){
            
            int complement = target - nums[j];

            if(result.containsKey(complement) && result.get(complement) != j){
                arr[0] = j;
                arr[1] = result.getOrDefault(target - nums[j], 0);
                return arr;
            }
        }
        
        return new int[0];
        
    }
}
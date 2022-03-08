class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // 'res' will store the indices of the two numbers.
    int[] res = new int[2];
    
    // 'map' will map each value in 'nums' to its respective index.
    HashMap<Integer, Integer> map = new HashMap<>();
    
    // Perform a linear pass of 'nums' to find the solution.
    for (int i=0; i < nums.length; i++) {
        
        // Check if we have already seen the complement of nums[i]
        if (map.containsKey(target - nums[i])) {
            // We have a found a pair of numbers in 'nums' which add up to 'target'.
            
            // Our solution calls of the indices of these numbers.
            // We have the index of nums[i] from i.
            res[0] = i;
            
            // We can look up the index of the complement in 'map'.
            res[1] = map.get(target - nums[i]);
            
            // We have a solution, so no need to look at the rest of 'nums'.
            break;
        } else {
            // We have not seen the complement of this number yet, so let's store it in 'map'
            // and continue looking at the rest of 'nums'.
            map.put(nums[i], i);
        }
    }
    
    // Return the two indices of the numbers which add up to 'target'.
    return res;
        
    }
}
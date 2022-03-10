class Solution {
     public int search(int[] nums, int target) {
         
         //boundary checks
        if(nums == null || nums.length == 0)    return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {          // While we have a valid segment
            
            int mid = left + (right - left) / 2;
            
            if(target == nums[mid])     // CASE-1: Found target :)
                return mid;
            
            
            if(nums[mid] <= nums[right]) {      // CASE-2: Right half is sorted
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;             // Go searching in right sorted half
                else 
                    right = mid - 1;            // Else Go searching in left sorted half
            }
            
            else {                     // CASE-3: Left half is sorted, nums[left] <= nums[mid]
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;            // Go searching in left sorted half
                else
                    left = mid + 1;             // Else Go searching in right sorted half
            }
            
        }
        return -1;                              // target not found
    }
}
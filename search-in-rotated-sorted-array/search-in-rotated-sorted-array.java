/*
    int l = 0 ; r = arr.length-1
    while(l <= r){
        int m = l + (r-1)/2;
        if(arr[m] == target){
            return m;
        }
        
        if(arr[m] < x){
            l = m + 1;
        }
        else{
            r = m -1;
        }
        return -1;
    }
    
    Approach:

The idea here is quite simple and on basic intuition. It's simple Binary Search with a few added conditions.

Generally, if target > nums[mid], we'd know to go to [mid+1, end] but here, it could even lie in [start, mid-1] because we could be on the other side of pivot.

Hence, we do the added checks, to check which range we are currently standing in, i.e.

If nums[start] <= nums[mid] => We are in the first part of pivot.
If nums[start] > nums[mid] => We are in the second part of pivot.
Post deciding which part of pivot we are in, we simply have to check if target lies in current part of pivot or not, and update start/end pointers accordingly.

The code is pretty intuitive, so you should be able to get the hang of it from the code now.

*/
class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l<r){
            
            int mid = l + (r-l)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[l] <= nums[mid]){ //checking if first half array is sorted if so
                if(nums[l] <= target && target < nums[mid]){ //check if target lies in the range if so
                    r = mid - 1;                              // search in first half only
                }else                                         //else search in second half
                    l = mid + 1;
            }
            
            else{  //if first half isn't sorted go and check for second
                if(nums[mid] < target && target <= nums[r]){ //check if target lies in second half
                    l = mid + 1;                             //if so search in second half
                }else{
                    r = mid - 1;
                }
            }
        }
        
        return nums[l] == target ? l : -1;
    }
}
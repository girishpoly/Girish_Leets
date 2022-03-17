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
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l] <= nums[mid]){ //checking if first half array is sorted if so
                if(nums[l] <= target && target < nums[mid]){ //check if target lies in the range if so
                    r = mid - 1;                              // search in first half only
                }else                                         //else search in second half
                    l = mid + 1;
            }else{  //if first half isn't sorted go and check for second
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
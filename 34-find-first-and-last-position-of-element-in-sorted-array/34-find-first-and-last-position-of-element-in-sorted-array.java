/*
int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was
        // not present
        return -1;
    }
     0 1 2 3 4 5
    [5,7,7,8,8,10]
   
   left = 0 , right = 4, mid = 2  
   nums[2] = 7 ,  7 < 8 , nums[mid] < target, hence left = mid + 1
   
   left = 3, right = 4 , mid = 3
   nums[3] = 8, 8 == 8, (searching left most)
   index = mid (first index is 3)
   if(doLeft) right = mid - 1 ;
   else left = mid + 1;
   
   now left = 3 , right = 2
    
    
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start+(end-start)/2;
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        
        while(start<=end){ // first occurance
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        
        start = 0;
        end = nums.length-1;
        mid = start+(end-start)/2;
        while(start<=end){ // second occurance
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                 start=mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        
        return ans;
    }
}
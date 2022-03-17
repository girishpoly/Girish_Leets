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
    
    
    start = 0 , end = 2, mid = 1
    if(a <  f) end = mid - 1 = 0
    
    
*/
//we can use binary search since the array is sorted
class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        
        // The array is considered circular, which means if the ‘target’ is bigger than the last letter of the array or if it is smaller than the first letter of the array, the target’s next letter will be the first letter of the array
        if (target < letters[0] || target > letters[n - 1]) {
            return letters[0];
        }
        
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (target < letters[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // since the loop is running until 'low <= high', at the end of the while loop, 'low == high+1'
        return letters[low % n];
    }
}
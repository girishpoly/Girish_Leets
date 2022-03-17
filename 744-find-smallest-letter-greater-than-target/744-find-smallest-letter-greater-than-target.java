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
    
    
 The idea is to perform a modified binary search to find the next element in the array that is greater than the target. If we find the target in the array, we don't stop, we move to the right half of the array. Since the array is circular, the next greater element of the last element is the first element. Hence we need to find the modulus so that we can have the first element as the result.

Time Complexity: O(log n)
Space Complexity: O(1)
    
    
*/
//we can use binary search since the array is sorted
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo=0, hi=letters.length-1;
        if(target >= letters[hi]) return letters[lo];
        
        while(lo <= hi){
            int mid=lo + (hi-lo)/2;
            if(target >= letters[mid])
                lo = mid + 1;
            else hi = mid - 1;
        }
        return letters[lo];
    }
}
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
*/
//we can use binary search since the array is sorted
//find find possible Ans and loop until the while loop fails
class Solution {
public char nextGreatestLetter(char[] letters, char target) {

    //ascending order = non-decreasing order
    //Concept = ceiling of character using binary search
    //O(logn) - Time complexity
    
    int start = 0;
    int end = letters.length-1;
    
    /*As letters are wrapped around so, if there is no element greater than our target, we             will return the array[0]*/
    if(target >= letters[letters.length - 1])
    {
        return letters[0];
    }
    
    while(start<=end)
    {
        int mid = start+(end-start)/2; 
        /*Here we are declaring mid in this way, so that if start and end have large values,
          (start+end) might cross the limit. So, to play safe, it is better to                             initalise mid in the above way.
        */
        
        if(target<letters[mid])
        {
            end = mid-1;
        }
        else
        {
            start = mid+1;
        }
    }
    
    return letters[start];
}
}
/*
The solutions works in two parts:

it uses merge sort to compare simultaneous values of the two sorted arrays and store them in a new array which has the size rwual to combined sizes of nums1 and nums2
Since the new array is sorted, we need to access the middle elements for the median:
if the array length is odd, the middle element is the median
if the array length is even then the sum of the middle two elements is the median.
*/

class Solution {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
int[] arr = new int[nums1.length+nums2.length];

   int i=0;
    int j=0; 
    int k=0;
    
    while(i<nums1.length && j<nums2.length){
        
        if(nums1[i]<nums2[j])
            arr[k++]=nums1[i++];
        else
            arr[k++] = nums2[j++];
        }
    while(i<nums1.length)
        arr[k++]=nums1[i++];
    while(j<nums2.length)
          arr[k++]=nums2[j++];
         
    // arr is the merge sorted array
     double median = 0;
          
     if(arr.length%2==1)
          median = arr[arr.length/2];
     else 
          median = (double)(arr[arr.length/2-1]+arr[arr.length/2])/2;
          
      return median;    
}
}
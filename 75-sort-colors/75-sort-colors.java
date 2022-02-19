class Solution {
    public void sortColors(int[] nums) {
 
        /*
        We traverse the array and use two variables:

zeroIndex to indicate the index where we should put 0
twoIndex to indicate the index where we should put 2
If current element a[i] is 0, we swap a[i] and a[zeroIndex], if a[i] is 2, we swap a[i] and a[twoIndex], if a[i] is one, we do nothing and continue to process next element.
        */


	int zeroIndex = 0, twoIndex = nums.length - 1, i = 0;
	while( i <= twoIndex ) {
		if( nums[i] == 0 ) 
			swap(nums, zeroIndex++, i++);
		else if( nums[i] == 2)
			swap(nums, twoIndex--, i);    
		else
			i++;
	}}

public void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}
        
}
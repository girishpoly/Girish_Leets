/*
If we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
Loop through each element and maintains a count of the element that has the potential of being the majority element.
If next element is same then increments the count, otherwise decrements the count.
If the count reaches 0 then update the potential index to the current element and reset count to 1.
*/


class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (count == 0)
                ans = num;
            if (num == ans)
                count++;
            else 
                count--;
        }
        return ans;
    }
}
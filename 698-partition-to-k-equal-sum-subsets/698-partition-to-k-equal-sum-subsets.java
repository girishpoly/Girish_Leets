/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/1772704/Java-Solution-(with-comments)-oror-100-faster-oror-1ms


Let NN be the number of elements in the array and kk be the number of subsets.

Time complexity: O(k 2^n)

We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it,

Space complexity: O(N)
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        
        //sum%k must equal to 0 if not just return false
        //if we have to to divide the array greater than array size retun false(we can't)
        if(sum%k!=0 || nums.length<k) return false;
        
        //sort so we can take last element and start filling our bucket
        Arrays.sort(nums);
        
        //our target is sum/k and we have to find this in nums, k times then it is valid
        return canPartitionKSubsets(nums,sum/k,nums.length-1,new int[k]);
    
    }
    public boolean canPartitionKSubsets(int a[],int target,int i,int bucket[]){
        
        //we have taken all the elements
        if(i==-1)
            return true;
        
        //start filling the buckets
        for(int j=0;j<bucket.length;j++){
            
            //can we take this ith element
            if(bucket[j]+a[i]<=target){
            
                //if we take this element
                bucket[j]+=a[i];
                
                //go to next element (in our case go to smallest ele bcz we sorted)
                //if we can fill all buckets then return true
                if(canPartitionKSubsets(a,target,i-1,bucket))
                    return true;
                
                //means we can't fill other buckets if we take ith element so leave this element
                bucket[j]-=a[i];
            
            }
            
            //if our bucket is empty means we have not taken any elements in the buckets
            if(bucket[j]==0)
                break;
        
        }
        
        //all buckets are full but i is pointing to some element (elements still left)
        //or our bucket is empty means we haven't take any element (not valid)
        return false;
    
    }
}
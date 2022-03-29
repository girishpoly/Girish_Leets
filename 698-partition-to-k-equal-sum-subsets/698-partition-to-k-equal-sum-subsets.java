/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/1772704/Java-Solution-(with-comments)-oror-100-faster-oror-1ms


Let NN be the number of elements in the array and kk be the number of subsets.

Time complexity: O(k 2^n)

We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it,

Space complexity: O(N)
*/
class Solution {
    public boolean canPartitionKSubsets(int[] a, int k) {
        int sum=0;
	    for(int i=0;i<a.length;i++){
	        sum+=a[i];  //finding sum of elements
	    }
	    
	    if(k==1) return true;
	    if(k>a.length || sum%k!=0) return false; //if sum is not a multiple of K we can't divide
	    boolean visited[]= new boolean[a.length];  
	    Arrays.fill(visited,false);
	    return findPart(a,visited,sum/k,0,0,k);
    }
     public boolean findPart(int arr[], boolean visited[], int target, int curr_sum, int i, int k){
        if(k==1) return true;
        
        if(curr_sum==target) return findPart(arr, visited, target, 0, 0, k-1);
        
        for(int j=i;j<arr.length;j++){
            if(visited[j] || curr_sum+arr[j]>target) continue;
            visited[j]=true;  //do
            if(findPart(arr, visited, target, curr_sum + arr[j], j+1, k))  //recur
                return true;
            visited[j]=false;  //undo
            
        }
        return false;
    }
}
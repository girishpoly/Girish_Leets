class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //applying two pointer approach
        Set<List<Integer>> res = new HashSet<>();
        int n=nums.length;
        if(n<3)
            return new ArrayList<>(res);
        
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++)
        {
            //Two pointer
            int j=i+1; //first element after current element
            int k=n-1; // last elemnet
            
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k]; //calculating sum
                //Three cases :
                if(sum==0) //we have found a soln
                {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; //for next element
                    k--;
                }
                
                else if(sum<0) 
                    j++;
                else if(sum>0)
                    k--;
            }
        }
        return new ArrayList<>(res);
    }
}
/*
https://leetcode.com/problems/permutations/discuss/1861293/Simple-Java-Solution-With-Full-Explanation-oror-Simple-Recursion-oror-1-ms-faster-than-93.44


*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list; 
        
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums){
        if (temp.size()==nums.length){
            list.add(new ArrayList(temp));//if the the temp list equals nums length then add to resultant list
            }
        
        else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);//Add the current traversing element from nums
                
                backtrack(list, temp, nums);//Backtrack to its previous node by calling backtrack function recursively
                temp.remove(temp.size()-1);//remove the last element of the temp to find another way from the prev node which we got ofter backtracking 
            }
        }
    }
    
}
//same as permutation , just don't allow duplicates
class Solution {
    List<List<Integer>> ml;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //main list to store permutations.
        ml = new ArrayList<>();
        //visited array to mark an element when it is visited.
        boolean[] visited = new boolean[nums.length];
        //Sort the elements.
        Arrays.sort(nums);
        
        findPermutations(nums, new ArrayList<>(), visited);
        
        return ml;
    }
    
    public void findPermutations(int[] nums, List<Integer> cl, boolean[] visited) {
        //When size of child list is equal to length of nums array, meaning a permutation is formed, 
		//so add it in main list.
        if (cl.size() == nums.length) {
            ml.add(new ArrayList<>(cl));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //If the element is visited or it is a duplicate, then continue.
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1]) {
                continue;
            }
            
            //Mark the element visited.
            visited[i] = true;
            //Add it in child list.
            cl.add(nums[i]);
            
            findPermutations(nums, cl, visited);
            
            //Backtracking : Remove the recently added element.
            cl.remove(cl.size() - 1);
            //Mark the element unvisited.
            visited[i] = false;
        }
    }
}
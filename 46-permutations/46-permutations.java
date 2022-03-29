

class Solution {
    // To create all permutations of integers contained in nums array,
    // we realize that for each num, there needs to be a list of integers with this num as the first member in that list.
    // Once we have that, we realize that for each remaining num, there needs to be a list of integers that has this num as the next member in that list.
    // Once we have that, we realize that for each remaining num, we need to do the same as above.
    // The key realization is that we need to have a new copy of the list at each step when we add a num to it.
    //
    // So, we start with an empty list of integers called sublist, and iterate over the given nums,
    // creating a new copy from the sublist and adding the current num to that copy, but only if the current num is not already in the sublist.
    // We keep doing this until the size of the sublist becomes equal to the number of given nums,
    // which means that one permutation is complete, so we add this sublist to the result.
    // When we are done iterating over all the nums, our result will have all the permutations.
    // 
    // You can visualize this with a tree/branching approach, e.g., for nums = [1, 2, 3]
    //                                 start with empty sublist
    //                                        [ ]
    // for each num that's not already in the sublist, create a copy of the sublist and add the num to it
    //              /                          |                             \  
    //            1                            2                              3
    //   new copy of sublist           new copy of sublist             new copy of sublist
    //   add 1 to this copy            add 2 to this copy              add 3 to this copy
    //           [1]                           [2]                             [3]
    // 
    // for each num that's not already in the sublist, create a copy of the sublist and add the num to it
    //    /     |        \              /        |      \                 /      |       \
    //   1      2         3            1         2       3              1        2        3
    //   x     new copy  new copy     new copy   x     new copy      new copy  new copy   x          
    //         add 2     add 3        add 1            add 3         add 1     add 2              
    //         [1,2]     [1,3]        [2,1]            [2,3]         [3,1]     [3,2]                  
    //                                                                                   
    // for each num that's not already in the sublist, create a copy of the sublist and add the num to it
    //         |           |            |               |             |           |              
    //         3           2            3               1             2           1                
    //       new copy    new copy     new copy        new copy      new copy    new copy                
    //       add 3       add 2        add 3           add 1         add 2       add 1                 
    //      [1,2,3]     [1,3,2]      [2,1,3]         [2,3,1]       [3,1,2]     [3,2,1]
    //
    //  if (size of sublist == nums.length), add this sublist to result
    // [    [1,2,3]    [1,3,2]       [2,1,3]         [2,3,1]      [3,1,2]      [3,2,1] ] = result
    // done
    //  
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // start with an empty sublist
        List<Integer> sublist = new ArrayList<Integer>();
        helper(nums, result, sublist);
        return result;
    }
    
    private void helper(int[]nums, List<List<Integer>> result, List<Integer> sublist) {
        // if all nums are in the sublist, add this sublist to the result
        if (sublist.size() == nums.length) {
            result.add(sublist);
			return;
        }

        // for each num, if that num is not in the sublist, create a new copy of sublist and add the num to it
        for (int num : nums) {
            if (!sublist.contains(num)) {
                List<Integer> copy = new ArrayList<>(sublist);
                copy.add(num);
                // pass the new copy of sublist for the next recursion
                helper(nums, result, copy);
            }
        }
    }
    
}
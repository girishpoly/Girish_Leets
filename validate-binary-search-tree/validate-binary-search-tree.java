/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**We have used here the concept that if it a BST then while traversing it in inoder we will get an increasing order array or list whatever you have used in inorder to collect.

Time complexity : \mathcal{O}(N)O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.

Space complexity : \mathcal{O}(N)O(N) for the space on the run-time stack.
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(root,list);
        System.out.println(list);
        for(int i =0;i<list.size()-1;i++){
            if(list.get(i+1)<=list.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> helper(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return new ArrayList<>();
        }
        
       helper(root.left,list);
        
        list.add(root.val);
      helper(root.right,list);
        
        
        return list;
    }
}
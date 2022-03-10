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
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> leaves = null; 
        while(root != null){
              if(root !=null &&  root.left == null && root.right == null){
                leaves = new ArrayList<>(); 
                leaves.add(root.val);
                result.add(leaves);
                break;
            }
            
            leaves = new ArrayList<>(); 
            dfs(root,leaves);
            result.add(leaves);
          
        }
        
        return result;
    }
    public void dfs(TreeNode node, List<Integer> leaves){
        if(node == null) return;
        
        if(node.left != null){
            if(node.left.left == null && node.left.right == null){
                leaves.add(node.left.val);
                node.left = null;
            }else{
                 dfs(node.left,leaves);
            }
        }
        if(node.right != null){
            if(node.right.left == null && node.right.right == null){
                leaves.add(node.right.val);
                node.right = null;
            }else{
                dfs(node.right,leaves);
            }
        }
        
    }
}
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
 
 o(n), space is for recursive calls O(n)
 
 
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        while(root != null){
            List<Integer> tmpList = new ArrayList();
            root = dfs(root, tmpList);
            result.add(tmpList);
        }
        
        return result;
        
    }
    
    private TreeNode dfs(TreeNode node, List<Integer> list){
        
        if(node == null){
            return null;
        }
        
        //leaf node
        if(node.left == null && node.right == null){
            list.add(node.val);
            node = null;
            return node;
        }
        
        //not leaf node
        node.left = dfs(node.left, list);
        node.right = dfs(node.right, list);
        return node;
        
    }
}
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
    List<List<Integer>> ret = new ArrayList();
    public List<List<Integer>> findLeaves(TreeNode root) {
        while(root != null){
            List<Integer> nl = new ArrayList();
            root = helper(root, nl);
            ret.add(nl);
        }
        return ret;
    }
    public TreeNode helper(TreeNode node, List<Integer> nl){
        if(node == null) return node;
        if(node.left == null && node.right == null){
            nl.add(node.val);
            return null;
        }
        node.left = helper(node.left, nl);
        node.right = helper(node.right, nl);
        return node;
    }
}
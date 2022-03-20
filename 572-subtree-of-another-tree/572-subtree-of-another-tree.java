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
 \Time: O(N*M)

 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(s);
        while(!que.isEmpty()) { // bfs
            TreeNode node = que.poll();
            if (this.areSameTrees(node, t)) return true;
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }
        return false;
    }
    
    private boolean areSameTrees(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if ((s == null && t != null) || (s != null && t == null)) return false;
        if (s.val != t.val) return false;
        
        return this.areSameTrees(s.left, t.left) && this.areSameTrees(s.right, t.right);  
    } 
}
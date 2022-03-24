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
 T/S: O(h)/O(1)

 */
class Solution {
    //global
    double min;
    
    public int closestValue(TreeNode root, double target) {
        //base case
        if (root == null) return 0;
        //for minimum distance
        min = Double.MAX_VALUE;
        //start recursive binary search
        search(root, target);
        //result will be here
        return (int)min;
    }
    
    private void search(TreeNode root, double target) {
        //break condition
        if (root == null) return;
        
        //check distance of this node from target
        double distance = Math.abs(root.val - target);
        
        //check if this distance is < min's distance
        if (distance < Math.abs(min - target)) {
            //set new min
            min = root.val;
        }
        
        
        //binary search comparison
        if (target <= root.val) {
            if (root.left != null) search(root.left, target);
        } else {
            if (root.right != null) search(root.right, target);
        }
    }
}
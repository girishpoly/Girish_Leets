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
//Short Java solution involving a postorder visit of the tree. Complexity is O(n).

public class Solution {
    
    int max;
    
    public int maxPathSum(TreeNode root) {
        
        if(root==null) return 0;
        
        //still check the result of the "root subtree"
        max = root.val;
        int tmp = visit(root);
        if(tmp > max) max = tmp;
        
        return max;
        
    }
    
    //recursive visit
    private int visit(TreeNode current){
    
        if(current==null) return 0;
    
        int l = visit(current.left);
        int r = visit(current.right);
        
        if(l<0) l=0;
        if(r<0) r=0;
        
        //check if current subtree is better than max
        int tmp = l+r+current.val;
        if(tmp>max) max = tmp;
        
        //return the best of the two ways to go down
        //if coming from top, cannot go both left and right
        //same if we come from down and want to go up, cannot go down again through other child
        if(l>r) {return l+current.val;}
        else {return r+current.val;}
        
    }
}
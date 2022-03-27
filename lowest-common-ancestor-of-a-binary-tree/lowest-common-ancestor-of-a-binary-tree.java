/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//    Looking at this problem, might seem hard at first. Now to solve it lets consider a node, and breakdown the problem into few cases:
// Case 1: The node we're considering is null, now obviously we won't be able to reach anywhere with null node, so just return null;
// Case 2: if the node we're holding is either p or q, if we have found p, Now this is the case "where we allow a node to be a descendant of itself". this node is the LCA here
// Case 3: Now if the above two cases do not work let's try considering the left and right subtree of this node, here if LeftSubtree(l in the code) returns any of p or q (definitely not null) and right subtree provides returns any of p or q (opposite to left subtree and definitely not null), the node would be the LCA.
// Case 4: when if either of subtree returns a not null value and other provides a null value, our problem reduces to that tree only, hence just return the root of the subtree).

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // Case 1
        if(root == p || root == q) return root; // Case 2
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l!=null && r!=null) return root; // Case 3
        else // Case 4
        {
            if(l!=null) return l;
            else return r;
        }
    }
}
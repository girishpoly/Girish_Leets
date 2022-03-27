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
    /**
        When we turn a simple tree upside down: 
                Root                Left
                /  \                /  \
             Left  Right        Right  Root
        So recursively go to the most left child. Since that will be our new root. And we populate the that child all the way up. So it's visiting root -> root.left -> root.left.left -> root.left.left.left....
        And when its at current root, we make root.left.left = right. root.left.right = root. (We are basically assign left and right child to root.left - new root). Then delete root.left and root.right
           1
          / \   root=2 now            root=1 now
         2   3    ---->      4   1   ------------>   4
        / \                 / \ / \                 / \
       4   5               5   2   3               5   2
            (deleted 2's original 4 and 5)            / \
                                                     3   1(deleted 1's original 2 and 3)
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
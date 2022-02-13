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
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> rightSide = new LinkedList<>();
        // Base condition
        if(root == null)
            return rightSide;
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Adding root to queue and rightSide
        queue.add(root);
        rightSide.add(root.val);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            //Travers the current level
            for(int i=0; i<sz; i++) {
                TreeNode node = queue.remove();
				// IMP: First add right child to queue and then left child
				// For LeftSideView simply add left child first
                if(node.right != null) {
                    queue.add(node.right);                    
                }
                if(node.left != null) {
                    queue.add(node.left);                    
                }
            }
            //After Level traversal, pick the 1st node from nextLevel and add to rightSide
            if(!queue.isEmpty()) {
                rightSide.add(queue.peek().val);
            }
        }
        return rightSide;
    }
}
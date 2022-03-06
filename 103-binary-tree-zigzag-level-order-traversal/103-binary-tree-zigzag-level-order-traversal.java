/*
This is a typical level order traversal with the only difference being that we need to keep track of the direction in which our node values in each level will be returned. If we want a left to right result, we insert values at the end of the list. Otherwise, we insert values at the beginning of the list to achieve a right to left result. For this, we will use a boolean variable to keep track of the direction to traverse.

Time Complexity: O(n)
Space Complexity: O(n)
*/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // initialize an empty result list
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // edge case
        if (root == null) return result;
        
        // boolean variable to keep track of the direction to traverse nodes in a level
        boolean leftToRight = true;
        
        // we'll be doing a BFS traversal
        // so declare an empty queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // we'll use LinkedList here instead of ArrayList
            // since for right to left traversal
            // we will insert node values at the beginning
            // and with LinkedList we won't have to shift elements to the right when we do so
            // which is the case in ArrayList
            List<Integer> currentLevel = new LinkedList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                if (leftToRight) {
                    // add node value to end of list
                    currentLevel.add(currentNode.val);
                } else {
                    // add node value to beginning of list
                    currentLevel.add(0, currentNode.val);
                }
                
                // add the children of the node to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            result.add(currentLevel);
            
            // reverse the direction for next level
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}
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
        
        //initialize empty list to return result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //boundary check
        if(root ==  null) return result;
        
        //boolean variable to keep track of if we are doing left to right or right to left direction
        boolean leftToRight = true;
        
        //we will be doing a BFS, so create an empty queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            //to keep track of nodes in each level
            int levelSize = queue.size();
            
            //normally we would use an ArrayList if we are doing regular BFS level by level. Since we are doing zig zag
            //we should be able to insert nodes at the end and the beginning. So lets use linkedlist
            List<Integer> currentLevel = new LinkedList<>();
            
            for(int i = 0 ; i < levelSize ; i++){
                
                TreeNode currentNode = queue.poll();
                
                //add node to the end of the list for left to right normal 
                if(leftToRight) currentLevel.add(currentNode.val);
                //add node to the beginning of the list
                else currentLevel.add(0, currentNode.val);
                
                //now add left and right children of the current node to the queue
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
                
            }
            //current level is done. add the nodes in the current level to the result list
            result.add(currentLevel);
            
            //reverse the direction
            leftToRight = !leftToRight;
            
        }
        
        
        return result;
    }
}
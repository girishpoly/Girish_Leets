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
 We can use BFS for a binary tree level order traversal. Use a queue data structure. First add root to queue and process each node by pushing
 the node's left and right child to the queue.
 To keep track of the row , we just need to maintain another loop inside while(!queue.isEmpty()). we can capture the queue length which will
 tell us how long the row is .
 Time Complexity: O(N) where N is the number of nodes in the binary tree
 Space Complexity: O(N) for our answer array
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        List<List<Integer>> result = new ArrayList<>();
        
        
        while(!queue.isEmpty()){
            
            int len = queue.size();
            List<Integer> row = new ArrayList<>();
            
            for(int i = 0 ; i < len ; i++){
                
                TreeNode curr = queue.poll();
                if(curr != null){
                    row.add(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                
            }
            
            if(!row.isEmpty())
            result.add(row);
            
        }
        
        
        return result;
    }
}
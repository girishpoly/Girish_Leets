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
 
 When asked to find information about a particular row of a binary tree, the normal thought is to use a breadth-first search (BFS) approach. A BFS approach usually involves the use of a queue data structure (q) so that we deal with the nodes of the tree in the proper order.

The trick is to deal with a single row at a time by making note of the length of the queue (qlen) when we start the row. Once we've processed that many nodes, we know we've just finished the current row and any remaining entries in q are from the next row. This can be accomplished easily with a nested loop.

In this case, processing a node simply means accumulating the running total (ans) for the row and then moving any children of the node onto the end of the queue.

When we start a new row, we can reset ans back to 0, and then just keep processing rows until q is empty. The last value of ans should be our final answer, so we should return ans.
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0, qlen = 0;
        while (q.size() > 0) {
            qlen = q.size();
            ans = 0;
            for (int i = 0; i < qlen; i++) {
                TreeNode curr = q.poll();
                ans += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return ans;
    }
}
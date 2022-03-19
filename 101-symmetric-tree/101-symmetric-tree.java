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
 https://leetcode.com/problems/symmetric-tree/discuss/433170/isMirror-DFS-(Recursion-OneTwo-Stacks)-%2B-BFS-(Queue)-Solution-in-Java
 
 Iteration (BFS)
Compare nodes at each layer.

Each two consecutive nodes in the queue should be equal.
Each time, two nodes are extracted and their values are compared.
Then their right and left children of the two nodes are enqueued in opposite order.
    1
   / \
  2   2     queue: 2    2 (t1)
 / \ / \
3  4 4  3   queue: 4    4    3    3
                           t2.r t1.l
                           
Time: O(N)
Space: O(w) where w is the maximum number nodes in a level of the tree.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
  if (root == null) {
    return true;
  }
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root.left);
  queue.offer(root.right);

  while (queue.size() > 0) {
    TreeNode t1 = queue.poll();
    TreeNode t2 = queue.poll();
    // check
    if (t1 == null && t2 == null) continue;
    if (t1 == null || t2 == null) return false;
    if (t1.val != t2.val) return false;
    // offer children
    queue.offer(t1.left);
    queue.offer(t2.right);

    queue.offer(t1.right);
    queue.offer(t2.left);
  }
  return true;
}
}
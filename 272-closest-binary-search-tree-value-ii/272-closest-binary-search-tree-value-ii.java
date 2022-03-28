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
  O(N) 
  I did the inorder traversal of the BST. 
  The inorder traversal is actually a sorted sequence. 
  While performing traversal, keep adding elements into Queue until it reached size of K.
  When it reached size of K, compare the current value difference to the target to the first element value different to the target. 
  If it is smaller than the first one, poll the first one and add the current one. If it is greater than the first one, terminate the traversal.
 */
public class Solution {
    
private Queue<Integer> results = null;
// private boolean end = false;

public List<Integer> closestKValues(TreeNode root, double target, int k) {
    if (k <= 0) {
        return new ArrayList<Integer>();
    }
    results = new ArrayDeque<>(k);
    // end = false;
    helper(root, target, k);
    return new ArrayList<Integer>(results);
}

public void helper(TreeNode node, double target, int k) {
    //|| end no need of end
    if (node == null ) {
        return;
    }
    
    helper(node.left, target, k);
    if (results.size() < k) {
        results.add(node.val);
    } else {
        int first = results.peek();
        int val = node.val;
        double diff1 = Math.abs(target - (double) first);
        double diff2 = Math.abs(target - (double) val);
        if (diff1 > diff2) {
            results.poll();
            results.add(val);
        } else {
            // end = true;
            return;
        }
    }
    helper(node.right, target, k);
}
}
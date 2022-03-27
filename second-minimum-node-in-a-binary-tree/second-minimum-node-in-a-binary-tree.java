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
 Intuition and approach :- Here, the main point to note is that the minimum value in the whole tree is the root. 
 So, we can maintain a mindiff variable to find the minimum difference between the root.val and cur.val. 
 In other words, we are actually finding the minimum node in the whole tree, excluding the root, which is nothing but the second minimum node of the tree. 
 Thus, we check for every cur.val in the BFS traversal and in the end, we check whether the value of mindiff has changed or not, and return secmin.
 
 Time Complexity:- O(n), where n is number of nodes
Space Complexity:- O(width of tree)
 */
class Solution {
     public int findSecondMinimumValue(TreeNode root)
    {
        int mindiff= Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            for (int i = 0; i < queue.size(); i++)
            {
                TreeNode cur=queue.poll();
                if (cur.val-root.val!=0 && cur.val-root.val<mindiff)
                {
                    secmin= cur.val;
                    mindiff=cur.val-root.val;
                }
                if (cur.left!=null)
                    queue.offer(cur.left);
                if (cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        if (mindiff==Integer.MAX_VALUE)
            return -1;
        else
            return secmin;
    }
}
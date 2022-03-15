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

// Time Complexity: O(n)    (where n -> no. of nodes in the tree)
// Space Complexity: O(h)   (where h -> height of the tree)

List<List<String>> result = new ArrayList<>();
int height;
public List<List<String>> printTree(TreeNode root) {
	// Edge Case Checking
    if(root == null)
        return result;
    
	// get the height of the tree --> calculate m(rows) and n(cols) for the matrix
    int m = getHeight(root);
    height = m - 1;      // we subtract -1 because the getHeight() function takes the root node at height 1
    int n = (int)Math.pow(2, m) - 1;
    
    // populate the result matrix with all empty strings
    for(int i = 0; i < m; i++){
        List<String> row = new ArrayList<>();
        for(int j = 0; j < n; j++){
            row.add("");
        }
        result.add(row);
    }
    
    // populate the result matrix
    populate(root, 0, (n-1)/2);
    
    return result;
}

// function to calcuate the maxHeight of the tree
private int getHeight(TreeNode root){
    if(root == null)
        return 0;
		
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    
    return 1 + Math.max(left, right);
}

// function to populate the result matrix
private void populate(TreeNode root, int row, int col){
	// edge case checking
    if(root == null)
        return;
    
    // put the root value at correct position
    result.get(row).set(col, String.valueOf(root.val));
    
	// get the correct left column in the matrix --> for the left child value
    int leftPos = col - (int)Math.pow(2, (height-row-1));
    populate(root.left, row+1, leftPos);
    
	// get the correct right column in the matrix --> for the right child value
    int rightPos = col + (int)Math.pow(2, (height-row-1));
    populate(root.right, row+1, rightPos);
}
}
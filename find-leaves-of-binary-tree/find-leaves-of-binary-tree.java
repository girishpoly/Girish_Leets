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
 
 o(n), space is for recursive calls O(n)
 
 Do a DFS to go all the way to the leaf nodes. IF it is a leaf node meaning , if left node and right node are null then it is a leaf node.
 all leaf nodes to templist and add templist to result for every iteration.
 once the leaf node is processed mark it as null.
 
 DFS - go through entire depth of the tree , remove leaf nodes and backtrack
 
 at every iteration mark the leaves as null so we don't process them again. 
 
     1
  2     3
  
4   5

res : []
root = 1 tempList: []
node = 1

     1                   
  2     3        
  
4   5
 
res : []
root = 1 tempList: [4]
node = 1
mark 4 as null

     1                   
  2     3        
  
n   n

res : []
root = 1 tempList: [4,5]
node = 1
mark 5 as null

     1                   
  2     n        
  
n   n

res : []
root = 1 tempList: [4,5,3]
node = 1
mark 3 as null

     1                   
  2     n        
  
n   n

res : [[4,5,3],]
root = 1 tempList: [4,5,3]
node = 1
mark 3 as null


again recursivley call DFS with node as 1

     1                   
  2n     n        
  
n   n

res : [[4,5,3], [2]]
root = 1 tempList: [2]
node = 1

2 is leaf node , mark it as null and return back to 1


     1                   
  n     n        
  
n   n

res : [[4,5,3], [2] , [1]]
root = 1 tempList: [1]
node = 1

1 is only leaf node , mark it as null


     n                  
  n     n        
  
n   n
res : [[4,5,3], [2] , [1]]

root becomes null and exits while loop
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        while(root != null){
            List<Integer> tmpList = new ArrayList();
            //create a tmpList for each iteration and pass it to our helper method so it gets filled with the leaf nodes
            //for every iteration
            root = dfs(root, tmpList);
            result.add(tmpList);
        }
        
        return result;
        
    }
    
    
    private TreeNode dfs(TreeNode node, List<Integer> list){
        
        if(node == null){
            return null;
        }
        
        //leaf node
        if(node.left == null && node.right == null){
            list.add(node.val);
            node = null;
            return node;
        }
        
        //not leaf node
        node.left = dfs(node.left, list);
        node.right = dfs(node.right, list);
        return node;
        
    }
}
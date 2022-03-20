/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 The intuition in this question is to think the tree to be a directed graph where the parent is pointing to it's children.
We need to convert this directed graph to an undirected graph and perform BFS on this undirected graph.
For making the tree as undirected graph we would want an edge from a node to it's parent-> We achieve this with the help of auxiliary memory in the form of Map<TreeNode, TreeNode> parent.
After the conversion to an undirected graph-> we perform a standard BFS.
 */

 public List<Integer> distanceK(TreeNode root, TreeNode target, int K) { //O(n)
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        
        //hashmap to store child-parent pair
        HashMap<TreeNode, TreeNode> parent=new HashMap<>();
        getParents(root, parent);
       
        
        //to keep a track of visited nodes.
        //this is needed because there can be nodes visited more than once
        //considering we are performing BFS on chhildrens and parent both
        Set<TreeNode> visited=new HashSet<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                
                //if removed node is null or is already visited
                if (node == null || visited.contains(node)) continue;
                
                //mark the node as visited
                visited.add(node);
                
                //add nodes when level is 'K' starting from 'start' node
                if(level==K){
                    ans.add(node.val);
                }
                    q.add(node.left);
                    q.add(node.right);
                    q.add(parent.get(node));
                
                }
                level++;
            }
        return ans;
    }
    
    //func to compute the parent of the nodes recursively
    public void getParents(TreeNode root, HashMap<TreeNode, TreeNode> parent){ //O(n)
        if(root==null)return;
        
        if(root.left!=null)parent.put(root.left, root);
        if(root.right!=null)parent.put(root.right, root);
        getParents(root.left, parent);
        getParents(root.right, parent);
    }
}
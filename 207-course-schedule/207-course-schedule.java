class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses]; // indeg array
        List<List<Integer>> adj = new ArrayList<>(); // grap adjacency matrix
        createGraph(adj,indeg, prerequisites); // create graph from given prereq.
        return bfs(adj, indeg); // do bfs
    }
    
    boolean bfs(List<List<Integer>> adj, int[] indeg) {
        Queue<Integer> q = new LinkedList<>(); // add only those with 0 indegree
		// because 0 indeg means no prerequired course to be done for that
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i); // add to queue
            }
        }
        int count = 0; // count 
        while (!q.isEmpty()) {
            int u = q.poll(); 
            for (int i : adj.get(u)) {
                if (--indeg[i] == 0) { // traverse every node connected with 0 indegree
                    q.offer(i);// add to q iff indegree becomes 0
                }
            }
            count++;
        }
        return count == indeg.length; 
    }
    
    void createGraph(List<List<Integer>> adj, int []indeg, int[][] g) {
        for (int i = 0; i < indeg.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < g.length; i++) {
		// add every source to destination in graph
		// for every destination, increment indegree count by 1
            adj.get(g[i][1]).add(g[i][0]);
            indeg[g[i][0]]++;
        }
    }
    
}
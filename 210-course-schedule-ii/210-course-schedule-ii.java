class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int []indeg = new int[numCourses]; // array to maintain indegee count
        List<List<Integer>> adj = new ArrayList<>(); 
        computeIndegreeAndAjacencyList(indeg, prerequisites, adj); // compute indegree and adjaceny matrix for graphical representation
        return bfsScheduler(adj, indeg); // generate order  based on topological sort(BFS, Kahns algo for DAG topological sort)
    }
    
    private void computeIndegreeAndAjacencyList(int indeg[], int [][]g, List<List<Integer>> adj) {
        int n = indeg.length;
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : g) {
            indeg[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
    }
    
    
    private int[] bfsScheduler(List<List<Integer>> adj, int[] indeg) {
        int[] res = new int[indeg.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) { // add only edges which have zero indegree i.e. traverse first without any node coming to them but might be going from them
                q.offer(i); 
            }
        }
        int index = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll(); 
            res[index++] = u;
            for (int i : adj.get(u)) {
                if (--indeg[i] == 0) {
                    q.offer(i);
                }
            }
            count++;
        }
        
        return count == indeg.length ? res : new int[0]; 
    }
}
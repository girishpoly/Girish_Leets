class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list
        ArrayList<List<Integer>> adlist = new ArrayList<List<Integer>>(numCourses);
        // incoming edge count of each node
        int[] edgeCount = new int[numCourses];
        
        // initialize adj list
        for(int i = 0; i < numCourses; i++){
            LinkedList<Integer> list = new LinkedList<Integer>();
            adlist.add(list);
        }
        
        // process into adj list and count incoming edges
        for(int[] relation : prerequisites){
            edgeCount[relation[0]]++;
            adlist.get(relation[1]).add(relation[0]);
        }
        
        // prepare queue for topological sorting BFS
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < edgeCount.length; i++){
            if(edgeCount[i] == 0)
                q.add(i);
        }
        
        // start BFS. if finish, the edge count should now be 0. otherwise, there are still nodes left because of cycle
        int totalEdges = prerequisites.length;
        while(!q.isEmpty()){
            int prereq = q.poll();
            for(int course : adlist.get(prereq)){
                edgeCount[course]--;
                if(edgeCount[course] == 0)
                    q.add(course);
                totalEdges--;
            }
        }
        
        return totalEdges == 0; 
    }
    
}
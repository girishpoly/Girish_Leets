class Solution {
    
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    // Algorithm:
    // - Perform BFS to find the number of connected components 
    // - Number of connected components would give us the number of provinces
    
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0)
            return 0;
        
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    
    public void bfs(int[][] isConnected, int i, boolean[] visited) {
        
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            int index = queue.poll();
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[index][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
                    
            }
        }
    }
}
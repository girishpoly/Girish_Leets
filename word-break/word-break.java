// BFS
// Time Complexity: O(n^2) quadratic time
// Space Complexity: O(n) linear space
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {        
        Set<String> dict = new HashSet<>(wordDict);
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.offer(0);
        
        while(!q.isEmpty()) {
            int start = q.poll();
            
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {  
                        if (end == s.length()) return true;
                        
                        q.offer(end);
                    }
                }
                
                visited[start] = true;
            }
        }
        
        return false;
    }
}
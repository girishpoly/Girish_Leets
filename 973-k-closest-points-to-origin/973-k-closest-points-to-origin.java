class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        if(points.length == 0){
            return points;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < points.length ; i++){
            
            int[] p = points[i];
            
            int len = p[0]*p[0]+p[1]*p[1];
            
            map.put(i, len);
            
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,
            (s1, s2) -> map.get(s1) - map.get(s2));
        
        
        for(int p : map.keySet()){
            pq.add(p);
        }
        
        int[][] result = new int[k][2];
        
        for(int j = 0 ; j < k ; j++){
            
            int index = pq.poll();
            result[j] = points[index];
            
        }
        
        return result;
        
    }
}
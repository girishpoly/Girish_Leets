class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      
        if(nums.length == k){
            return nums;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        int[] result = new int[k];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, 
                                                       (a,b) -> map.get(b) - map.get(a));
        
        for(int l : map.keySet()){
            pq.add(l);
        }
        
        for(int j = k - 1 ; j >=0 ; --j){
            result[j] = pq.poll();
        }
        
        return result;
    }
}
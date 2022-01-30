class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        
        HashMap<Integer, Integer> result = new HashMap<>();
        
        for(int i : nums){
            
            result.put(i, result.getOrDefault(i,0)+1);
            
        }
        
        
        PriorityQueue<Integer> q = new PriorityQueue<>(k,
        (s1, s2) -> result.get(s2) - result.get(s1));
        
        for(int n : result.keySet()){
            q.add(n);
        }
        
        int[] top = new int[k];
        for(int i = k - 1 ; i >=0; --i){
            top[i] = q.poll();
        }
        
        return top;
    }

}
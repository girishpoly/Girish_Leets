/*
Maintain a hashmap to keep a count of number and its frequency. Since we want as minimum number of Unique integers as possible, we will remove the numbers whose frequency is very less. We can use a min heap to sort the map entry based on frequency.
Once we remove an entry from the heap we decrease its frequency from k. Keep removing elements until k becomes 0
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        if(arr==null || arr.length==0)
            return 0;
        
		// base case as it will remove all elements
        if(k>= arr.length)
            return 0;
        
        HashMap<Integer,Integer> h = new HashMap<>();
        
		//Hash map to maintain frequency of each element
        for(int i=0;i<arr.length;i++)
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
               
		// add all map entries into the priority queue
        for(Map.Entry<Integer,Integer> entry: h.entrySet())
            pq.offer(entry);
           
		  // keep removing the minimum frequency element until k becmoes 0
        while(k>0)
        {
            Map.Entry<Integer,Integer> entry = pq.poll();
            if(entry.getValue()>k)
            {
                entry.setValue(entry.getValue()-k);
                k= entry.getValue()-k;
                pq.offer(entry);
            }
            else{
                k = k - entry.getValue();
            }
            
        }           
        return pq.size();        
    }
}
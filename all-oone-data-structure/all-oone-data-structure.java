/*
can be done using hashmap and priority queue by maintaing max heap and min heap. But it won't be O(1).
https://leetcode.com/problems/all-oone-data-structure/discuss/1096482/JAVA-Hashmap-%2B-Heap-(min-and-max-pq)

https://leetcode.com/problems/all-oone-data-structure/discuss/564660/Faster-than-66-TreeMap-and-HashMap-JAVA

*/
class AllOne {
    class Entry{
        int count;
        String key;
        public Entry(String key){
            this.key = key;
            count = 1;
        }
    }
    
    HashMap<String, Entry> entries; 
    PriorityQueue<Entry> maxHeap;
    PriorityQueue<Entry> minHeap;

    /** Initialize your data structure here. */
    public AllOne() {
        entries = new HashMap();
        maxHeap = new PriorityQueue(new Comparator<Entry>() {
            public int compare(Entry a, Entry b) {
                return Integer.compare(b.count, a.count);
            }
        });
        minHeap = new PriorityQueue(new Comparator<Entry>() {
            public int compare(Entry a, Entry b) {
                return Integer.compare(a.count, b.count);
            }
        });
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Entry e;
        if(entries.containsKey(key)){
            e = entries.get(key);
            e.count++;
            maxHeap.remove(e);
            minHeap.remove(e);
        }    
        else{
            e = new Entry(key);
            entries.put(key, e);
        }
        minHeap.add(e);
        maxHeap.add(e);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Entry e;
        if(entries.containsKey(key)){
            e = entries.get(key);
            e.count--;
            maxHeap.remove(e);
            minHeap.remove(e);
            if(e.count==0){
                entries.remove(e);    
            }
            else{
                minHeap.add(e);
                maxHeap.add(e);   
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(maxHeap.size()==0) return "";
        else return maxHeap.peek().key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(minHeap.size()==0) return "";
        else return minHeap.peek().key;    
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
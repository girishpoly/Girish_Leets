class AllOne {
    
    private final Map<String, Integer> keyToCount = new HashMap<>();
    private final TreeMap<Integer, Set<String>> countToKey = new TreeMap<>();

    public AllOne() {
    }
    
    public void inc(String key) {
        var count = keyToCount.merge(key, 1, Integer::sum);
        moveWord(count, count - 1, key);
    }
    
    public void dec(String key) {
        var count = keyToCount.merge(key, -1, Integer::sum);
        if (count == 0)
            keyToCount.remove(key);
        
        moveWord(count, count + 1, key);
    }
    
    public String getMaxKey() {
        return countToKey.isEmpty() ? "" : countToKey.lastEntry().getValue().iterator().next();
    }
    
    public String getMinKey() {
        return countToKey.isEmpty() ? "" : countToKey.firstEntry().getValue().iterator().next();
    }
    
    private void moveWord(int nextCount, int prevCount, String key) {
        if (nextCount != 0)
            countToKey.computeIfAbsent(nextCount, v -> new HashSet<>()).add(key);

        if (prevCount != 0) {
            var keys = countToKey.get(prevCount);
            if (keys.size() == 1)
                countToKey.remove(prevCount);
            else
                keys.remove(key);
        }
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
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String s : banned) {
            set.add(s); 
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
                // 2). split the string into words

        String[] strs =  paragraph.replaceAll("[^a-zA-Z0-9 ]", "              ").toLowerCase().split("\\s+");
        int max = 0;
        String res = "";

                // 3). count the appearance of each word, excluding the banned words

        for(String str : strs) {
            if(!set.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        
                // 4). return the word with the highest frequency
        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        
        return res;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        HashMap<String, List> map = new HashMap<>();
        
        for(String str : strs){
            
            String sortedStr = sortString(str);
            
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList());
            }
            
            map.get(sortedStr).add(str);
            
        }
        
        
        return new ArrayList(map.values());
        
    }
    
    public String sortString(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);   
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result =new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
		
        for(int i=0;i<strs.length;i++){
            String s=sortStr(strs[i]);// sort the string |  every anagram will return same string
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<String>()); // psuh that sorted string as key 
            }
            map.get(s).add(strs[i]);// add in the list  
        }
        for(List<String> list : map.values()){
            result.add(list);
        }
        return result;
    }
    public String sortStr(String s){
        char c[]=s.toCharArray();
        Arrays.sort(c);
        String s1=new String(c);
        return s1;
    }
    
}
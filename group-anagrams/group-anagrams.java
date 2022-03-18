/*
Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.

Space Complexity: O(NK), the total information content stored in ans.
*/
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
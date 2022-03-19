class Solution {
   public int firstUniqChar(String s){
    
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    
    int strLen = s.length();
    
    for(int i =0;i<strLen;i++){
        if(!map.containsKey(s.charAt(i))){
            map.put(s.charAt(i), 1);
        }else{
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
    }
    int res = -1;
    for(int i = 0;i<strLen;i++){
        if(map.get(s.charAt(i)) == 1){
            return i;
        }
    }
    
    return res;
}
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0){
            return "";
        }
        
        if(strs.length == 1){
            return strs[0];
        }
        
        String temp = strs[0];
        
        for(int i=1; i<strs.length ;i++){
            
            while(strs[i].indexOf(temp) != 0){
                temp = temp.substring(0, temp.length() - 1);
                if(temp.isEmpty()){
                    return "";
                }
            }
            
        }
        
        return temp;
        
    }
}
class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split("\\s");
        
        StringBuilder sb = new StringBuilder();
        
        for(String t: words){
            
            sb.append(new StringBuffer(t).reverse().toString() + " ");
            
        }
        
        return sb.toString().trim();
        
    }
}
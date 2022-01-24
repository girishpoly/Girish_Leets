class Solution {
    public boolean isValid(String s) {
        
        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        
        Stack<Character> st = new Stack<>();
        boolean valid = true;
        
        for(Character c : s.toCharArray()){
            
            if(c == '(' || c == '[' || c == '{'){
                st.add(c);
            }
            
            
            if(c == ')'){
             
                if(st.isEmpty() || st.pop() != '(') return false; 
                
            }
            
            else if(c == ']'){
                if(st.isEmpty() || st.pop() != '[') return false; 
            }
            
            else if(c == '}'){
                if(st.isEmpty() || st.pop() != '{') return false; 
            }
            
        }
        
        
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
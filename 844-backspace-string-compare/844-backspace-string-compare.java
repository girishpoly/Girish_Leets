class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        String sNew = clean(s);
        String tNew = clean(t);
        
        return sNew.equals(tNew);
    }
    
    public String clean(String str){
        
        Stack<Character> stack = new Stack<>();
        
        for(Character c : str.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        
        
        return stack.toString();
    }
}
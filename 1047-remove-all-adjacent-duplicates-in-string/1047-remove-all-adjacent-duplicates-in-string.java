class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> result = new Stack<Character>();
        
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            
                
                if(!result.isEmpty() && result.peek() == c){
                    result.pop();
                } else{
                    result.add(c);
                }
            
        }
        
        for(int i = result.size(); i > 0 ; i--){
            sb.append(result.pop());
            
        }
        
      return  sb.reverse().toString();
        
    }
}
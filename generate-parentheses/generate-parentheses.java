class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        //answer list to store generated valid parenthesis.
        ans = new ArrayList<>();
        //Initially, open and close brackets are 0.
        generateParenthesisHelper(new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    public void generateParenthesisHelper(StringBuilder sb, int open, int close, int max) {
        //Base Case : When length of sb is equal to (max * 2), then add it in the answer list and return. 
		//As pair of parenthesis will generate String of size (max * 2).
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }
        
        //If open is less than max, then we will add "(" and increase open.
        if (open < max) {
            //Add "(" in StringBuilder.
            sb.append("(");
            generateParenthesisHelper(sb, open + 1, close, max);
            //Backtracking : Remove the recently added parenthesis.
            sb.deleteCharAt(sb.length() - 1);
        }
        //If close is less than open, then only add ")" and increase close. 
		//This ensures that only valid pair of parenthesis are generated.
        if (close < open) {
            //Add ")" in StringBuilder.
            sb.append(")");
            generateParenthesisHelper(sb, open, close + 1, max);
            //Backtracking : Remove the recently added parenthesis.
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
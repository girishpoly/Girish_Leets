class Solution {
   public int evalRPN(String[] tokens) {
    
       /*
       So we can use a stack here to store numbers until they're used, 
       and then each operand will use the top two values of the stack.

       Since the order of the numbers is still important for subtraction and division, 
       we'll have to make sure that the two numbers are processed in their original order, 
       which is the opposite order of the stack.

       After each successful operation, the result should be pushed back onto the stack until it's used. 
       After iteration is complete, the remaining value in the stack will be our answer, so we should return stack[0].
       */
       Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

       Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (!ops.contains(t)) stack.push(Integer.parseInt(t));
            else {
                int b = stack.pop(), a = stack.pop();
                if (t.equals("+")) stack.push(a + b);
                else if (t.equals("-")) stack.push(a - b);
                else if (t.equals("*")) stack.push(a * b);
                else stack.push(a / b);
            }
        }
        return stack.pop();
}
}
class Solution {
   public int evalRPN(String[] a) {
       
             /*
       So we can use a stack here to store numbers until they're used, 
       and then each operand will use the top two values of the stack.

       Since the order of the numbers is still important for subtraction and division, 
       we'll have to make sure that the two numbers are processed in their original order, 
       which is the opposite order of the stack.

       After each successful operation, the result should be pushed back onto the stack until it's used. 
       After iteration is complete, the remaining value in the stack will be our answer, so we should return stack[0].
       */
       
       
  Stack<Integer> stack = new Stack<Integer>();
  
  for (int i = 0; i < a.length; i++) {
    switch (a[i]) {
      case "+":
        stack.push(stack.pop() + stack.pop());
        break;
          
      case "-":
        stack.push(-stack.pop() + stack.pop());
        break;
          
      case "*":
        stack.push(stack.pop() * stack.pop());
        break;

      case "/":
        int n1 = stack.pop(), n2 = stack.pop();
        stack.push(n2 / n1);
        break;
          
      default:
        stack.push(Integer.parseInt(a[i]));
    }
  }
  
  return stack.pop();
}
}
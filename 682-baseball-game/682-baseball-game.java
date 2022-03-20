class Solution {
    public int calPoints(String[] ops) {
        if(ops.length ==0 || ops ==null)         // returning 0 if ops is null or empty
            return 0;
        Stack<Integer> stack = new Stack();        
        for(int i = 0; i<ops.length; i++) {            
            if(ops[i].equals("D")) {                     //if "D" is encountered while traversing the string we push into stack 2*stack.peek() element.
                stack.push(2*stack.peek());
            }
            else if(ops[i].equals("C")) {  //If "C" is encountered simply pop the element. No need to check for empty stack(its already handled as stated in the question).
                stack.pop();
            }
            else if(ops[i].equals("+")) {       //The tricky part in my solution. if "+" is encountered in the ops array we pop out two elements add their sum and then again push the popped items one by one with thier sum.(Again no need to handle the empty case of stack already stated in the question).
                int sum = 0;
                int s1 = stack.pop();
                int s2 = stack.pop();
                sum = s1+s2;
                stack.push(s2);
                stack.push(s1);
                stack.push(sum);
            }
            else {
                stack.push(Integer.parseInt(ops[i]));                 // if the ith element is digit simply push it in the stack.
            }
        }
        int sumOfStack = 0;
        while(!stack.isEmpty()) {
            sumOfStack+=stack.pop();                                //Finally pop all the items and return their sum
        }
        return sumOfStack;
    }
}
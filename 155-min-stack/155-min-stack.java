class MinStack {
    
    private Stack<Integer> val_stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        val_stack.push(val);
        if (min_stack.empty()) {
            min_stack.push(val);
        } else {
            min_stack.push(Math.min(min_stack.peek(), val));
        }
    }
    
    public void pop() {
        val_stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return val_stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
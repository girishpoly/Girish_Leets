class MaxStack {
    List<Integer> list;
    int max;
    int indexMax;
    public MaxStack() {
        list = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(list.size(),x);
    }
    
    public int pop() {
        return list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    public int peekMax() {
        max = Integer.MIN_VALUE;
        int count;
		//in case there are multiple max value elements we have to return the comparatively the top one hence iterate from last element to first
        for(count = list.size()-1; count >=0; count--)
        {
            if(list.get(count) > max)
            {
                max = list.get(count);
                indexMax = count;
            }
        }
        return max;
    }
    
    public int popMax() {
        peekMax();
        return list.remove(indexMax);
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
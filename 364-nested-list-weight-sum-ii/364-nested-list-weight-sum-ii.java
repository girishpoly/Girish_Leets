/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> q = new LinkedList<List<NestedInteger>>();
        q.add(nestedList);
        Stack<Integer> stack = new Stack<Integer>();
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i ++) {
                List<NestedInteger> node = q.poll();
                for (NestedInteger ni:node) {
                    if (ni.isInteger()) {
                        sum += ni.getInteger();
                    }
                    else {
                        q.add(ni.getList());
                    }
                }
            }
            stack.push(sum);
        }
        int level = 1;
        int res = 0;
        while (!stack.isEmpty()) {
            res += level * stack.pop();
            level ++;
        }
        return res;
    }
}
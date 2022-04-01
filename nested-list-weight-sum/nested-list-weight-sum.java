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
 
 Time complexity : O(N).

Similar to the BFS approach. Each nested element is put on the queue and removed from the queue exactly once.

Space complexity : O(N).

The worst-case for space complexity O(N).

Doing BFS on  [1,1],2,[1,1] will first give 2, [1,1], 1, 1
we loop 3 times initial queue size.
second time total = 2 * 1 = 2 1 is depth
2 is polled

now bfs again on [1,1], 1,1 => 1,1,1,1
depth = 2 
total = 2 + 8 = 10

queue = [1,1],2,[1,1]

if integer add to total or else add list elements to end of queue

queue = 2, [1,1], 1 ,1

total = 2

queue = 1,1,1,1
total = 2
end of first queue iteration since initial size was 3.

but queue is still not empty. 
increment depth

total = 2 + 2 * 1 + 2 *1 + 2*1+2*1 = 10
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
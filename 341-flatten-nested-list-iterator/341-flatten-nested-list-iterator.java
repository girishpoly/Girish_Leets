/**

In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it returns the very first element. Second, in the hasNext() function, we peek the first element in stack currently, and if it is an Integer, we will return true and pop the element. If it is a list, we will further flatten it. This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.

 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 
 
 Time complexity.

Constructor: O(N + L)O(N+L).

The worst-case occurs when the initial input nestedList consists entirely of integers and empty lists (everything is in the top-level). In this case, every item is reversed and stored, giving a total time complexity of O(N + L)O(N+L).

makeStackTopAnInteger(): O(\dfrac{L}{N})O( 
N
L
​
 ) or O(1)O(1).

If the top of the stack is an integer, then this function does nothing; taking O(1)O(1) time.

Otherwise, it needs to process the stack until an integer is on top. The best way of analyzing the time complexity is to look at the total cost across all calls to makeStackTopAnInteger() and then divide by the number of calls made. Once the iterator is exhausted makeStackTopAnInteger() must have seen every integer at least once, costing O(N)O(N) time. Additionally, it has seen every list (except the first) on the stack at least once also, so this costs O(L)O(L) time. Adding these together, we get O(N + L)O(N+L) time.

The amortized time of a single makeStackTopAnInteger is the total cost, O(N + L)O(N+L), divided by the number of times it's called. In order to get all integers, we need to have called it NN times. This gives us an amortized time complexity of \dfrac{O(N + L)}{N} = O(\dfrac{N}{N} + \dfrac{L}{N}) = O(\dfrac{L}{N}) 
N
O(N+L)
​
 =O( 
N
N
​
 + 
N
L
​
 )=O( 
N
L
​
 ).

next(): O(\dfrac{L}{N})O( 
N
L
​
 ) or O(1)O(1).

All of this method is O(1)O(1), except for possibly the call to makeStackTopAnInteger(), giving us a time complexity the same as makeStackTopAnInteger().

hasNext(): O(\dfrac{L}{N})O( 
N
L
​
 ) or O(1)O(1).

All of this method is O(1)O(1), except for possibly the call to makeStackTopAnInteger(), giving us a time complexity the same as makeStackTopAnInteger().

Space complexity : O(N + L)O(N+L).

In the worst case, where the top list contains NN integers, or LL empty lists, it will cost O(N + L)O(N+L) space. Other expensive cases occur when the nesting is very deep. However, it's useful to remember that D ≤ LD≤L (because each layer of nesting requires another list), and so we don't need to take this into account.


 */
public class NestedIterator implements Iterator<Integer> {

     Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }
    
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
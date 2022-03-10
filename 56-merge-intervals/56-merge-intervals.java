/*
Time complexity : O(n\log{}n)O(nlogn)

Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(n\log{}n)O(nlogn) complexity of sorting.

Space complexity : O(\log N)O(logN) (or O(n)O(n))

If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(\log n)O(logn) space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.

First we sort the list based on interval[i][0];
Compare end of current to start of next -
i) if end of current is larger than start of next then we merge the interval but not add to list to check further intervals(we track this with s,e,start and end variables)
ii) if above condition is not met then we add interval to list(start,end).
we convert list to array and return.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        //create empty dynamic array
    ArrayList<int[]> ans = new ArrayList<>();
    
    //Base conditions when no value present in intervals array
    if(intervals.length == 0 || intervals == null)
    {
        return ans.toArray(new int[0][]);
    }
    
    //Using comparable class and sort Pairs in ascending order
    Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
    
    //Then create two pointers 1. start 2.end in pair
    int start = intervals[0][0];
    int end = intervals[0][1];
    
    //Using for loop to occurence in intervals one by one
    for(int i = 1; i < intervals.length; i++)
    {
        //Basically no overlap condition
        if(intervals[i][0] > end)
        {
            ans.add(new int[]{start , end});
            start = intervals[i][0];
            end = intervals[i][1];
        }
        
        //overlap condition
        else if(intervals[i][1] >= end)
        {
            end = intervals[i][1];
        }
    }
    
    //final pair
    ans.add(new int[]{start , end});
    return ans.toArray(new int[0][]);

    }
}
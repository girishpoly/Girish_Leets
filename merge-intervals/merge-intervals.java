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
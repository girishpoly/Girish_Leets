class Solution {
    /**
If we know the amount of water trapped above each bar. We can sum up these values to determine the total amount of water trapped by the graph. 
    
In order for water to be trapped, there must be a leftside bar and a rightside bar that traps the water.
Notice that the amount of rainwater that can be trapped will be upperbounded by the smaller of these two bars
    
    Example 1:
    _ _
    |  |    _ _
    |  |    |  |
    |  |    |  |
    
For these two bars. 
We have a height of 3 for the bar on the left and a height of 2 for the bar on the right. 
The maximum amount of water we can trap in the middle will be the minimum of these two heights (2).
    
    
Now let us say we wanted to determine the amount of water above the middle bar in this graph. 
    
    Example 2:
    _ _
    |  |        _ _
    |  |  _ _   |  |
    |  |  | |   |  |
    
Now we can see that the maximum amount of water we can trap between the left bar and the right bar is 2 (as we calculated in the previous part). 
However, now since we have a bar in the middle, we can't trap all 2 units of water. 
We will only be able to trap 1 unit of water, because the other unit of space is taken up by the bar in the middle.
    
From this, we can derive a formula (which we will later refine) for calculating the amount of water above the ith bar. 
    
    water[i] = min(height_left_bar, height_right_bar) - h[i] (the height of the current bar).
    
    Now what if we added another bar to the graph. 
    
    Example 3:
    _ _               _ _
    |  |        _ _   |  |
    |  |  _ _   |  |  |  |
    |  |  | |   |  |  |  |
    
Now if we wanted to calculate the amount of water above the bar at index 1, we can see that our left bound remains the same (the bar at index 0).
However, our right bound is now different. 
To trap the most amount of water, our right bound is now the bar at index 3 (as opposed to index 2 in the previous example). 
We can see that the minimum height of the two bars (at index 0 and index 3) is 3. 
Now the amount of water we can trap above the bar at index 1 is  3 - 1 (1 for the height of the bar at index 1 itself) = 2. 
    
This observation shows us that the amount of water above the ith bar will be the minimum of the maximum height of all bars to the left of the ith bar 
and the maximum height of all bars to the right of the ith bar. Thus we refine our equation as such. 
    
water[i] = min(max_height_left_bar, max_height_right_bar) - h[i] (the height of the current bar). 
    
What if the height of the current bar is larger than min(max_height_left_bar, max_height_right_bar)
    
    Example 4: 
         _ _
         | |
    _ _  | |  _ _
    | |  | |  | |
    
In this example, let us use our formula from the previous example to calculate the amount of water above the bar at index 1. 
The max_height_left_bar is the bar at index 0 with height 1. 
The max_height_right_bar is the bar at index 2 with height 1. 
Also the height of the bar at index 1 is 3. Thus, water[1] = min(1, 1) - 3 ==> -2. 
However, we can never trap negative units of rain water, so we already see that something wonky is happening.
Lets look at the picture. We cannot trap any units of rainwater above the bar at index 1. 
This is because if we try to place any water ontop of the bar at index 1 it will either spill to the right or the left. 
To generalize this case, if max_height_left_bar is less than the height of the current bar, any rain water placed ontop of the current bar will spill to the left. 
Similarly, if max_height_right_bar is less than the height of the current bar,  any rain water placed ontop of the current bar will spill to the right. 
Or in other words, if the minimum of our max_height_left_bar and max_height_right_bar is less than the current bar height then we can trap 0 units of water. 
    
Thus, if our equation to calculate water[i] gives us a negative number we want to round to 0. We cannot trap any rainwater above the current bar
    
Thus, we refine our equation further:
    
water[i] = max(min(max_height_left_bar, max_height_right_bar) - h[i] (the height of the current bar), 0)
    
After we enumerate our water array we can sum up all the values to find all the rainwater trapped by the graph
    **/
    public int trap(int[] height) {
        int[] max_height_left_bar = new int[height.length];
        
        for (int idx = 1; idx < height.length; idx++) {
            max_height_left_bar[idx] = Math.max(max_height_left_bar[idx - 1], height[idx - 1]);
        }
        
        int[] max_height_right_bar = new int[height.length];
        for (int idx = height.length - 2; idx >= 0; idx--) {
            max_height_right_bar[idx] = Math.max(max_height_right_bar[idx + 1], height[idx + 1]);
        }
        
        int[] water = new int[height.length];
        for (int idx = 0; idx < water.length; idx++) {
            water[idx] = Math.max(Math.min(max_height_left_bar[idx], max_height_right_bar[idx]) - height[idx], 0);
        }
        
        int sol = 0;
        for (int idx = 0; idx < water.length; idx++) { 
            int water_above_current_bar = water[idx];
            sol += water_above_current_bar;
        }
        
        return sol;
    }
}
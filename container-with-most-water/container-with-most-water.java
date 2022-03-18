class Solution {
    public int maxArea(int[] height) {
        //since the points are sorted we can use two pointers start and end
        
        int start = 0; 
        int end = height.length - 1;
        int maxArea = 0 ;
        
        while(start < end){
            
            //if height[start] is smaller then consider it to calculate the 
            //area. length * width.
            if(height[start] < height[end]){
                maxArea = Math.max(maxArea, height[start] * (end - start));
                start++;
            }
            else{
                maxArea = Math.max(maxArea, height[end] * (end - start));
                end--;
            }
        }
        
        return maxArea;
        
    }
}
  /*
     *  A line is determined by two factors,say y=ax+b
     *  
     *  If two points(x1,y1) (x2,y2) are on the same line(Of course). 

     *  Consider the gap between two points.

     *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

     *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

     *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  So we can use y0&x0 to track a line;
     */
class Solution {
    
    // Calculate slope of every two points
    // Store slope as key of hashmap; value is the number of points.
    // Note: Vertical line doesn't have slope (We can define it as Double.MAX_VALUE)
    // Check the straight lines point by point
    
    public int maxPoints(int[][] points) {
        
        int n = points.length;
  
        if (n <= 2)
            return n;
        
        int result = 0;
        
        for (int i = 0; i < n; i++)
        {
            Map<Double, Integer> map = new HashMap<>();
            
            for (int j = 0 ; j < n; j++)
            {  
                if (i == j)
                    continue;  
                 
                double slope = 0.0;  
                
                if (points[i][0] == points[j][0])
                    slope = Double.MAX_VALUE;
                else
                    slope = (double)(points[i][1]-points[j][1]) / (double)(points[i][0]-points[j][0]);
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
                
            for (int count : map.values())
                result = Math.max(result, 1 + count); // 1 means itself
        }
    
        return result; 
    }
}
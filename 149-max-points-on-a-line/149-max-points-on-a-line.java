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
        if(points.length <= 2)
            return points.length;
        
        Double m = null; // slope.       
        
        Map<Double, Integer> slopeAndLines = new HashMap<>(); // Maps slope to number of points on it
        int max = 0; // tracks the slope with max points for a point
        int result = 0;// track final answer
        
        for(int i = 0; i < points.length - 1; i++)
        {           
            slopeAndLines.clear();
            for(int j = i + 1; j < points.length;j++)
            {                
                if(points[j][0] - points[i][0] != 0)
                {
                    m = ((double)(points[j][1] - points[i][1])/(points[j][0] - points[i][0]));            
                }  
                else
                {                    
                    m = Double.MAX_VALUE;// horizontal line; Saving it as null will ensure it won't be counted towards other lines with slope = 1.                    
                }                
                if(m != null && m == -0.0) // issue with hashmap treating 0.0 and -0.0 as separate keys.
                    m = 0.0;
                
                if(!slopeAndLines.containsKey(m))
                    slopeAndLines.put(m, 2);
                else
                    slopeAndLines.put(m, slopeAndLines.get(m) + 1);
                
                int val = slopeAndLines.get(m);              
                
                max = Math.max(max, val);
               
            }
            
            result = Math.max(result,max);
        }       
        return result;
    }    
}
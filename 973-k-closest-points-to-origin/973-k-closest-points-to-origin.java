class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<Point>( points.length, new HeapComparator());
        
        for(int r = 0; r< points.length;r++){
            heap.add(new Point(points[r][0], points[r][1]));
        }     
        
        int[][] ans = new int[k][2];
        
        
        for(int c = 0;c<k; c ++){
            Point p = heap.poll();
            ans[c][0] = p.x;
            ans[c][1] = p.y;
        }
        
        return ans;
        
        
        
    }
}

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}

class HeapComparator implements Comparator<Point>{
    public int compare(Point a , Point b){
        return  ((a.x*a.x) + (a.y*a.y)) - ((b.x*b.x) + (b.y*b.y));
    }
}
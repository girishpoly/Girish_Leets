/*
First we traverse the whole grid to find out the positions of rotten oranges and total no of oranges.
Enqueue the positions of rotten oranges into a queue.
Secondly dequeue to get the position of a rotten orange.
Now start checking the cell in the left/right/top/down of the rotten orange, if it is a fresh orange
enqueue it. 
Continue to dequeue until all rotten oranges of last round are removed from the queue.

*/
class Solution {
    
    static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Position> q = new LinkedList<>();
        int total = 0 , rotten = 0 , time = 0;
        
        //traverse the grid. add position of orange into queue and count total no of oranges
        for(int i = 0 ; i < grid.length; i++){
            
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                
                if(grid[i][j] == 2) q.offer(new Position(i,j));
                
            }
            
        }
        
        //if there is no orange return o
        if(total == 0) return 0;
        
        while(!q.isEmpty() && rotten < total){
            //size is the num of rotten oranges of the last round
            int size = q.size();
            
            rotten = rotten + size;
            
            //do later
            //count the num of rotten oranges, if it equals to total num, return time
            if(rotten == total) return time;
            
            time++;
            
            //continue to dequeue until all rotten oranges of last round are removed from the queue
            for(int i = 0 ; i < size ; i++){
                                
                //check the cell in the left/right/top/down of the rotten orange, if it fresh enqueit
               Position p = q.peek();
				
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Position(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Position(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Position(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer(new Position(p.x, p.y - 1));
                }
                q.poll();
                
            }
            
            
        }
        
        
        return -1;
        
    }
    
    
}
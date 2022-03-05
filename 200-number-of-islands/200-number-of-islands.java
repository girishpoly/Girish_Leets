/*
    The idea is to get the first x,y value then we get its neighbors from left, top, right, bottom
    add the neighbors to the queue to process them as well and keep doing this for all the values
     in the grid.
     If queue is empty that means we have processed one x,y value with 1 and visited its neighbors.
     as we visit the neighbors mark them visited may be 2
     
     Now to visit or check if any other island is present, we need to go to the next valid x,y that has 1. otherwise we keep moving forward.
     
     if we find x,y with 1 that means its a different land, increment island count and we mark this visited and check for its neighbors. if we keep finding neighbors of neighbors, that means it is a continuous landmass.
    
*/
class Solution {

    //class to store x, y values from the given grid
    static class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {

        //create a queue to add x,y values 
        Queue<Point> queue = new LinkedList<>();

        int numIslands = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') queue.add(new Point(i, j));

                //for the above land start checking its neighbors
                while (!queue.isEmpty()) {
                    int size = queue.size();

                    for (int k = 0; k < size; k++) {

                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;
                        char c = grid[p.x][p.y];

                        //add c == 2 later. we should consider both visited and non visited elements becz for x,y value a land could be non  visited and connected                                                   to only visited nodes ie 2.
                        if (c == '1' || c == '2') {

                            //find neighbors in all 4 directions

                            //right of x,y and boundary check

                            if (y + 1 <= cols - 1 && grid[x][y + 1] == '1') {
                                //as we visit each neighbor make it 2 and add it to queue
                                grid[x][y + 1] = '2';
                                queue.add(new Point(x, y + 1));
                            }


                            //left of x,y
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                grid[x][y - 1] = '2';
                                queue.add(new Point(x, y - 1));
                            }

                            //top of x,y
                            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                grid[x - 1][y] = '2';
                                queue.add(new Point(x - 1, y));
                            }


                            //bottom of x,y
                            if (x + 1 <= rows - 1 && grid[x + 1][y] == '1') {
                                grid[x + 1][y] = '2';
                                queue.add(new Point(x + 1, y));
                            }

                            //for the original land upon which we landed was 1 , we increment the island count and mark it visited
                            //only increment the island count for original land and not for the neighbors
                            if (c == '1') {
                                grid[x][y] = '2';
                                numIslands++;
                            }

                        }

                    }

                }

            }
        }
        return numIslands;

    }
}
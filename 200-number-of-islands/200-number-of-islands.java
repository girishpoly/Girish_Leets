class Solution {
   static class Pair {
        int first;
        int second;
        Pair() {}
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


public static int numIslands(char[][] grid) {

	// we add queue for pair, as we need to store x,y values
	// in that way we can get the value from grid[x][y]
	Queue<Pair> queue = new LinkedList<>();

	int islands = 0;

	// now, general idea is we check for all x,y values
	// we get the first valid x,y value then we get its neighbours
	// ie top, bottom, left, right and put it to the queue to process next
	// ideally if Q is empty that means we have processed one x,y value with '1'
	// and visited its neighbours, ie the continuous landmass
	// now to visit or check if any other landmass is present,
	// we need to go to the next valid x,y (valid x,y has '1')
	// otherwise, we keep moving forward
	// if we find an x,y with '1', that means its a different landmass, increment island count and,
	// we mark this visited and check for its neighbours to visit them
	// if we keep finding neighbours of neighbours, that means its a continuous landmass

	for (int ii = 0; ii < grid.length; ii++)
		for (int ij = 0; ij < grid[ii].length; ij++) {

			// we add to Q only if its a non visited landmass
			if (grid[ii][ij] == '1') queue.add(new Pair(ii, ij));

			// for this above found land, we now check for its neighbours
			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					// we use the x,y values to get the grid value
					Pair p = queue.poll();
					int x = p.first;
					int y = p.second;
					char c = grid[x][y];

					// we consider both visited and non visited landmass
					// because for x,y value, a landmass could be non visited
					// and connected to only visited nodes ie '2'
					// so we want non visited nodes while travelling from
					// both visited nodes ie '2'
					// and non visited nodes ie '1'
					if (c == '1' || c == '2') {

						// find neighbours
						// if exist add to Q to check its subsequent neighbours and mark visited

						if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == '1') {
							// right of x,y
							grid[x][y + 1] = '2';
							queue.add(new Pair(x, y + 1));
						}

						if (y - 1 >= 0 && grid[x][y - 1] == '1') {
							// left of x,y
							grid[x][y - 1] = '2';
							queue.add(new Pair(x, y - 1));
						}

						if (x - 1 >= 0 && grid[x - 1][y] == '1') {
							// top of x,y
							grid[x - 1][y] = '2';
							queue.add(new Pair(x - 1, y));
						}

						if (x + 1 <= grid.length - 1 && grid[x + 1][y] == '1') {
							// bottom of x,y
							grid[x + 1][y] = '2';
							queue.add(new Pair(x + 1, y));
						}


						// so if the original landmass upon which we landed
						// was '1', then we increment islands count
						// and mark it visited;
						// we only increment count using the original landmass
						// others are just a neighbour of it ie a continuous landmass
						if (c == '1') {
							grid[x][y] = '2';
							islands++;
						}
					}
				}
			}
		}

	return islands;
}
}
class Solution {
    int[][] directions = {
	{1, 0},
	{-1, 0},
	{0, 1},
	{0, -1}
};

public int getFood(char[][] grid) {
	int m = grid.length;
	int n = grid[0].length;
	for (int r = 0; r < m; r++) {
		for (int c = 0; c < n; c++) {
			if (grid[r][c] == '*') {
				return bfs(r, c, grid, m, n);
			}
		}
	}
	return -1;
}

private int bfs(int r, int c, char[][] grid, int m, int n) {
	Queue<int[]> q = new LinkedList<>();
	q.offer(new int[] {r, c});
	boolean[][] seen = new boolean[m][n];
	seen[r][c] = true;
	int steps = 0;
	while (!q.isEmpty()) {
		int size = q.size();
		steps++;
		for (int i = 0; i < size; i++) {
			int[] pair = q.poll();
			int row = pair[0];
			int col = pair[1];
			for (int[] dir : directions) {
				int newRow = dir[0] + row;
				int newCol = dir[1] + col;
				if (outOfBounds(newRow, newCol, m, n) || seen[newRow][newCol] || grid[newRow][newCol] == 'X') continue;
				if (grid[newRow][newCol] == '#') return steps;
				q.offer(new int[] {newRow, newCol});
				seen[newRow][newCol] = true;
			}
		}
	}
	return -1;
}

private boolean outOfBounds(int r, int c, int m, int n) {
	return r < 0 || r >= m || c < 0 || c >= n;
}
}
class Solution {
    public void setZeroes(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();

     /*
     Algorithm

We make a pass over our original array and look for zero entries.

If we find that an entry at [i, j] is 0, then we need to record somewhere the row i and column j.

So, we use two sets, one for the rows and one for the columns.

 if cell[i][j] == 0 {
     row_set.add(i)
     column_set.add(j)
 }
Finally, we iterate over the original matrix. For every cell we check if the row r or column c had been marked earlier. If any of them was marked, we set the value in the cell to 0.

 if r in row_set or c in column_set {
     cell[r][c] = 0
 }
     */
    // Essentially, we mark the rows and columns that are to be made zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Iterate over the array once again and using the rows and cols sets, update the elements.
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
    }
}
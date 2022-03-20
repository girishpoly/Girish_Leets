/*
Brute force approach is for each cell check if value is 1 keep on including sides to check if they can form bigger square.
once all cell consumed return max length.
Time complexity : O(mn)^2 In worst case, we need to traverse the complete matrix for every 1.
Space complexity : O(1). No extra space is used.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// check for each 1 entry largest square we can make
				if (matrix[i][j] == '1') {
					boolean flag = true;
					// length of current square
					int len = 1;
					// loop till 0 not found or entire matrix is consumed
					while (len + i < rows && len + j < cols && flag) {
						// try to expand to see if square can be increased. i.e. if all 1 exists
						for (int k = i; k <= len + i; k++) {
							// break if 0 found
							if (matrix[k][j + len] == '0') {
								flag = false;
								break;
							}
						}
						// try to expand to see if square can be increased. i.e. if all 1 exists
						for (int k = j; (k <= len + j) && flag; k++) {
							// break if 0 found
							if (matrix[i + len][k] == '0') {
								flag = false;
								break;
							}
						}
						// if both above loops run completely it means length of square can be increased
						if (flag) {
							len++;
						}
						// again try to include bigger square if flag is true.
					}
					// last just check current square has more length of the older one.
					max = Math.max(max, len);
				}
			}
		}
		// return area
		return max * max;
    }
}
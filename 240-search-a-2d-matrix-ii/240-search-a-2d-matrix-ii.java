//Regular Binary Search - O(m * logn)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
                int left  = 0;
                int right = matrix[i].length-1;
                while (left <= right){
                        int cMid = left + (right - left) / 2; // find mid
                        if (matrix[i][cMid] == target) return true; // if target matches then return true
                        else if (matrix[i][cMid] < target) left = cMid+1; // if the value is less than target then increment the left pointer
                        else right = cMid-1; // otherwise decrement the right pointer
                } 
        }
        return false;
    }
}
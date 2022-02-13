class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> l = new ArrayList();
        int c1 = 0;int c2 = matrix[0].length-1;
        int r1 = 0;int r2 = matrix.length-1;
        
        while(c1<=c2 && r1<=r2){
            for(int k=c1;k<=c2;k++){
                l.add(matrix[r1][k]);
            }r1++;
            
            for(int k=r1;k<=r2;k++){
                l.add(matrix[k][c2]);
            }c2--;
            if(r1<=r2) //Condition to check if r1<r2 even when c1<c2
            for(int k=c2;k>=c1;k--){
                l.add(matrix[r2][k]);
            }r2--;
            if(c1<=c2) //Condition to check if c1<c2 even if r1<r2
            for(int k=r2;k>=r1;k--){
                l.add(matrix[k][c1]);
            }c1++;
          
        }
         return l;  
    }
}
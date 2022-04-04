class Solution {
    public int mySqrt(int x) {
        
   // find the integer whose square is smaller than x
        int left = 0,
        right = x;
        int res = -1;
        
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            long square = (long)mid * mid;

            if(square == x){
                return mid;
            }
            
            else if(square < x){
                res = mid;
                left = mid + 1;
            }
            
            else{
                right = mid - 1;
            }
        }
        return res;
        
    }
}
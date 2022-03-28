class Solution {

   /**
     1. Consider the weight as [1,2,3]
     
     Then probality of 1 = 1 /1+2+3 = 1/6 = 17% 
                       2 = 2/6 = 1/3 = 33% 
                       3 = 3/6 = 1/2 = 50%  
     so basically if we call getIndex 100 times approximately 50 times return 2nd index , 33 times 1st index and 17 times 0th  index.
     
      
                              17%       33%                 50%
   Bucket of Proabality  = 0-------1-------------3----------------------6
                                [0,1] 0+1         1+2 [1,3]              3+3  [3,6]
                       
                       
    So idea is to generate the random number between low(0) --> high(sum) and see in which bucket it falls then return that.
    
    1. Create a prefix sum array .
    2. Then using Binary serach find out the bucket .
    3. Then using that bucket find out the Index  using Random .
    
    w= [1,2,3]
    prefixSum =[1,3,6];
    Dry Run it 
      prefixSum = [1,3,6]
    Say random number generated   target =4
      low =0;
      high = 2
      mid = 2;
     return 2;
                       
    **/ 
    
    
    private int[] prefixSum;
    
    private Random random = new Random();
    
    //O(n)
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        // creating the prefix sum
        prefixSum[0] = w[0];
        for( int i=1; i<prefixSum.length; i++){
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
        
    }
    
    /**
     Dry Run it 
      prefixSum = [1,3,6]
      target =4
      low =0;
      high = 2
      mid = 2;
     return 2; 
    
    **/
    //O(log n)
    public int pickIndex() {
       int target = random.nextInt(prefixSum[prefixSum.length-1]); 
       int low =0;
       int high = prefixSum.length-1;
        while( low <= high) {
            int mid = low + ( high -low)/2;
            if(prefixSum[mid] <= target){
                low = mid+1;
            }else {
                high = mid -1;
            }
        }
        return low;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
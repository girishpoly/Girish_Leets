class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = 0;
        int result = -1;
        int N = weights.length;
        
        for(int weight : weights){
            end+=weight;
            start = Math.max(start,weight);
        }
        
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(isValid(weights,D,N,mid) == true){
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return result;
    }
    
    private boolean isValid(int[] weights,int D,int N,int mid){
        int days =1;
        int sum = 0;
        
        for(int i = 0;i<N;i++){
            sum+=weights[i];
            
            if(sum>mid){
                days++;
                sum = weights[i];
            }
            
            if(days>D)
                return false;
        }
        return true;
    }
}
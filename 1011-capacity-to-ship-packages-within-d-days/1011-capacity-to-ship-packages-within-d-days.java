class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max_element = 0; //if we go one weight at a time then least we can put is the max element
        int sum_elements = 0; //if all elements are put together then sum of them will be the value
        
        for(int i = 0;i<weights.length;i++){
        max_element = Math.max(max_element,weights[i]);
        sum_elements+=weights[i];
        }
        
        int start = max_element;
        int end = sum_elements;
        int ans = 0;
        
        while(start<=end){
            int mid = start+(end-start)/2;  // mid is the value of weight that is going to be put each day.
            if(isAnswer(weights,days,mid)){ //if it is possible to go with mid weight then
                ans = mid; //answer will be mid weight
                end = mid-1; // but we might have a lesser than mid as well so decreasing end to check that
            }else{
                start = mid+1; //if mid is not possible then clearly mid is too small to cover all elements in given days so to increase mid, we increase start
            }
        }
        return ans; 
    }
    
        public boolean isAnswer(int[] weights,int days,int ans){
            int sum = 0; //sum of current consecutive elements
            int curr_day = 1;  //current no. of days, streak basically
            for(int i = 0;i<weights.length;i++){ 
                if(sum+weights[i]>ans){ //if current sum + latest element exceeds the mid weight then we will have to go next day
                    curr_day++; //we will start with the next set of weights from the next day
                    sum = weights[i]; //put the current weight element as the sum and then in this sum start adding the next element onwards to check with mid again if it exceeds sum 
                }else{
                    sum+=weights[i]; //we build a streak of sum of elements for the current day,
                }
            }
            return (curr_day<=days);
        }
        
    }

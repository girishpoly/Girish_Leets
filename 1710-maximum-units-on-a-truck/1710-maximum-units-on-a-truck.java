class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        //sort the given boxTypes based on the number of units
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int result = 0 ;
        
        
        for(int[] box : boxTypes){
            
            //if box[0] is less than the truck size. Get all boxes and units
            //add it to the result and decrement the truckSize capacity
            if(box[0] <= truckSize){
                
                result = result + (box[0] * box[1]);
                truckSize = truckSize - box[0];
                
            }
            // this is the case when we need to take only a chunk of the box
            else{
                
                result = result + (truckSize * box[1]);
                return result;
                
            }
            
        }
        
        return result;
        
    }
}
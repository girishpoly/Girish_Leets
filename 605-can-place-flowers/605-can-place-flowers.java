class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c=0;
        for(int i=0;i<flowerbed.length;i++){
		
		    //for including any flower previous and next should also be empty.
			//in case of 0th index we have to check only next index.
			//in case of last index we have to check only previous index.
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
                c++;
				
				//if any index is included, then next index can't be part of our solution, 
				//so avoid checking that again
                i++;
            }
			
			//if anytime our counter crosses number of flowers return true immideately
			//no need to check further
            if(c>=n) return true;   
        }
       return false;
    }
}
/*
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int pair = 0;
        for(int i = 0; i < time.length - 1; i++){
            for(int j = i + 1; j < time.length; j++){
                if((time[i] + time[j]) % 60 == 0){
                    pair++;
                }
            }
        }
        return pair;
    }
}
ANALYSIS :-

Time Complexity :- BigO(N^2)

Space Complexity :- BigO(1)


*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        // 1st Integer Represent time duration % 60 of song & 2nd Integer will count the no of such songs
        
        int count = 0;
        
        for(int t : time){
            if(t % 60 == 0){ // if we have something like [60,60,60]
                count += map.getOrDefault(0, 0);
            }
            else{
                count += map.getOrDefault(60 - t % 60, 0); // [30,20,150,100,40] using this example 100
                // if we take moduls of 100 with 60 we get 40, then we look for 60 - 40 which is 20. And 20 is there in "map", we update our count. And update the entry of 40 in our "map" as well
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1); // [30,20,150,100,40] using this example 150
            // 150 % 60 gives 30 and as we have already encountered 1 of the 30 previously. SO, we will update our count from 0 to 1
        }
        return count;
    }
} 

/**LYSIS :-

Time Complexity :- BigO(N)

Space Complexity :- BigO(N)**/
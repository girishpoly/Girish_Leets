class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;    //length of the releaseTimes array
        char longestPressedKey = keysPressed.charAt(0);  //initialize the longestPressedKey to the first keystroke
        int maxDuration = releaseTimes[0];  //initialize the maxDuration to the first keystroke duration
        
        /* Iterate over all the releaseTimes to calculate durations and then find the 
        maxDuration, and the key corresponding to the maxDuration. If two or more keys have
        the duration equal to the maxDuration, break the tie by selecting the key (letter) that
        comes later in the English Alphabet.*/
        
        for(int i = 1; i < n; i++){
            int duration = releaseTimes[i] -  releaseTimes[i-1];    //calculate duration of the ith keystroke
            if(duration > maxDuration){                             //update maxDuration and longestPressedkey here
                maxDuration = duration;
                longestPressedKey = keysPressed.charAt(i);
            }
            else if(duration == maxDuration && keysPressed.charAt(i) > longestPressedKey){  //break the tie lexographically
                longestPressedKey = keysPressed.charAt(i);
            }    
        }
        return longestPressedKey;    
    }
}
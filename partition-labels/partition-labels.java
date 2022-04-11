class Solution {
     public List<Integer> partitionLabels(String S) {
        
        /*
        Approach: Maintain a map of character to its last index (charLastIndexMap).
                  Have two variables, partitionStartIndex and partitionEndIndex, which will store the start and end indexes
                  of current partition.
                  Loop through the array, for each character, find its last index from map and make sure that it is not
                  smaller than current partitionEndIndex, by doing Math.max().
                  Then once the current index reaches that partition end index, we are at the end of a partition.
                  So calculate the length of current partition, add to output list, and reset partitionStartIndex and
                  partitionEndIndex.
                  
                  The reason behind doing Math.max() for partitionEndIndex is that it will make sure that the window is always
                  moving forward only, excluding seperate partition for chars whose start and end indexes
                  are in between start and end of another char.
                  For example, "aaabbccbb" will have map as: [2,8,6,0,0,0...]. If we don't do Math.max, after handling
                  partition for a (endIndex: 2) and b (endIndex: 8), when we come to c, we don't create another partition
                  for c (endIndex: 6). Doing Math.max, when we come to b, our partitionEndIndex will be 8, and after that
                  when we go to c, with endIndex 6, since 8>6, we'll ignore c. Math.max will also help handling non existing
                  chars, which will have 0 as endIndex in map.
                  
        Complexity analysis: Time: O(n), Space: O(1) [As both the map and output list will have max 26 items, irrespective of 
                                                      input length]
        */
        
        int[] charLastIndexMap = new int[26];
        
        for(int i=0; i<S.length(); i++){
            charLastIndexMap[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> partitionLenList = new ArrayList<>();
        
        int partitionStartIndex = 0;
        int partitionEndIndex = 0;
        
        for(int i=0; i<S.length(); i++){
            
            partitionEndIndex = Math.max(partitionEndIndex, charLastIndexMap[S.charAt(i)-'a']);
            
            if(i==partitionEndIndex){                                               //Reached current partition end index
                partitionLenList.add(partitionEndIndex-partitionStartIndex + 1);    //Add partition length to output list
                
                partitionStartIndex = i+1;                                          //Reset partition
                partitionEndIndex = i+1;
            }
        }
        
        return partitionLenList;
    }
}
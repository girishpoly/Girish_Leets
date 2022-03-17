/*
Time complexity : The time complexity of the constructor of our class is O(N)
Space complexity: O(N) for the dictionary that we prepare in the constructor.


*/
class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
		
		//Store the indices of the words
        for (int i = 0; i < wordsDict.length; ++i) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i); //no need to sort the list because it's already sorted since we loop from 0 to wordsDict.length
        }
    }
    
    public int shortest(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        List<Integer> distWord1 = map.get(word1);
        List<Integer> distWord2 = map.get(word2);
        
		//Find distance between two indices from word1 and word2, update the minDistance
        int start1 = 0;
        int start2 = 0;
        while(start1 < distWord1.size() && start2 < distWord2.size()) {
            minDistance = Math.min(minDistance, Math.abs(distWord1.get(start1) - distWord2.get(start2)));
            if (distWord1.get(start1) < distWord2.get(start2)) {
                start1++;
            } else {
                start2++;
            }
        }
        return minDistance;
    }
}


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
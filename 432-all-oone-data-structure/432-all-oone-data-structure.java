class AllOne {
    Map<String,Integer> wordsCount ;
    TreeMap<Integer,List<String>> countWords ;
    public AllOne() {
        wordsCount = new HashMap();
        countWords = new TreeMap();
    }
    
    public void inc(String key) {
        if(wordsCount.containsKey(key))// if the word exists.. this if to only delete the word from the countWords TreeMap as will put it under new count
        {
            int count = wordsCount.get(key); //get the count of words from the hashMap
            List<String> words = countWords.get(count);// look the treeMap for count with the given words count

            if(words.size()==1)// list of words saved under this count is 1 .. this mean there is only one word with this count
            {
                countWords.remove(count); // we remove the TreeMap entery as we will increment the count of this word and add it with  uner the new count
            }
            else  // if there is multiple words under that count ..
            {
                words.remove(key);// we remove the word from that list as we will add under the incremented count
            }
        }

        wordsCount.put(key,wordsCount.getOrDefault(key,0)+1); // add the word to the HashMap with incrementing the count if exists or with 1 count if not
        int newCount = wordsCount.get(key); 

        if(countWords.containsKey(newCount))// if that count exists with other words.. 
        {
            countWords.get(newCount).add(key);//we get the list of words and add this word to the list
        }
        else // if not such count exists .. 
        {
            List<String> nameList = new ArrayList();
            nameList.add(key);
            countWords.put(newCount,nameList); //add the word to a list and add it to the TreeMap with count of '1'
        }

        
    }
    
    public void dec(String key) {
        if(wordsCount.containsKey(key))// if the word exists.. this if to only delete the word from the countWords TreeMap as will put it under new count
        {
            int count = wordsCount.get(key); //get the count of words from the hashMap
            List<String> words = countWords.get(count);// look the treeMap for count with the given words count
            if(words.size()<=1)// list of words saved under this count is 1 .. this mean there is only one word with this count
            {  

                countWords.remove(count); // we remove the TreeMap entery as we will increment the count of this word and add it with  uner the new count
            }
            else  // if there is multiple words under that count ..
            {
                words.remove(key);// we remove the word from that list as we will add under the incremented count
            }
        }   
        wordsCount.put(key,wordsCount.getOrDefault(key,0)-1); // decrement the value of the word in the hashMap
        int newCount = wordsCount.get(key); 
        if(newCount==0)
        {
            wordsCount.remove(key);
        }
        if(countWords.containsKey(newCount))// if that count exists with other words.. 
        {
            countWords.get(newCount).add(key);//we get the list of words and add this word to the list
        }
        else if(newCount>0) // if not such count exists .. and after decrementing the count is not '0' 
        {
            List<String> nameList = new ArrayList();
            nameList.add(key);
            countWords.put(newCount,nameList); //add the word to a list and add it to the TreeMap with count of '1'
        }        
  
    }
    
    public String getMaxKey() {
        String max="";
        for(int k : countWords.descendingKeySet())
        {
            max= countWords.get(k).get(0);
            break;
        }
        return max;
    }
    
    public String getMinKey() {
        String min="";
        for(int k : countWords.keySet())
        {
            min= countWords.get(k).get(0);
            break;
        }
        return min;    }
    
    
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
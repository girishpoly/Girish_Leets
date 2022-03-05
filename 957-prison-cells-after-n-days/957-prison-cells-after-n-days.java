/*
cells.length = 8, so cells[0] and cells[7] will become 0 always. cells have only 2 ^ 6 = 64 different states and there will be a loop.

So TC = O(1) and SC = o(1).

Approach :
Step 1: Find the next state and to store that value we will keep a set, whatever the state value is, it will be acting as key.
Step 2: Now we will check if this key is already present or not.
Step 3: If not then add into set and increment i and iteration.
Step 4: If yes that means after this value is already present at this iteration,mark cycle as true and break from loop.
Step 5: If map contains key then looplength = iteration;
here c = (N)%looplength;
remaining days = (N-i)%looplength;

Step 6: Now we will check if loop is true then we will run our loop upto step N%iteration, and it is ovbiously less than 8.
and we will find that state and return it.
*/
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> set = new HashSet<>();
        int iteration = 0;
        boolean isCycle = false;
        
        int i = 0 ;
        
        while(i < n){
            int[] nextState = findNextState(cells);
            String key = Arrays.toString(nextState);
            if(!set.contains(key)){
                set.add(key);
                iteration++;
                i++;
            } else{
                isCycle = true;
                break;
            }
            cells = nextState;
        }
        
        int j = 0;
        if(isCycle){
            n  %= iteration;
            while(j < n){
                cells = findNextState(cells);
                j++;
            }
        }
        
        
        return cells;
    }
    
    private int[] findNextState(int[] cells){
        //just compare if cells on either side or same then mark it 1
        //cell 0 and cell 1 will always be 0
        int[] val = new int[8];
        for(int i = 1 ; i < 7 ; i++){
            val[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return val;
    }
}
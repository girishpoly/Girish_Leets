public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        if (n < 0)
            return -1;
        
        /** if (n == 0)
            Here clarify with your interviewer on what to do if n == 0
            and implement what they ask. 
        **/
		
		/** Choose first item of array as the candidate**/
        int candidate = 0;
        
        for (int i=1;i<n;i++)
        {
            /** if the candidate knows i, then original candidate cannot be a celebrity
                because celebrities do not know anyone
                so choose i as the next candidate to be a celebrity **/
            if (knows(candidate,i))
                candidate = i;
        }
        
        /** now we have a candidate.
           we have to check two conditions
           1. The candidate does not know anyone 
           2. Everyone knows the candidate **/
        for (int i=0; i< n; i++)
        {
            
            /** For the people who came before the candidate, we need to check that 
                both conditions above hold.
                For the people who came after the candidate we only need to check 
                that condition 2 holds. **/                        
            if (i < candidate)
            {                                
                /** the candidate knows i so therefore candidate cannot be a celebrity **/
                if (knows(candidate, i))
                    return -1; 
                /** if i does not know the candidate, then the candidate cannot be a celebrity **/
                if (!knows(i, candidate))
                    return -1;                
            }
            else if (i > candidate)
            {
                /** from the first loop to choose the candidate, we already know that the 
                   candidate does not know people ahead of them
                   so we can just check that everyone ahead of the candidate knows the candidate
                   if there is anyone ahead that does not know the candidate then the candidate cannot be a celebrity **/
                if (!knows(i, candidate))
                    return -1;
            }
            else
            {
                // i == candidate
                continue; 
            }
        }
        
        return candidate; 
    }
}
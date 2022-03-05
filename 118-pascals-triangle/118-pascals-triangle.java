class Solution {
   public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();
        if (numRows == 0) return sol;
        
        List<Integer> row = new ArrayList<>();
        row.add(1);
        sol.add(row);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> r = new ArrayList<>();
            r.add(1);
            List<Integer> p = sol.get(i-1);
            for (int j = 0; j < p.size()-1; j++) {
                r.add(p.get(j) + p.get(j+1));
            }
            r.add(1);
            sol.add(r);
        }        
        return sol;
    }
}
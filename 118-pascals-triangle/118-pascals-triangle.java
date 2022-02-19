class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> res = new ArrayList<>();
     
      if (numRows == 0) {
         return res;
      }           
          for (int i = 0; i < numRows; i++) {
               List<Integer> temp = new ArrayList<>();
      List<Integer> intervalValue = new ArrayList<>(); //this list contains the values except for the first 1 and the last 1 in a row
              if (i==0) { //the first row
                  temp.add(1);
                  res.add(new ArrayList<>(temp));                    
              }
            else //numRows>1
              {
               int lastSize = res.get(res.size()-1).size();//get the size of previous row
              for (int j = 0; j < lastSize-1; j++) { //caculate the interval Value based on previous row
                 int pre = res.get(res.size()-1).get(j);
                 int rear = res.get(res.size()-1).get(j+1);                                                 
                  intervalValue.add(pre+rear);
              }
			  //once we get the value in the middle interval, we just need to combine them
              temp.add(1); //the fisrt one
              temp.addAll(intervalValue);
              temp.add(1);// the last one
              res.add(new ArrayList<>(temp));
              }      
      }
      return res;
    }
}
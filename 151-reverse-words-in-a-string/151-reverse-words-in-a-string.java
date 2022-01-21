class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            if(str[i].length() > 0)
                sb.append(str[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
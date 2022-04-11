class Solution {
    public int reverse(int x) {
        long num = 0;
        while(x!=0){
            num = num*10 + x%10;
            x=x/10;
        }
        if(num>=Integer.MIN_VALUE && num<=Integer.MAX_VALUE)
        return (int)num;
        else
            return 0;
    }
}
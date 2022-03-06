/*
Time Complexity: O(N 4^L) where N is the number of cells in the board and L is the length of the word to be matched.
Space Complexity: O(L) where L is the length of the word to be matched.

Find each word's first matching letter on board and recursion to check for rest of word.
To adhere to the rule of not using a position more than once, we set positions to '0' to be visited.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        //find word's first letter . Then call method to check its neighbors
        for(int r = 0 ; r < board.length ; r++)
            for(int c = 0 ; c < board[0].length ; c++)
                if(board[r][c] == word.charAt(0) && searchWord(board, word, 0, r, c))
                    return true;
        
        return false;
    }
    
    public boolean searchWord(char[][] board, String word, int start, int r, int c){
        
        //once we get pass the word length , we are done
        if(word.length() <= start) return true;
        
        //if off bounds, letter is seen, letter is not same as word.charAt(start) return false
        if(r<0 ||c<0 || r>=board.length || c>=board[0].length || board[r][c]=='0' || board[r][c]!=word.charAt(start)     )       
           return false;
        
        //mark this board position to see
        char temp = board[r][c];
        board[r][c] = '0';
        
        //make recursive call on all 4 sides, if works return true
        if(searchWord(board, word, start+1, r+1,c) ||
          searchWord(board, word, start+1, r-1,c) ||
          searchWord(board, word, start+1, r,c+1) ||
          searchWord(board, word, start+1, r,c-1))
            return true;
        
        //set back to unseen if this didnt' work out for us as it is not part of the word
        board[r][c] = temp;
        
        return false;
    }
}
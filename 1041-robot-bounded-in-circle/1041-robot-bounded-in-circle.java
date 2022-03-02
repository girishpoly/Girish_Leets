class Solution {
    public boolean isRobotBounded(String instructions) {
        /*
        If the robot reaches where it started after one sequence of commands it means it is bounded in a circle as it will be keep doing the same directions and keep reaching at the origin.

Or if the robot reaches a direction other than north ,let say East , Think relatively, if it will follow the similar sequence of directions, it should reach south and third time it should reach west and then north respectively . Similarly it will keep moving in a circle .
        */
        
        int x = 0 ; 
        int y = 0 ;
        char direction = 'n';
        
        for(char d : instructions.toCharArray()){
            
            switch(d){
                
                case 'G':
                if(direction == 'n') y++;
                
                else if(direction == 's') y--;
                
                else if(direction == 'e') x++;
                
                else if(direction == 'w') x--;
                
                break;
                
                case 'L':
                if(direction == 'n') direction = 'w';
                
                else if(direction == 's') direction = 'e';
                
                else if(direction == 'e') direction = 'n';
                
                else if(direction == 'w') direction = 's';      
                
                break;
                
                case 'R':
                if(direction == 'n') direction = 'e';
                
                else if(direction == 's') direction = 'w';
                
                else if(direction == 'e') direction = 's';
                
                else if(direction == 'w') direction = 'n';
                break;
                
            }
            
        }
        
        if((x==0 && y==0) || direction!='n'){
            return true;
        }
        
        return false;        
    }
}
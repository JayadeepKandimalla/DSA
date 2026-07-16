class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int count){
        if(num==0){
            return count;
        }
        if(num%2==0){
            count++;
            return helper(num/2, count);
        }
        else{
            count++;
            return helper(num-1, count);
        }
        
    }
}
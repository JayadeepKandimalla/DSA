class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start= Integer.MIN_VALUE;
        int end=0, res= -1;

        for(int n: weights){
            end+= n;
            start= Math.max(n, start);
        }

        while(start<=end){
            int mid= start + (end-start)/2;
            
            if(helper(weights, mid)<=days){
                res= mid;
                end= mid-1;  
            }
            else{
                start= mid+1;
            }
        }
        return res;
    }

    public int helper(int[] arr, int wt){
        int days= +1, sum= 0;
        for(int n: arr){
            if(sum+n>wt){
                sum= 0;
                days++;
            }
            sum+=n;
        }
        return days;
    }
}
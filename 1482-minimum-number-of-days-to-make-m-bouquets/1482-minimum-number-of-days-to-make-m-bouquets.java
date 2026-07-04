class Solution {

    public boolean isPossible(int[] arr, int day, int m, int k){
        
        int cnt= 0, n= 0;
        for(int a: arr){
            if(a<=day){
                cnt++;
            }
            else{
                n+= cnt/k;
                cnt= 0;
            }
        }

        n+= cnt/k;
        if(n>=m){
            return true;
        }
        else{
            return false;
        }
    }

    public int minDays(int[] bloomDay, int m, int k) {

        int start= Integer.MAX_VALUE;
        int end= Integer.MIN_VALUE;
        int ans= -1;

        for(int n: bloomDay){
            start= Math.min(n,start);
            end= Math.max(n,end);
        }

        while(start<=end){
            int mid= start+ (end-start)/2;

            if(isPossible(bloomDay,mid,m,k)){
                ans= mid;
                end= mid-1;
            }
            else{
                start= mid+1;
            }            
        }

        return ans;
    }

}

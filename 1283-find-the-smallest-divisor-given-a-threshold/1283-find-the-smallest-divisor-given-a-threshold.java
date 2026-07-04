class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low= 1, high= 0, res= -1;
        for(int n: nums){
            high= Math.max(high, n);
        }

        while(low<=high){
            int mid= low+ (high - low)/2;

            if(helper(nums, mid)<=threshold){
                res= mid;
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return res;
    }

    public int helper(int[] arr, int div){
        int sum= 0; 
        for (int n : arr) {
            sum += (n + div - 1) / div;
        }
        return sum;
    }
}
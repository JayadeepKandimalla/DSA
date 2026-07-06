class Solution {
    public int splitArray(int[] nums, int k) {
        int start= 0, end= 0;
        for(int n: nums){
            start= Math.max(start,n);
            end+= n;
        }
        while(start<=end){
            int mid= start+ (end-start)/2;
            if(helper(nums,mid)>k){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return start;
    }

    public int helper(int[] arr, int max){
        int partitions=1, sum= 0;
        for(int n: arr){
            if(n+sum>max){
                partitions++;
                sum= 0;
            }
            sum+= n;
        }

        return partitions;
    }
}
class Solution {
    public int search(int[] nums, int target) {
        return helper(0, nums.length-1, nums, target);
    }

    public int helper(int l, int r, int[] nums, int tar){
        if(l>r){
            return -1;
        }
        int mid= l+ (r-l)/2;
        if(nums[mid]==tar){
            return mid;
        }

        if(nums[mid]<tar){
            return helper(mid+1, r, nums, tar);
        }
        else{
            return helper(l, mid-1, nums, tar);
        }
    }
}
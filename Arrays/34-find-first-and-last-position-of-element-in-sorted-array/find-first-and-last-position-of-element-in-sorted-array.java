class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans= {-1,-1};
        if(nums.length==0){
            return ans;
        }
        ans[0]= search(nums, target, true);
        ans[1]= search(nums, target, false);

        return ans;
    }

    private int search(int[] nums, int target, boolean findStart){
        int ans= -1, start= 0, end= nums.length-1;
        while(start<=end){
            int mid= (start +end)/2;
            if(nums[mid]<target){
                start= mid+1;
            }
            else if(nums[mid]> target){
                end= mid-1;
            }
            else{
                ans= mid;
                if(findStart){
                    end= mid-1;
                }
                else{
                    start= mid+1;
                }
            }
        }

        return ans;
    }
}
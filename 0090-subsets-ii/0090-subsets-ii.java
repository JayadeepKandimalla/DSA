class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        find(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void find(int i, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList(list));
            return;
        }

        list.add(nums[i]);
        find(i+1, nums, list, ans);
        list.remove(list.size()-1);
        int next= i+1;
        while(next<nums.length && nums[i]==nums[next]) next++;
        find(next, nums, list, ans);
    }
}
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        find(nums, new ArrayList<>());
        return res;
    }

    void find(int[] nums, List<Integer> al){
        if(al.size()==nums.length){
            res.add(new ArrayList<>(al));
            return;
        }

        for(int i=0;i<nums.length; i++){
            if(al.contains(nums[i])){
                continue;
            }

            al.add(nums[i]);
            find(nums, al);
            al.remove(al.size()-1);
        }
    }
}
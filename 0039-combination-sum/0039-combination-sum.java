class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> res= new ArrayList<>();
        find(0, candidates, target, ans, res);

        return ans;
    }

    public void find(int i, int[] arr, int k, List<List<Integer>> ans, List<Integer> res){
        
        if(k==0){
            ans.add(new ArrayList<>(res));
            return;
        }        

        if(i== arr.length || k<0){
            return;
        }

        res.add(arr[i]);
        find(i, arr, k- arr[i], ans, res);
        res.remove(res.size() - 1);

        find(i+1, arr, k, ans, res);
    }
}
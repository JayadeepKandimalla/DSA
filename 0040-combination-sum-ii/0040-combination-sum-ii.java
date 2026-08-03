class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        find(0, candidates, target, res, new ArrayList<>());

        return res;
    }

    public void find(int i, int[] arr, int k, List<List<Integer>> res, List<Integer> ans){
    if(k==0){
        res.add(new ArrayList<>(ans));
        return;
    }
    if(i==arr.length || k<0) return;

    ans.add(arr[i]);
    find(i+1, arr, k - arr[i], res, ans);
    ans.remove(ans.size()-1);

    int next = i + 1;
    while(next < arr.length && arr[next] == arr[i]) next++;
    find(next, arr, k, res, ans);
    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        compute(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    public void compute(int i, int k, int n, List<Integer> list, List<List<Integer>> ans){
        if(n==0 && k==0){
            ans.add(new ArrayList(list));
            return;
        }

        if(n<0 || k<0 || i>9){
            return;
        }

        list.add(i);
        compute(i+1, k-1, n-i, list, ans);
        list.remove(list.size()-1);
        compute(i+1, k, n, list, ans);
    }
}
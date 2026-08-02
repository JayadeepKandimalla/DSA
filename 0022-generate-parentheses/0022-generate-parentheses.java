class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    public void generate(String p, int open, int close, List<String> res){
        if(open==0 && close==0){
            res.add(p);
            return;
        }

        if(close<open) return;

        if (open > 0) {
            generate(p + "(", open - 1, close, res);
        }
        if (close > 0) {
            generate(p + ")", open, close - 1, res);
        }
    }
}
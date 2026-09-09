class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public void generate(List<String> res, String s, int o, int c, int n){
        if(o==n && c==n){
            res.add(s);
            return;
        }

        if(o<n){
            generate(res, s+ '(', o+1, c, n);
        }

        if(c<o){
            generate(res, s+ ')', o, c+1, n);
        }
    }
}
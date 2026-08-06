class Solution {
    public void reverseString(char[] s) {
        int l= 0, r= s.length-1;
        helper(s,l,r); 
    }

    public void helper(char[] s, int l, int r){
        if(l>=r) return;

        char temp= s[l];
        s[l]= s[r];
        s[r]= temp;
        helper(s, l+1, r-1);
    }
}
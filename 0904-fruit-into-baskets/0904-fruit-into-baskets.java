class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 1;
        int f1 = fruits[0], f2 = -1;
        int c1 = 1, c2 = 0, max = 1;

        while (r < fruits.length) {
            if (fruits[r] == f1) {
                c1++;
            } else if (fruits[r] == f2) {
                c2++;
            } else if (f2 == -1) {
                f2 = fruits[r];
                c2 = 1;
            } else {
                while (c1 > 0 && c2 > 0) {
                    if (fruits[l] == f1) c1--;
                    else c2--;
                    l++;
                }
                if (c1 == 0) {
                    f1 = fruits[r];
                    c1 = 1;
                } else {
                    f2 = fruits[r]; 
                    c2 = 1;
                }
            }
            max = Math.max(max, c1 + c2);
            r++;
        }
        return max;
    }
}
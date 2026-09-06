class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Memoization table initialized with -1
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        
        return countSubsequences(s, t, 0, 0, memo);
    }

    private int countSubsequences(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result = countSubsequences(s, t, i + 1, j + 1, memo) 
                   + countSubsequences(s, t, i + 1, j, memo);
        } else {
            result = countSubsequences(s, t, i + 1, j, memo);
        }

        return memo[i][j] = result;
    }
}
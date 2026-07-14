import java.util.*;

class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxVal = 200;

        // dp[g1][g2] = number of ways to have built seq1 with gcd g1 (0 = empty)
        // and seq2 with gcd g2 (0 = empty), using elements processed so far
        long[][] dp = new long[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] ndp = new long[maxVal + 1][maxVal + 1];
            // start as "skip x" (copy current dp)
            for (int g1 = 0; g1 <= maxVal; g1++) {
                ndp[g1] = dp[g1].clone();
            }

            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    long cnt = dp[g1][g2];
                    if (cnt == 0) continue;

                    // put x into seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    ndp[ng1][g2] = (ndp[ng1][g2] + cnt) % MOD;

                    // put x into seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    ndp[g1][ng2] = (ndp[g1][ng2] + cnt) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
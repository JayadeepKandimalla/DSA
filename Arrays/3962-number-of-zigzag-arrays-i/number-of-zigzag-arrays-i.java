class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int v = 0; v < m; v++) {
            up[v] = v;               
            down[v] = m - 1 - v;      
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixUp = new long[m + 1];
            long[] prefixDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] =
                    (prefixUp[i] + up[i]) % MOD;

                prefixDown[i + 1] =
                    (prefixDown[i] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m];

            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            for (int y = 0; y < m; y++) {

                nextUp[y] = prefixDown[y];
                nextDown[y] =
                    (totalUp - prefixUp[y + 1] + MOD) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
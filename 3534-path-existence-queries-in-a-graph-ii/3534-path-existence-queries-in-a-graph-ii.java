import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] sortedVal = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            sortedVal[i] = nums[idx[i]];
            pos[idx[i]] = i;
        }

        int[] jump = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (right < i) right = i;
            while (right + 1 < n && sortedVal[right + 1] - sortedVal[i] <= maxDiff) right++;
            jump[i] = right;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;

        int[][] up = new int[LOG][n];
        up[0] = jump.clone();
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0], v = queries[i][1];
            int pu = pos[u], pv = pos[v];
            if (pu > pv) { int t = pu; pu = pv; pv = t; }

            if (jump[pu] >= pv) {
                ans[i] = (pu == pv) ? 0 : 1;
                continue;
            }

            int cur = pu;
            int steps = 0;
            boolean reachable = true;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < pv) {
                    steps += (1 << k);
                    cur = up[k][cur];
                }
            }

            if (jump[cur] >= pv) {
                steps += 1;
            } else {
                reachable = false;
            }

            ans[i] = reachable ? steps : -1;
        }

        return ans;
    }
}
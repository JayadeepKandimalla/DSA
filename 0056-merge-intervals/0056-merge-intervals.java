import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int last = list.size() - 1;

            int[] lastInterval = list.get(last);

            if (intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return  list.toArray(new int[list.size()][]);
    }
}
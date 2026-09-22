import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int n = 0;

        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            
            if(truckSize==0) return n;
            int boxes = Math.min(boxTypes[i][0], truckSize);
            n += boxes * boxTypes[i][1];

            truckSize -= boxes;
        }

        return n;
    }
}
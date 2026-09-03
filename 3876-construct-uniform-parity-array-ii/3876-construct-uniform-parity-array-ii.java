class Solution {
    public boolean uniformArray(int[] nums1) {
        int k = nums1.length;
        int n = 0, m = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            if (nums1[i] % 2 == 0) {
                n++;
            } else {
                m++;
                min = Math.min(min, nums1[i]);
            }
        }

        if (n == k || m == k) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (nums1[i] % 2 == 0 && nums1[i] < min) {
                return false;
            }
        }

        return true;
    }
}
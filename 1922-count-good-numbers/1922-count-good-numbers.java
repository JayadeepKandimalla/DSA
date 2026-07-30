class Solution {
    static final int M = 1_000_000_007;

    public int countGoodNumbers(long n) {
        if (n % 2 == 0) {
            return (int) pow(20, n / 2);
        } else {
            return (int) ((5L * pow(20, n / 2)) % M);
        }
    }

    private long pow(long x, long n) {
        if (n == 0) return 1;

        x = x % M;

        if (n == 1) return x;

        if (n % 2 == 0) {
            long half = pow(x, n / 2);
            return (half * half) % M;
        } else {
            return (x * pow(x, n - 1)) % M;
        }
    }
}
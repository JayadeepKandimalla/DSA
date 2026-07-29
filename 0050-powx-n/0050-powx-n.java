class Solution {
    public double myPow(double x, int n) {
        return fastPow(x, (long) n);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / fastPow(x, -n);
        if (n % 2 == 0) return fastPow(x * x, n / 2);
        return x * fastPow(x, n - 1);
    }
}
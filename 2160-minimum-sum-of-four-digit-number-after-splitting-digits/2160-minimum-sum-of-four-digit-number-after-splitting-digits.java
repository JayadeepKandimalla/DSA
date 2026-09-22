class Solution {
    public int minimumSum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        java.util.Arrays.sort(digits);
        
        return ((digits[0] - '0') * 10 + (digits[2] - '0')) + 
               ((digits[1] - '0') * 10 + (digits[3] - '0'));
    }
}
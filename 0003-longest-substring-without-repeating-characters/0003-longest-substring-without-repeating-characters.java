class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            while (charSet.contains(ch)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,max=0;
        HashSet<Character> uni = new HashSet<>();
        while (right < s.length()) {

            char ch = s.charAt(right);
            if (!uni.contains(ch)) {
                uni.add(ch);
                right++;
                max=Math.max(max,right-left);
            }else {
                uni.remove(s.charAt(left));
                left++;
            
            }
        }
        return max;
 
    }
}
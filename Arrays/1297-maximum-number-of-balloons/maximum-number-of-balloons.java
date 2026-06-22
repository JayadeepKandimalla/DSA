class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr= new int[26];
        for(char c: text.toCharArray()){
            arr[c-'a']++;
        }

        int min= Integer.MAX_VALUE;
        min= Math.min(min, arr['b'-'a']);
        min= Math.min(min,arr['a'-'a']);
        min= Math.min(min, arr['l'-'a']/2);
        min= Math.min(min, arr['o'-'a']/2);
        min= Math.min(min, arr['n'-'a']);

        return min;
    }
}
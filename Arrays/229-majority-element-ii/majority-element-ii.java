class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res= new ArrayList<>();
        int cnt1= 0, cnt2= 0, ele1= Integer.MIN_VALUE, ele2= Integer.MIN_VALUE;
        for(int n: nums){
            if(cnt1==0 && n!=ele2){
                cnt1++;
                ele1= n;
            }
            else if(cnt2==0 && n!=ele1){
                cnt2++;
                ele2= n;
            }
            else if(n==ele1){
                cnt1++;
            }
            else if(n== ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1= 0; cnt2= 0;
        for(int a: nums){
            if(a==ele1) cnt1++;
            if(a==ele2) cnt2++;
        }

        int maj= nums.length/3;
        if(cnt1>maj) res.add(ele1);
        if(cnt2>maj) res.add(ele2);

        return res;
    }
}
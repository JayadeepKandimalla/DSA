/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        ListNode slow= head;
        ListNode fast= head;
        ListNode prev= null;
        while(fast!=null && fast.next!=null){
            prev= slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        prev.next= null;

        if(fast != null){
            slow = slow.next;
        }
        
        ListNode prev1= null;
        while(slow!= null){
            ListNode next= slow.next;
            slow.next= prev1;
            prev1=slow;
            slow=next;
        }
        ListNode second= prev1;
        ListNode first= head;

        while(second!= null){
            if(first.val!=second.val){
                return false;
            }
            first= first.next;
            second= second.next;
        }
        return true;
    }
}
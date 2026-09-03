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
        if(head.next==null) return true;

        ListNode slow= head;
        ListNode fast= head;
        ListNode prev= null;

        while(fast!=null && fast.next!=null){
            prev= slow;
            slow= slow.next;
            fast= fast.next.next;
        }

        ListNode head2= reverse(slow);
        prev.next=null;
        ListNode l1= head;
        ListNode l2= head2;

        while(l1!=null && l2!=null){
            if(l1.val!=l2.val){
                return false;
            }
            l1= l1.next;
            l2= l2.next;
        }
        return true;

    }

    private ListNode reverse(ListNode root){
        ListNode prev= null;
        ListNode curr= root;
        
        while(curr!=null){
            ListNode next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }

        return prev;
    }
}
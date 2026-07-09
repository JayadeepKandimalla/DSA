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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode start=head;
        ListNode end= head;
        ListNode prev= null;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k= k%n;
        if(k==0) return head;

        for(int i=0;i<k-1;i++){
            end= end.next;
        }

        while(end.next!=null){
            prev=start;
            start= start.next;
            end= end.next;
        }
        
        prev.next=null;
        end.next=head;
        head= start;
    
    return head;
    }
}
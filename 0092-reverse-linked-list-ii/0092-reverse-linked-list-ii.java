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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null || left == right)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode l = head;
        ListNode r = head;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
            l = l.next;
        }

        for (int i = 1; i < right; i++) {
            r = r.next;
        }

        ListNode next = r.next;

        reverse(l, r);

        prev.next = r;
        l.next = next;

        return dummy.next;
    }

    private void reverse(ListNode left, ListNode right) {

        ListNode stop = right.next;
        ListNode prev = null;
        ListNode curr = left;

        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
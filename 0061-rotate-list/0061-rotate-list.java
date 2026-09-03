class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < k; i++) {
            end = end.next;
        }

        ListNode prev = null;

        while (end != null) {
            prev = start;
            start = start.next;
            end = end.next;
        }

        prev.next = null;
        
        ListNode curr = start;
        while (curr.next != null) {
            curr = curr.next;
        }
        
        curr.next = head;

        return start;
    }
}
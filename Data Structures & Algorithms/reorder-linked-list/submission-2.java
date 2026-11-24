/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * find the mid point
 * reverse after middle
 * add alternating
 */




class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;            //2 4 6 8 10
        }

        ListNode previous = null;
        ListNode postMid = slow.next;
        slow.next = null;

        while(postMid != null)
        {
            ListNode nextNode = postMid.next;
            postMid.next = previous;
            previous = postMid;
            postMid = nextNode;
        }

        while(previous != null)
        {
            ListNode nextHead = head.next;
            ListNode prevNext = previous.next;

            head.next = previous;
            previous.next = nextHead;

            head = nextHead;
            previous = prevNext;
        }
    }
}

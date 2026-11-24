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
    public void reorderList(ListNode head) {
        if(head == null && head.next == null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;

        slow.next = null; //cut the head off 6 -> 2 4 6.    8 10

        ListNode previous = null;

        while(current != null)
        {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        // we now have head = 2 4 6 previous = 8 10

        while(previous != null)
        {
            ListNode nextPrevious = previous.next;
            ListNode headNext = head.next;
            head.next = previous;
            previous.next = headNext;
            previous = nextPrevious;
            head = headNext;
            
        }

        
    }
}

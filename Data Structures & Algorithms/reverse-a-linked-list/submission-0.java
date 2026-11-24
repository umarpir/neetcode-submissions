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
 // 0 -> 1 -> 2 -> 3 -> null <- 
 // null <- 0 <- 1 <- 2 <- 3 <- null

 //next = previous

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null)
        {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;

    }
}

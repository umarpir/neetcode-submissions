/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } 5 -> null
 * dummy,1,2,3,4,null
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy;
    ListNode right = dummy;
    
    while(n > 0){
        right = right.next;
        n--;
    }

    while(right.next != null) {
        left = left.next;
        right = right.next;
    }

    left.next = left.next.next;

    return dummy.next;

    }
}

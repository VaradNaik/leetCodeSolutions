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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode itr = head;
        while(itr!=null && itr.next !=null){
            ListNode first = itr;
            ListNode second = itr.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            itr = first.next;

        }
        return dummy.next;
    }
}
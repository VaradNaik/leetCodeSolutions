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
        //find middle
        //split into two, reverse second linked list
        //merge both(one node at a time)
        //step 1
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //step2
        ListNode curr = slow;
        ListNode prev = null;
        while(curr != null){
            ListNode temp =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //step 3
        ListNode first = head, second = prev,tmp;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }

    }
}

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode head = prev;
        int value = 0;
        int carry=0;
        while(l1!=null && l2!=null){
            ListNode ptr = new ListNode();
            value = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            ptr.val = value;
            prev.next = ptr;
            prev = ptr;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1 !=null){
            ListNode ptr = new ListNode();
            value = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
            ptr.val = value;
            prev.next = ptr;
            prev = ptr;
            l1=l1.next;
        }
        while(l2 !=null){
            ListNode ptr = new ListNode();
            value = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
            ptr.val = value;
            prev.next = ptr;
            prev = ptr;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode ptr = new ListNode(1);
            prev.next = ptr;
        }
        return head.next;
    }
}
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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    ListNode merge(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(l1!=null && l2 !=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1=l1.next;
                tail = tail.next;
            }
            else{
                tail.next = l2;
                l2=l2.next;
                tail=tail.next;
            }
        }
        tail.next = (l1 != null) ? l1 : l2 ;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head){
        ListNode midPrevious = null;
        while(head !=null && head.next !=null){
            midPrevious = (midPrevious == null) ? head : midPrevious.next;
            head = head.next.next;
        }
        ListNode answer = midPrevious.next;
        midPrevious.next = null;
        return answer;
    }
}
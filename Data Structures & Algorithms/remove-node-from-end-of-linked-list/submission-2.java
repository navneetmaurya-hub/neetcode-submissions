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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = head;
        ListNode s = head;
        int idx = 0;
        while(t != null){
            idx++;
            t = t.next;
        }
        if(idx==1 && n==1) return head.next;
        int k = 0;
        while(s != null){
            k++;
            if(s.val==head.val && idx - n==0) return head.next;
            if(k == idx - n){
                s.next = s.next.next;
                break;
            }
            s = s.next;
        }
        return head;
    }
}
 
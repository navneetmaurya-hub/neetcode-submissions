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
    public boolean hasCycle(ListNode head) {
      if(head==null || head.next==null) return false;
      ListNode t=head;
      ListNode s=head;
      while(s.next!=null && s.next.next!=null){
        t=t.next;
        s=s.next.next;
        if(t==s){
            return true;
        }
      }
      return false; 
    }
}

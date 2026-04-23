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
    public ListNode mergeKLists(ListNode[] lists) {
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     ListNode head=new ListNode();
     ListNode t=head;
     for(int i=0;i<lists.length;i++){
        ListNode temp=lists[i];
        while(temp!=null){
            pq.add(temp.val);
            temp=temp.next;
        }
     }
     while(!pq.isEmpty()){
      ListNode z=new ListNode(pq.remove());
      t.next=z;
      t=t.next;
     }
     t.next=null;
     return head.next;
    }
}

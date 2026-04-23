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
    public ListNode reverseKGroup(ListNode head, int k) {
     ListNode temp=head;
     int idx=0;
     while(temp!=null){
          idx++;
          temp=temp.next;
     }
     int count=idx/k;
     if(count==0) return head;
     ListNode arr[]=new ListNode[idx];
     ListNode curr=head;
     
     for(int i=0;i<count;i++){
        ListNode agla=null;
        ListNode prev=null;
        for(int j=0;j<k;j++){
            agla=curr.next;
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        arr[i]=prev;
     }
     ListNode ans=new ListNode(1);
     ListNode t=ans;
      for(int i=0;i<arr.length;i++){
           t.next=arr[i];
           
           while(t.next!=null){
            t=t.next;
           } 
        }
        if(idx/k!=0){
           t.next=curr;
        }
        return ans.next;
    }
}

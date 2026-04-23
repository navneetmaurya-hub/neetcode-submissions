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
        if( head==null || head.next==null || head.next.next==null){

        }
        else{
        Stack<ListNode>st=new Stack<>();
       ListNode t=head;
       ListNode t1=head;
       ListNode t2=head;
       while(t2!=null){
        st.push(t2);
        t2=t2.next;
       }
       int size=st.size();
          int k=size/2;
          int idx=0;
        while(idx<=k-1){
            idx++;
            t1=t1.next;
            t.next=st.pop();
            t=t.next;
            t.next=t1;
            if(idx==k && size%2==0){
                t.next=null;
            }
            if(idx==k && size%2!=0){
                t1.next=null;
            }
            t=t1;
        }
        }
       
    }
}

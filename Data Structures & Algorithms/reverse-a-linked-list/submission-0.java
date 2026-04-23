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
    public ListNode reverseList(ListNode head) {
      ListNode temp=new ListNode(0);
      ListNode temp2=temp;
      ListNode temp1=head;
      Stack<ListNode>st=new Stack<>();
      while(temp1!=null){
         st.push(temp1);
         temp1=temp1.next;
      } 
      while(!st.isEmpty()){
        ListNode w=st.pop();
        temp2.next=w;
        temp2=temp2.next;
      } 
      temp2.next=null;
      return temp.next;
    }
}

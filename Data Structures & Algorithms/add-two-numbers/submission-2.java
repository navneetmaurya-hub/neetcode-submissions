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
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        ListNode t=l1;
        ListNode t1=l2;
        while(t!=null){
            sb.append(t.val);
            t=t.next;
        }
        while(t1!=null){
            sb1.append(t1.val);
            t1=t1.next;
        }
        sb.reverse();
        sb1.reverse();
        long a=Long.parseLong(sb.toString());
        long b=Long.parseLong(sb1.toString());
        long k=a+b;
        String z=String.valueOf(k);
        ListNode ans=new ListNode();
        ListNode temp=ans;
        for(int i=z.length()-1;i>=0;i--){
            ListNode ans1=new ListNode(z.charAt(i)-'0');
            temp.next=ans1;
            temp=temp.next;
        }
        return ans.next;
    }
}
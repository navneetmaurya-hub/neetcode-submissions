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

// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1==null && list2==null) return list1;
//        if(list1==null) return list2;
//        if(list2==null) return list1;
//        int idx=0;
//        if(list1.val<=list2.val){
//          idx++;
//          ListNode temp=list1;
//          ListNode temp1=list1;
//          ListNode temp2=list2;
//          temp1=temp1.next;
//        while(temp1!=null){
//         if(list2==null) return list1;
//         else if(list2.val>=temp.val && list2.val<=temp1.val){
//            temp2=temp2.next;
//            temp.next=list2;
//            list2.next=temp1;
//            temp=temp.next;
//            list2=temp2;
//         }
//         else{
//            temp1=temp1.next;
//            temp=temp.next;
//            if(temp1==null){
//             temp.next=list2;
//             return list1;
//            }
//         }
//        }
//        }
//       //  
//       // 
//        else{
//            ListNode temp=list2;
//        ListNode temp1=list2;
//        ListNode temp2=list1;
//        temp1=temp1.next;
//        while(temp1!=null){
//         if(list2==null) return list1;
//         else if(list1.val>=temp.val && list1.val<=temp1.val){
//            temp2=temp2.next;
//            temp.next=list2;
//            list1.next=temp1;
//            temp=temp.next;
//            list1=temp2;
//         }
//         else{
//            temp1=temp1.next;
//            temp=temp.next;
//            if(temp1==null){
//             temp.next=list2;
//             return list2;
//            }
//         }
//        }
//        }
//        if(idx>0) return list1;
//        return list2;
//     }
// }
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null) return list2;
        if(list2==null) return list1;

        int idx=0;

        if(list1.val<=list2.val){
            idx++;

            ListNode temp=list1;
            ListNode temp1=list1.next;
            ListNode temp2=list2;

            if(temp1==null){
                temp.next=temp2;
                return list1;
            }

            while(temp1!=null && temp2!=null){

                if(temp2.val>=temp.val && temp2.val<=temp1.val){

                    ListNode next=temp2.next;

                    temp.next=temp2;
                    temp2.next=temp1;

                    temp=temp2;
                    temp2=next;
                }
                else{
                    temp=temp1;
                    temp1=temp1.next;

                    if(temp1==null){
                        temp.next=temp2;
                        return list1;
                    }
                }
            }
        }

        else{

            ListNode temp=list2;
            ListNode temp1=list2.next;
            ListNode temp2=list1;

            if(temp1==null){
                temp.next=temp2;
                return list2;
            }

            while(temp1!=null && temp2!=null){

                if(temp2.val>=temp.val && temp2.val<=temp1.val){

                    ListNode next=temp2.next;

                    temp.next=temp2;
                    temp2.next=temp1;

                    temp=temp2;
                    temp2=next;
                }
                else{
                    temp=temp1;
                    temp1=temp1.next;

                    if(temp1==null){
                        temp.next=temp2;
                        return list2;
                    }
                }
            }
        }

        if(idx>0) return list1;
        return list2;
    }
}
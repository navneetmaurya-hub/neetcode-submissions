/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node,Node> map = new HashMap<>();

        Node t = head;
        Node ans = new Node(0);
        Node s = ans;

        
        while(t != null){
            Node newNode = new Node(t.val);
            map.put(t,newNode);
            s.next = newNode;
            s = s.next;
            t = t.next;
        }

        Node z = head;
        Node p = ans.next;

        // second pass: set random pointers
        while(z != null){

            if(z.random == null){
                p.random = null;
            }
            else{
                p.random = map.get(z.random);
            }

            z = z.next;
            p = p.next;
        }

        return ans.next;
    }
}

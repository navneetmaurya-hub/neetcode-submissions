/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>>li=new ArrayList<>();
      if(root==null) return li;
      Queue<TreeNode>q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
        int count=q.size();
        List<Integer>lii=new ArrayList<>();
        for(int i=0;i<count;i++){
           TreeNode currnode=q.remove();
           lii.add(currnode.val);
           if(currnode.left!=null){
            q.add(currnode.left);
           }
           if(currnode.right!=null){
            q.add(currnode.right);
           }
        }
        li.add(lii);
      }
      return li;
    }
}

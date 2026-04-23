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
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer>li=new ArrayList<>();
      if(root==null) return li;
      Queue<TreeNode>q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
           int count =q.size();
           for(int i=0;i<count;i++){
              TreeNode currnode=q.remove();
              if(i==count-1){
                li.add(currnode.val);
              }
              if(currnode.left!=null){
                q.add(currnode.left);
              }
              if(currnode.right!=null){
                q.add(currnode.right);
              }
           }
      }
      return li;

    }
}

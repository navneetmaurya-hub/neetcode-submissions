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
    public TreeNode invertTree(TreeNode root) {
     Queue<TreeNode>q=new LinkedList<>();
     if(root==null) return root;
     q.add(root);
     while(q.size()>0){
        int count=q.size();
        for(int i=0;i<count;i++){
            TreeNode currnode=q.remove();
            if(currnode.left!=null){
                q.add(currnode.left);
            }
            if(currnode.right!=null){
                q.add(currnode.right);
            }
            TreeNode temp=currnode.left;
            currnode.left=currnode.right;
            currnode.right=temp;
        }
     }
     return root;
    }
}

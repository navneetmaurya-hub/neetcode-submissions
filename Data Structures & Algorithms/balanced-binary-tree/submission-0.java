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
    public static int bfs(TreeNode root,int ans[]){
        if(root==null) return 0;
        int l=bfs(root.left,ans);
        int r=bfs(root.right,ans);
        ans[0]=Math.max(ans[0],Math.abs(r-l));
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
      int ans[]=new int[1];
      ans[0]=Integer.MIN_VALUE;
      bfs(root,ans);
      if(ans[0]>1) return false;
      return true;  
    }
}

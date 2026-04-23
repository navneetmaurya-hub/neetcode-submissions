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
    public static void dfs(TreeNode root,int idx,int ans[]){
        if(root==null) return;
        if(root.val>=idx){
            ans[0]++;
        }
        idx=Math.max(idx,root.val);
        dfs(root.left,idx,ans);
        dfs(root.right,idx,ans);
    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int ans[]=new int[1];
        dfs(root,Integer.MIN_VALUE,ans);
       return ans[0];
    }
}

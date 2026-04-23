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
    public static void preorder(TreeNode root,int a[],int idx){
        if(root==null) return;
        idx++;
        if(root.left==null && root.right==null){
           a[0]=Math.max(a[0],idx);
        }
        preorder(root.left,a,idx);
        preorder(root.right,a,idx);
    }
    public int maxDepth(TreeNode root) {
        int a[]=new int[1];
        preorder(root,a,0);
        return a[0];  
    }
}

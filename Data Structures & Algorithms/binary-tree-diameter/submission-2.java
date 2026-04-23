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
    static int ans=0;
    public static int preorder(TreeNode root){
        if(root==null) return 0;
        int l=preorder(root.left);
        int r=preorder(root.right);
        ans=Math.max(ans,l+r);
        return Math.max(l,r)+1; 
    }
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null) return 0;
       ans=0;
       preorder(root); 
       return ans;
    }
}

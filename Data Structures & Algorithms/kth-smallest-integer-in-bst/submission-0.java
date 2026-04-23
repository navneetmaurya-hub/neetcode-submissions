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
    public static void dfs(TreeNode root,List<Integer>li){
        if(root==null) return;
        li.add(root.val);
        dfs(root.left,li);
        dfs(root.right,li);
    }
    public int kthSmallest(TreeNode root, int k) {
      List<Integer>li=new ArrayList<>();
      dfs(root,li);
      Collections.sort(li);
      return li.get(k-1);  
    }
}

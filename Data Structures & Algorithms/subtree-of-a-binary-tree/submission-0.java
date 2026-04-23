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
   public static void dfs(TreeNode root,TreeNode subRoot,List<TreeNode>li){
      if(root==null) return;
      if(root.val==subRoot.val){
         li.add(root);
      }
      dfs(root.left,subRoot,li);
      dfs(root.right,subRoot,li);
   }
   public static void dfs1(TreeNode root,TreeNode subRoot,List<Integer>li){
      if(root==null){
          li.add(101);
          return;
      }
         li.add(root.val);
      dfs1(root.left,subRoot,li);
      dfs1(root.right,subRoot,li);
   }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(root==null && subRoot==null) return true;
      List<TreeNode>li=new ArrayList<>();
      List<Integer>s=new ArrayList<>();
      dfs(root,subRoot,li);
      dfs1(subRoot,subRoot,s);
      for(int i=0;i<li.size();i++){
         List<Integer>a=new ArrayList<>();
          dfs1(li.get(i),subRoot,a);
          if(a.equals(s)) return true;
      }
      return false;
    }
}

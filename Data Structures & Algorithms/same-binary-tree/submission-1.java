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
    public static void dfs(TreeNode p,List<Integer>lp){
        if(p==null){
           lp.add(101); 
           return;
        } 
        
        else{
           lp.add(p.val);
        }
        
        dfs(p.left,lp);
        dfs(p.right,lp);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
      
      List<Integer>lp=new ArrayList<>();
      List<Integer>lq=new ArrayList<>();
      dfs(p,lp);
      dfs(q,lq);
      if(lp.equals(lq)) return true;
      return false;
    }
}

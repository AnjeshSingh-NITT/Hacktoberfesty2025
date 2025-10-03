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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return f(postorder,inorder,0,inorder.length-1,0,inorder.length-1);
    }
    public TreeNode f(int []post,int []in, int p1,int p2, int i1, int i2)
    {
        if(p1>p2 || i1>i2) return null;
        TreeNode root = new TreeNode(post[p2]);
        int ind = map.get(post[p2]);
        int len = ind-i1;

        root.left = f(post,in,p1,p1+len-1,i1,ind-1);
        root.right = f(post,in,p1+len,p2-1,ind+1,i2);

        return root;
    }
}

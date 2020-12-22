//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 801 👎 0

  package com.hll.leetcode.editor.en;
  public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder== null || inorder == null || preorder.length==0 || inorder.length==0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>(); //HashMap把中序遍历数组的每个元素的值和下标存起来
        for ( int i = 0;i<inorder;i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length,map);
    }
    private TreeNode buildTree(int [] preorder,int p_start,int p_end,int [] inorder,int i_start,int i_end,HashMap<Integer,Integer>map ) {
        //preorder为空，直接返回
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        //在中序遍历中找到根节点位置
        int i_root_index = 0;
        for (int i = i_start;i<i_end;i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index - i_start;
        // 递归的构造左/右子树 ，画图得到指针指向 （左闭右开区间）
        root.left = buildTree(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index,map);
        root.right = buildTree(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end,map);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
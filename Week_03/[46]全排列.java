 package com.hll.leetcode.editor.en;
  public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> path = new LinkedList<>();
        boolean [] used = new boolean [nums.length];//用于存放数组中元素是否已被使用
        backTracking(nums,nums.length,0,used,path,result);  //数组从下标0开始搜索
        return result;
    }
    public void backTracking(int [] nums,int len,int depth,boolean [] used,List<Integer> path,List<List<Integer>> result) {
        //一、终止条件
        if (path.size() == len) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        for (int i = 0; i< nums.length;i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                // 递归 ,depth+1
                backTracking(nums,len,depth+1,used,path,result);
                // 回溯
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
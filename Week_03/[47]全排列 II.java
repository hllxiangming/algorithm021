  package com.hll.leetcode.editor.en;
  public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length==0){
            return result;
        }
        Arrays.sort(nums); //在搜索之前就对候选数组排序，一旦发现某个分支搜索下去可能搜索到重复的元素就停止搜索，这样结果集中不会包含重复列表
//        List<Integer> path = new LinkedList<>();
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>();
        boolean [] used = new boolean[nums.length];
        backTracking(nums,nums.length,0,used,path,result);
        return result;
    }

    public void backTracking(int [] nums,int len,int depth,boolean [] used, Deque<Integer> path,List<List<Integer>> result) {
        if (path.size() == len) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0;i<nums.length;i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i> 0 && nums[i-1] == nums[i] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backTracking(nums,len,depth+1,used,path,result);
            path.pollLast();
            used[i] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
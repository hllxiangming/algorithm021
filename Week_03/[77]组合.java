  package com.hll.leetcode.editor.en;
  public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>>  result = new LinkedList<>(); //存放符合条件结果集合
    private Deque<Integer> path = new LinkedList<>(); //用来存放单次符合条件结果
    public List<List<Integer>> combine(int n, int k) {  //k -->深度 n-->广度
        if  (k <= 0 || n < k) {
            return result;
        }
        backTracing(n,k,1);
        return result;
    }
    public void backTracing(int n,int k,int startIndex) {
        //一、终止条件
        if (path.size() == k){
            result.add(new LinkedList<>(path));
            return;
        }
        // 二、处理当前层逻辑
        for (int i = startIndex; i <= n-(k-path.size())+1; i++){  // 剪枝（i<=n） -->优化过程：1、已选择元素个数：path.size(),2、还需要：k-path.size() 3、在集合n中至少从: n-(k-path.size())+1
            path.addLast(i);
//            System.out.println("递归之前 => " + path);
            backTracing(n,k,i+1); //下一轮搜索，这只的搜索起点+1，组合无序，不包含重复元素
            path.pollLast(); //回溯，移除递归之前的操作
//            System.out.println("递归之后 => " + path);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
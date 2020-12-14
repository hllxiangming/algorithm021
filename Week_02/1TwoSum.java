class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 哈希表key存入数组值，value 存入对应下标。 a+b = target -->转换为哈希表中是否存在key为 a 和 target-b 问题
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0 ;i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int [] {hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i] , i);
        }
        return new int [0]; //返回空


    }
}
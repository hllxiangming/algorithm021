class Solution {
    public int[] twoSum(int[] nums, int target) {
        // ��ϣ��key��������ֵ��value �����Ӧ�±ꡣ a+b = target -->ת��Ϊ��ϣ�����Ƿ����keyΪ a �� target-b ����
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0 ;i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int [] {hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i] , i);
        }
        return new int [0]; //���ؿ�


    }
}
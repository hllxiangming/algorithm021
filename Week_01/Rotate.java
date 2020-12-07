class Rotate {
/* 189. ��ת����
����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
*/
    public void rotate(int[] nums, int k) {
        /*�ⷨ������ת���Σ�������ʵ������ת����k�Σ�k%n��β��Ԫ�ؽ����ƶ�������ͷ��
         ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
         */
        if (nums == null) {
            return;
        }
        k %= nums.length;  //���ڣ�������ʵ������ת����k�Σ�k%n��β��Ԫ�ؽ����ƶ�������ͷ��
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        
		//�ⷨһ�������ⷨ��ʱ�临�Ӷ�O��KN��,�ռ临�Ӷ�O(1)
        // int len = nums.length;
        // while (k>0)
        // {
        //     int temp = nums[len-1];
        //     for (int i = len-1;i>0;i--)
        //     {
        //         nums[i]= nums[i-1];
        //     }
        //     nums[0]= temp;
        //     k--;
        // }

    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }   
}
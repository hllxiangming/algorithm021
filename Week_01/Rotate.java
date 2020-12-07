class Rotate {
/* 189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*/
    public void rotate(int[] nums, int k) {
        /*解法二：旋转三次，基于事实：当旋转数组k次，k%n个尾部元素将会移动到数组头部
         时间复杂度O(n)，空间复杂度O(1)
         */
        if (nums == null) {
            return;
        }
        k %= nums.length;  //基于：基于事实：当旋转数组k次，k%n个尾部元素将会移动到数组头部
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        
		//解法一：暴力解法：时间复杂度O（KN）,空间复杂度O(1)
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
class RemoveDuplicates {
	/* 26. 删除排序数组中的重复项
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	*/
    public int removeDuplicates(int[] nums) {
// 解法二,双指针：快慢指针，时间复杂度O(n)，空间复杂度O(1)
if (nums.length == 0 || nums == null) {
			return 0;
		}
		int i = 0,j = 1;
		while (j<nums.length)
		{
			if (nums[i]!=nums[j])
			{
				if (j-i>1) //条件：i和j本来就差一位，赋值要两者间隔超过1
				{
					nums[i+1]=nums[j];
				}
				i++;
			}
			j++;
		}
		return i+1;
    }

	/*解法一：暴力解法，时间复杂度 O(n^2),空间复杂度O(1)：

if (nums.length == 0 || nums == null) {
			return 0;
		}
		int i, j, cnt = 0;
		for (i = 0; i < nums.length - 1 - cnt; i++) {
			j = i + 1;
			while (nums[i] == nums[j]) {
				if (j == nums.length - 1 - cnt) {
					cnt++;
					break;
				}

				for (int k = j; k < nums.length; k++) {
					nums[k - 1] = nums[k];
				}
				cnt++;
			}
		}
		return nums.length - cnt; */
}
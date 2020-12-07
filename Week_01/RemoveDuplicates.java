class RemoveDuplicates {
	/* 26. ɾ�����������е��ظ���
����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
	*/
    public int removeDuplicates(int[] nums) {
// �ⷨ��,˫ָ�룺����ָ�룬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
if (nums.length == 0 || nums == null) {
			return 0;
		}
		int i = 0,j = 1;
		while (j<nums.length)
		{
			if (nums[i]!=nums[j])
			{
				if (j-i>1) //������i��j�����Ͳ�һλ����ֵҪ���߼������1
				{
					nums[i+1]=nums[j];
				}
				i++;
			}
			j++;
		}
		return i+1;
    }

	/*�ⷨһ�������ⷨ��ʱ�临�Ӷ� O(n^2),�ռ临�Ӷ�O(1)��

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
/*
选择排序：首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中找到最小，直到所有排序
关键：1、每次都保存最小数，与R[i]交换，不稳定排序
	  2、时间复杂度为n平方
*/

class SelectSort 
{
	//排序数组大小
	int n = 0;

	//排序函数
	void sort(int[] a){
		this.n = a.length;

		//i为要选择的，a[i]上的数
		for (int i=0; i< n-1; i++)
		{
			//最小值
			int min = a[n-1];
			int minj = n-1;

			//待排序序列遍历
			for (int j = n-1; j >= i; j --)
			{
				//与最小值比较
				if (a[j] < min)
				{
					min = a[j];
					minj = j;
				}
			}

			if (minj != i)
			{
				//交换
				int temp = a[i];
				a[i] = min;
				a[minj] = temp;
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********选择排序**********");
		//待排序数组
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		SelectSort bs = new SelectSort();
		bs.sort(a);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

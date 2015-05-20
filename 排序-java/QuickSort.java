/*
快速排序
思想：分治法，分解、求解、组合。将原问题分解为若干个规模更小但结构与原问题相似的子问题，递归地解子问题，将子问题的解组合为原问题的解
关键：1、Partition，找到一个pivot，以此为基准，划分左右两个子区间，左区间小于等于pivot，右区间大于Pivot
	  2、对左右两个子区间递归求解
	  3、用i、j两个游标控制，i为第一个不小于Pivot的位置，j为遍历位置
*/

class QuickSort 
{
	//排序数组大小
	int n = 0;

	//划分函数
	int partition(int[] a, int low, int high){
		int i = low;
		int j = low;
		
		//选出pivot
		int pivot = a[high];

		//j每一次都要加1
		for (; j < high; j++)
		{
			if (a[j] <= pivot)
			{
				if (i != j)
				{	
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					//for (int k=0; k<a.length; k++)
					//{
						//System.out.print(a[k]+" ");
					//}
					//System.out.println(" ");
				}
				//小于等于
				i ++;
			}else{
				//大于
			}
		}

		//交换
		if (high != i)
		{
			a[high] = a[i];
			a[i] = pivot;
		}
		System.out.println("*********i*********"+i);
		return i;
	}

	//排序函数
	void sort(int[] a, int low, int high){
		
		if (low < high)
		{
			//划分位置
			int partiPos = partition(a, low, high);
			//递归
			sort(a, low, partiPos-1);
			sort(a, partiPos+1, high);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********快速排序**********");
		//待排序数组
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		QuickSort bs = new QuickSort();
		bs.sort(a, 0, a.length-1);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

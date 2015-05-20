/*
冒泡排序：两两比较待排序记录的关键字，发现两个记录的次序相反时即进行交换，直到没有反序的记录为止
关键：1、至多比较n-1趟，若某一趟无位置交换，则有序（设置标志位）
	  2、每一趟中都是相邻两个数字比较，依次比较（R[n], R[n-1]），（R[n-1], R[n-2]），... ，（R[2], R[1]）
	  3、经过n-1次扫描可得到有序区R[1..n]
*/

class BubbleSort 
{
	//是否交换的标志
	boolean exchange = false;

	//排序数组大小
	int n = 0;

	//排序函数
	void sort(int[] a){
		this.n = a.length;
		//i为趟数
		for (int i=0; i< n-1; i++)
		{
			this.exchange = false;

			//比较待排序区域
			for (int j = n-1; j > i; j --)
			{
				//交换
				if (a[j] < a[j-1])
				{
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					this.exchange = true;
				}

			}

			//没有交换则跳出
			if (!exchange)
			{
				return;
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********冒泡排序**********");
		//待排序数组
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		BubbleSort bs = new BubbleSort();
		bs.sort(a);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

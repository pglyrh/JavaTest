/*
希尔排序
思想：将数据进行分组，然后对每一组数据进行排序，在每一组数据都有序之后，就可以对所有的分组利用插入排序进行最后一次排序
关键：1、先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组，所有距离为d1的记录放在同一个组中
	  2、然后取下一个增量，直至所取得增量dt = 1
	  3、最后一个增量必须为1，尽量避免序列中的值互为倍数
*/

class ShellSort 
{
	//排序数组大小
	int n = 0;

	void sort(int[] a, int[] d){
		for (int i = 0; i< d.length; i++)
		{
			//获得增量
			int di = d[i];
			for (int j = 0; j+di < a.length; j++)
			{
				if (a[j+di] < a[j])
				{
					//交换
					int temp = a[j];
					a[j] = a[j+di];
					a[j+di] = temp;
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********希尔排序**********");
		//待排序数组
		int[] a = {4,2,1,6,3,6,0,-5,1,1};
		//增量数组
		int[] d = {5, 3, 2, 1};

		ShellSort  bs = new ShellSort ();
		bs.sort(a, d);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

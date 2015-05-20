/*
插入排序
关键：1、从第一个元素开始，该元素可以认为已经被排序
	  2、取出下一个元素，在已经排序的元素序列中从后向前扫描。
	  3、如果该元素大于新元素，则将该元素移到下一位置
	  4、重复3，直到找到已排序的元素小于或者等于新元素的位置
	  5、将新元素插入到该位置中
	  6、重复2
*/

class InsertSort 
{
	//排序数组大小
	int n = 0;

	//排序函数
	void sort(int[] a){
		this.n = a.length;

		//i为要排的下标为i的数
		for (int i=1; i< n; i++)
		{
			//与已排好序的序列依次比较，插入合适位置
			for (int j = i; j > 0; j --)
			{
				//与最小值比较
				if (a[j] < a[j-1])
				{
					//交换
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}else{
					break;	
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********插入排序**********");
		//待排序数组
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		InsertSort bs = new InsertSort();
		bs.sort(a);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

/*
归并排序
思想：分治法，分解、求解、组合。将两个已经有序的子序列合并，使其完全有序，关键是合并
关键：1、二路划分（mid处划分），申请两个新空间，依次比较大小，合并
	  2、稍作修改可求逆序对，
	  if(i != nl)
		count += nl-i;
*/
import java.math.*;

class MergeSort 
{
	//排序数组大小
	int count = 0;

	//合并函数
	void merge(int[] a, int low, int mid, int high){
		//左右两边的大小
		int ln = mid-low+1;
		int rn = high-mid;
		System.out.println("ln: " + ln+" rn: "+rn);
		//申请额外空间
		int[] l = new int[ln+1];
		int[] r = new int[rn+1];

		//复制数组
		for (int i = 0; i < ln; i++)
		{
			l[i] = a[low+i];
		}
		for (int j = 0; j < rn; j++)
		{
			r[j] = a[mid+1+j];
		}

		l[ln] = Integer.MAX_VALUE;
		r[rn] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;

		//比较，添加
		for (int k = low; k <= high ; k++)
		{
			if (l[i] <= r[j])
			{
				//左边更小
				a[k] = l[i]; 
				i ++;
			}else{
				a[k] = r[j];
				j ++;
				//逆序对
				if(i != ln)
					count += ln-i;
			}
		}

	}

	//排序函数
	void sort(int[] a, int low, int high){
		
		if (low < high)
		{
			//划分位置
			int mid = (low+high)/2;
			System.out.println("mid: " + mid);
			//递归
			sort(a, low, mid);
			sort(a, mid+1, high);
			//合并
			merge(a,low,mid,high);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********归并排序**********");
		//待排序数组
		//int[] a = {4,2,1,6,3,6,0,-5,1,1};
		int[] a = {3,1,4,5,2};

		MergeSort bs = new MergeSort();
		bs.sort(a, 0, a.length-1);

		//打印
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}

		System.out.print("........逆序对" + bs.count);
	}
}

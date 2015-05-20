/*
��������
˼�룺���η����ֽ⡢��⡢��ϡ���ԭ����ֽ�Ϊ���ɸ���ģ��С���ṹ��ԭ�������Ƶ������⣬�ݹ�ؽ������⣬��������Ľ����Ϊԭ����Ľ�
�ؼ���1��Partition���ҵ�һ��pivot���Դ�Ϊ��׼�������������������䣬������С�ڵ���pivot�����������Pivot
	  2������������������ݹ����
	  3����i��j�����α���ƣ�iΪ��һ����С��Pivot��λ�ã�jΪ����λ��
*/

class QuickSort 
{
	//���������С
	int n = 0;

	//���ֺ���
	int partition(int[] a, int low, int high){
		int i = low;
		int j = low;
		
		//ѡ��pivot
		int pivot = a[high];

		//jÿһ�ζ�Ҫ��1
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
				//С�ڵ���
				i ++;
			}else{
				//����
			}
		}

		//����
		if (high != i)
		{
			a[high] = a[i];
			a[i] = pivot;
		}
		System.out.println("*********i*********"+i);
		return i;
	}

	//������
	void sort(int[] a, int low, int high){
		
		if (low < high)
		{
			//����λ��
			int partiPos = partition(a, low, high);
			//�ݹ�
			sort(a, low, partiPos-1);
			sort(a, partiPos+1, high);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********��������**********");
		//����������
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		QuickSort bs = new QuickSort();
		bs.sort(a, 0, a.length-1);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

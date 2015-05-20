/*
�鲢����
˼�룺���η����ֽ⡢��⡢��ϡ��������Ѿ�����������кϲ���ʹ����ȫ���򣬹ؼ��Ǻϲ�
�ؼ���1����·���֣�mid�����֣������������¿ռ䣬���αȽϴ�С���ϲ�
	  2�������޸Ŀ�������ԣ�
	  if(i != nl)
		count += nl-i;
*/
import java.math.*;

class MergeSort 
{
	//���������С
	int count = 0;

	//�ϲ�����
	void merge(int[] a, int low, int mid, int high){
		//�������ߵĴ�С
		int ln = mid-low+1;
		int rn = high-mid;
		System.out.println("ln: " + ln+" rn: "+rn);
		//�������ռ�
		int[] l = new int[ln+1];
		int[] r = new int[rn+1];

		//��������
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

		//�Ƚϣ����
		for (int k = low; k <= high ; k++)
		{
			if (l[i] <= r[j])
			{
				//��߸�С
				a[k] = l[i]; 
				i ++;
			}else{
				a[k] = r[j];
				j ++;
				//�����
				if(i != ln)
					count += ln-i;
			}
		}

	}

	//������
	void sort(int[] a, int low, int high){
		
		if (low < high)
		{
			//����λ��
			int mid = (low+high)/2;
			System.out.println("mid: " + mid);
			//�ݹ�
			sort(a, low, mid);
			sort(a, mid+1, high);
			//�ϲ�
			merge(a,low,mid,high);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********�鲢����**********");
		//����������
		//int[] a = {4,2,1,6,3,6,0,-5,1,1};
		int[] a = {3,1,4,5,2};

		MergeSort bs = new MergeSort();
		bs.sort(a, 0, a.length-1);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}

		System.out.print("........�����" + bs.count);
	}
}

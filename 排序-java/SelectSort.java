/*
ѡ������������δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ�ã�Ȼ���ٴ�ʣ��δ����Ԫ�����ҵ���С��ֱ����������
�ؼ���1��ÿ�ζ�������С������R[i]���������ȶ�����
	  2��ʱ�临�Ӷ�Ϊnƽ��
*/

class SelectSort 
{
	//���������С
	int n = 0;

	//������
	void sort(int[] a){
		this.n = a.length;

		//iΪҪѡ��ģ�a[i]�ϵ���
		for (int i=0; i< n-1; i++)
		{
			//��Сֵ
			int min = a[n-1];
			int minj = n-1;

			//���������б���
			for (int j = n-1; j >= i; j --)
			{
				//����Сֵ�Ƚ�
				if (a[j] < min)
				{
					min = a[j];
					minj = j;
				}
			}

			if (minj != i)
			{
				//����
				int temp = a[i];
				a[i] = min;
				a[minj] = temp;
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********ѡ������**********");
		//����������
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		SelectSort bs = new SelectSort();
		bs.sort(a);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

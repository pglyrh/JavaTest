/*
ð�����������Ƚϴ������¼�Ĺؼ��֣�����������¼�Ĵ����෴ʱ�����н�����ֱ��û�з���ļ�¼Ϊֹ
�ؼ���1������Ƚ�n-1�ˣ���ĳһ����λ�ý��������������ñ�־λ��
	  2��ÿһ���ж��������������ֱȽϣ����αȽϣ�R[n], R[n-1]������R[n-1], R[n-2]����... ����R[2], R[1]��
	  3������n-1��ɨ��ɵõ�������R[1..n]
*/

class BubbleSort 
{
	//�Ƿ񽻻��ı�־
	boolean exchange = false;

	//���������С
	int n = 0;

	//������
	void sort(int[] a){
		this.n = a.length;
		//iΪ����
		for (int i=0; i< n-1; i++)
		{
			this.exchange = false;

			//�Ƚϴ���������
			for (int j = n-1; j > i; j --)
			{
				//����
				if (a[j] < a[j-1])
				{
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					this.exchange = true;
				}

			}

			//û�н���������
			if (!exchange)
			{
				return;
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********ð������**********");
		//����������
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		BubbleSort bs = new BubbleSort();
		bs.sort(a);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

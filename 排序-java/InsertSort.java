/*
��������
�ؼ���1���ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
	  2��ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�衣
	  3�������Ԫ�ش�����Ԫ�أ��򽫸�Ԫ���Ƶ���һλ��
	  4���ظ�3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��
	  5������Ԫ�ز��뵽��λ����
	  6���ظ�2
*/

class InsertSort 
{
	//���������С
	int n = 0;

	//������
	void sort(int[] a){
		this.n = a.length;

		//iΪҪ�ŵ��±�Ϊi����
		for (int i=1; i< n; i++)
		{
			//�����ź�����������αȽϣ��������λ��
			for (int j = i; j > 0; j --)
			{
				//����Сֵ�Ƚ�
				if (a[j] < a[j-1])
				{
					//����
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
		System.out.println("**********��������**********");
		//����������
		int[] a = {4,2,1,6,3,6,0,-5,1,1};

		InsertSort bs = new InsertSort();
		bs.sort(a);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

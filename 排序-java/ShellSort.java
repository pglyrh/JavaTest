/*
ϣ������
˼�룺�����ݽ��з��飬Ȼ���ÿһ�����ݽ���������ÿһ�����ݶ�����֮�󣬾Ϳ��Զ����еķ������ò�������������һ������
�ؼ���1����ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼�ֳ�d1���飬���о���Ϊd1�ļ�¼����ͬһ������
	  2��Ȼ��ȡ��һ��������ֱ����ȡ������dt = 1
	  3�����һ����������Ϊ1���������������е�ֵ��Ϊ����
*/

class ShellSort 
{
	//���������С
	int n = 0;

	void sort(int[] a, int[] d){
		for (int i = 0; i< d.length; i++)
		{
			//�������
			int di = d[i];
			for (int j = 0; j+di < a.length; j++)
			{
				if (a[j+di] < a[j])
				{
					//����
					int temp = a[j];
					a[j] = a[j+di];
					a[j+di] = temp;
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**********ϣ������**********");
		//����������
		int[] a = {4,2,1,6,3,6,0,-5,1,1};
		//��������
		int[] d = {5, 3, 2, 1};

		ShellSort  bs = new ShellSort ();
		bs.sort(a, d);

		//��ӡ
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

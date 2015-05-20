/**
* ��ά�����еĲ��ң�ÿһ�ж����մ����ҵ�����˳�����У�ÿһ�ж����մ��ϵ��µĵ���˳������
* �ؼ��������ҵ��������Ͻǵ����Ƚϣ��������Ͻǵ�������ɾ�������У��������Ͻ���С����ɾ��������
*		��������������С��1�������δ�ҵ�
*/
class FindInPartiallySortedMatrix 
{
	// Ҫ���ҵ�����
	int find;
	// ����
	int [][]a;
	// ������ݺ�ά��
	int row, col;

	// ���캯��
	public FindInPartiallySortedMatrix(int [][]a, int find){
		this.find = find;
		this.a = a;
		this.row = a.length;
		this.col = a[0].length;
	}

	// ���ң��ҵ�����true
	public boolean findNum(){
		if (a != null && row > 0 && col > 0)
		{
			// �����Ͻǿ�ʼ����
			int i = 0;
			int j = col - 1;
			while (i < row && j >= 0)
			{
				if (a[i][j] == find)
				{
					// �ҵ�
					System.out.println("i: "+i+" j: "+j);
					return true;
				}else if (a[i][j] > find)
				{
					// ���Ͻǵ������������ҵ������޳�������
					j --;
				}else{
					// ���Ͻǵ���С�������ҵ������޳�������
					i ++;
				}
			}
		}
		
		// δ�ҵ�
		System.out.println("δ�ҵ�");
		return false;
	}

	public static void main(String[] args) 
	{
		System.out.println("***********��ά�����еĲ���***********");
		// ����
		int [][]a = {{1,2,8,9},
							{2,4,9,12},
							{4,7,10,13},
							{6,8,11,15}};
		FindInPartiallySortedMatrix f = new FindInPartiallySortedMatrix(a, 7);
		f.findNum();
	}
}

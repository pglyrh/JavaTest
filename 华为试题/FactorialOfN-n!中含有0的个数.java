package first;

/*
 * ����:	����n!���ж��ٸ�0
 * ����:	n����ʾ�׳�
 * ���:	0�ĸ���
 * ����:	0�ĸ���   
 * �ؼ���5��������ÿ��5�������һ��0��5*5����һ��0��5*5*5��һ��0
 * ���磺	100��=> 100/5+100/25=24
 * 		2009�� => 2009/5=401�� 401/5=80��80/5=16�� 16/5=3�� 3/5=0
 * 				�ʽ��Ϊ��401+80+16+3=500
*/

public class FactorialOfN {

	public static int getZeroCount(int n)
	{
		// ����5��Ľ��
		int res = n;
		// 0�ļ���
		int count = 0;
		
		// շת�����ֻҪ�̴���0�����������5
		while (res > 0) {
			res = res/5;
			count += res;
		}

		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        System.out.println("100: "+getZeroCount(100));
        System.out.println("2009: "+getZeroCount(2009));
	}
}

package first;

/**
 * 
 * @param String s �����ַ���
 * 
 * @description�� 
 *     �ж��ַ����Ƿ�����Ч���֣��Ƿ���0�����Ƿ���-1
 *    
 * @example:
 *     123.456 ����Ч���֣�����0
 *     123a ������Ч���֣�����-1
 *     
 * ֪ʶ�㣺ʹ��Double���Դ��ľ�̬������
 */
public class SignificantDigit {

	public static int NumType(String s)
	{
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			// �׳��쳣������Ч����
			return -1;
		}
		// δ�׳��쳣����0
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res1 = NumType("123.456");
        System.out.println("res1: "+res1);
        
        int res2 = NumType("123a");
        System.out.println("res2: "+res2);
        
        int res3 = NumType("123.456d");
        System.out.println("res3: "+res3);
	}
}

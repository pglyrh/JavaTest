package first;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
����: ���M��N�η��������λ��(M��N������10)
���������
    int M��M > 10
    int N��N > 10
����ֵ��
    M��N�η��������λ��
*/
public class HighPowerTail {

	// ��M��N�η�
	int m, n;
	
	public HighPowerTail(int m, int n) {
		this.m = m;
		this.n = n;
	}
	
	// ����1����Ϊβ������λֻ��ÿ����˽���ĺ���λ�йأ����Խ�����һ������ǰֻ�������λ
	public int getLast3DigitsOfMN1()
	{
	    /*������ʵ�ֹ���*/
		// ��ʼ��������Mֻʣ����λ
		int M = m%1000;
		
		// tail��������ÿһ�κ���λ���
		int tail = 1;
		
		for (int i = 0; i < n; i++) {
			tail = tail*M%1000;
		}
		
		System.out.println("getLast3DigitsOfMN1()"+tail);
		
	    return 0;
	}
	
	// ����2������BigDecimal/BigInteger����
	public int getLast3DigitsOfMN2()
	{
		// ��ת��M��N
		BigInteger bigM = new BigInteger(String.valueOf(m));
		BigInteger bigN = new BigInteger(String.valueOf(n));
		BigInteger res = bigM.modPow(bigN, new BigInteger(String.valueOf(1000)));
		
		System.out.println("getLast3DigitsOfMN2()"+res.toString());
		
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HighPowerTail highPowerTail = new HighPowerTail(279789797, 45);
		highPowerTail.getLast3DigitsOfMN1();
		highPowerTail.getLast3DigitsOfMN2();
	}

}

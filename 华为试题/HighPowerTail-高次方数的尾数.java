package first;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
功能: 求解M的N次方的最后三位数(M，N均大于10)
输入参数：
    int M：M > 10
    int N：N > 10
返回值：
    M的N次方的最后三位数
*/
public class HighPowerTail {

	// 求M的N次方
	int m, n;
	
	public HighPowerTail(int m, int n) {
		this.m = m;
		this.n = n;
	}
	
	// 方法1，因为尾数后三位只与每次相乘结果的后三位有关，所以进入下一次运算前只保存后三位
	public int getLast3DigitsOfMN1()
	{
	    /*在这里实现功能*/
		// 初始化，先令M只剩后三位
		int M = m%1000;
		
		// tail用来保存每一次后三位结果
		int tail = 1;
		
		for (int i = 0; i < n; i++) {
			tail = tail*M%1000;
		}
		
		System.out.println("getLast3DigitsOfMN1()"+tail);
		
	    return 0;
	}
	
	// 方法2，利用BigDecimal/BigInteger计算
	public int getLast3DigitsOfMN2()
	{
		// 先转换M和N
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

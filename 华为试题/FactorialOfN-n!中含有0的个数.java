package first;

/*
 * 功能:	计算n!中有多少个0
 * 输入:	n，表示阶乘
 * 输出:	0的个数
 * 返回:	0的个数   
 * 关键：5的数量，每个5个，会多一个0；5*5个多一个0；5*5*5多一个0
 * 例如：	100！=> 100/5+100/25=24
 * 		2009！ => 2009/5=401， 401/5=80，80/5=16， 16/5=3， 3/5=0
 * 				故结果为：401+80+16+3=500
*/

public class FactorialOfN {

	public static int getZeroCount(int n)
	{
		// 除以5后的结果
		int res = n;
		// 0的计数
		int count = 0;
		
		// 辗转相除，只要商大于0，则继续除以5
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

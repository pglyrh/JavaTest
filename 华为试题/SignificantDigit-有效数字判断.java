package first;

/**
 * 
 * @param String s 输入字符串
 * 
 * @description： 
 *     判断字符串是否是有效数字，是返回0，不是返回-1
 *    
 * @example:
 *     123.456 是有效数字，返回0
 *     123a 不是有效数字，返回-1
 *     
 * 知识点：使用Double类自带的静态方法。
 */
public class SignificantDigit {

	public static int NumType(String s)
	{
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			// 抛出异常不适有效数字
			return -1;
		}
		// 未抛出异常返回0
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

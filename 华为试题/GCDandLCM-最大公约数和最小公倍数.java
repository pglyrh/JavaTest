package first;

// 功能：获取两个整数的最大公约数和最小公倍数
// 输入：两个整数
// 返回：最大公约数，最小公倍数
// 算法：辗转相除法
/*1. a ÷ b，令r为所得余数（0≤r<b）

	若 r = 0，算法结束；b 即为答案。

2. 互换：置 a←b，b←r，并返回第一步
	gcd(a,b) = gcd(b,r)
	
3. 两数乘积除以最大公约，就是最小公倍
*/
public class GCDandLCM {

    // 返回：最大公约数
    public static long getMaxDivisor(long lFirstInput, long lSecondInput)
    {
    	// 判断是否有0
    	if (lFirstInput == 0 || lSecondInput == 0) {
    		return 0;
    	}
    	
        // 用两个变量，保存参数（比较大小，决定除数和被除数）
    	long max = Math.max(lFirstInput, lSecondInput);
    	long min = Math.min(lFirstInput, lSecondInput);    	
    	
    	// 辗转相除，若大数除以小数可除尽，则小数为最大公约数
    	long res = max % min;
    	if (res == 0) {
			return min;
		}else {
			// 辗转相除，调用互换步骤（条件是除数不为0）
			while (min > 0) {
				max = min;
				min = res;
				res = max % min;
				if (res == 0) {
					// 除尽，返回min
					return min;
				}
			}
		}
    	
        return 0;
    }
    
    // 返回：最小公倍数
    public static long getMinMultiple(long lFirstInput, long lSecondInput)
    {
    	// 判断是否有0
    	if (lFirstInput == 0 || lSecondInput == 0) {
    		return 0;
    	}
    	
        // 获得最大公约数
    	long gcd = getMaxDivisor(lFirstInput, lSecondInput);
    	
    	// 乘积除以最大公约就是最小公倍
        return (lFirstInput*lSecondInput)/gcd;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("getMaxDivisor(15, 10): "+getMaxDivisor(15, 10));
		System.out.println("getMaxDivisor(3, 8): "+getMaxDivisor(3, 8));
		System.out.println("getMaxDivisor(5, 3): "+getMaxDivisor(5, 3));
		System.out.println("getMaxDivisor(0, 3): "+getMaxDivisor(0, 3));

		System.out.println("getMinMultiple(15, 10): "+getMinMultiple(15, 10));
		System.out.println("getMinMultiple(3, 8): "+getMinMultiple(3, 8));
		System.out.println("getMinMultiple(5, 3): "+getMinMultiple(5, 3));
		System.out.println("getMinMultiple(3, 0): "+getMinMultiple(3, 0));
	}

}

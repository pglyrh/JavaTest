package first;

// ���ܣ���ȡ�������������Լ������С������
// ���룺��������
// ���أ����Լ������С������
// �㷨��շת�����
/*1. a �� b����rΪ����������0��r<b��

	�� r = 0���㷨������b ��Ϊ�𰸡�

2. �������� a��b��b��r�������ص�һ��
	gcd(a,b) = gcd(b,r)
	
3. �����˻��������Լ��������С����
*/
public class GCDandLCM {

    // ���أ����Լ��
    public static long getMaxDivisor(long lFirstInput, long lSecondInput)
    {
    	// �ж��Ƿ���0
    	if (lFirstInput == 0 || lSecondInput == 0) {
    		return 0;
    	}
    	
        // ����������������������Ƚϴ�С�����������ͱ�������
    	long max = Math.max(lFirstInput, lSecondInput);
    	long min = Math.min(lFirstInput, lSecondInput);    	
    	
    	// շת���������������С���ɳ�������С��Ϊ���Լ��
    	long res = max % min;
    	if (res == 0) {
			return min;
		}else {
			// շת��������û������裨�����ǳ�����Ϊ0��
			while (min > 0) {
				max = min;
				min = res;
				res = max % min;
				if (res == 0) {
					// ����������min
					return min;
				}
			}
		}
    	
        return 0;
    }
    
    // ���أ���С������
    public static long getMinMultiple(long lFirstInput, long lSecondInput)
    {
    	// �ж��Ƿ���0
    	if (lFirstInput == 0 || lSecondInput == 0) {
    		return 0;
    	}
    	
        // ������Լ��
    	long gcd = getMaxDivisor(lFirstInput, lSecondInput);
    	
    	// �˻��������Լ������С����
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

package first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * С���Ǹ�������ĳ������������������˫���ӣ�n<20��
 *  ���ӵĳ��Ȳ�����ͬ������ȫ�����Ӷ����ڹ���������ûؼң�·�ϲ�С��©��һ��
 *  �����ó�������ҳ���©���Ŀ����Ƕ೤�ġ�
 * 
 * 
 * @param chopsticks  ʣ�µĿ������飬�磺1, 2, 3, 2, 1, 3, 2
 * @return int ©���Ŀ��ӳ��ȣ����������뷵�أ�2��������Ŀ��������쳣ʱ����-1���磺�Ҳ���©���Ŀ��ӣ�
 * 
 */
public class ChopsticksOfMing {

    public static int checkChopsticks(int[] chopsticks)
    {
    	// ��HashMap����
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    	// �������飬����Map�е�ֵ
    	for (int i = 0; i < chopsticks.length; i++) {
    		if (!hashMap.containsKey(chopsticks[i])) {
    			hashMap.put(chopsticks[i], 1);						
    		}else {
    			int count = (int)hashMap.get(chopsticks[i])+1;
    			hashMap.put(chopsticks[i], count);	
    		}			
		}
    	
    	// ����map�����ص�������
    	Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
    	while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			// valueΪ���������ؿ��ӵ�keyֵ
			if (entry.getValue()%2 != 0) {
				return entry.getKey();
			}		
		}
    
    	// �쳣�������-1
        return -1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] chopsticks1 = {1, 2, 3, 2, 1, 3, 2};
		System.out.println("chopsticks1: "+checkChopsticks(chopsticks1));
		int[] chopsticks2 = {1, 2, 3, 2, 1, 3, 2, 2};
		System.out.println("chopsticks2: "+checkChopsticks(chopsticks2));
	}

}

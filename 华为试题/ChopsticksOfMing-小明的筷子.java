package first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 小明是个马大哈，某天他到超市买了若干双筷子（n<20）
 *  筷子的长度不尽相同，他把全部筷子都放在购物袋里面拿回家，路上不小心漏了一根
 *  请你用程序帮他找出是漏掉的筷子是多长的。
 * 
 * 
 * @param chopsticks  剩下的筷子数组，如：1, 2, 3, 2, 1, 3, 2
 * @return int 漏掉的筷子长度，如上述输入返回：2（当输入的筷子数据异常时返回-1，如：找不到漏掉的筷子）
 * 
 */
public class ChopsticksOfMing {

    public static int checkChopsticks(int[] chopsticks)
    {
    	// 用HashMap保存
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    	// 遍历数组，更新Map中的值
    	for (int i = 0; i < chopsticks.length; i++) {
    		if (!hashMap.containsKey(chopsticks[i])) {
    			hashMap.put(chopsticks[i], 1);						
    		}else {
    			int count = (int)hashMap.get(chopsticks[i])+1;
    			hashMap.put(chopsticks[i], count);	
    		}			
		}
    	
    	// 遍历map，返回单数筷子
    	Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
    	while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			// value为单数，返回筷子的key值
			if (entry.getValue()%2 != 0) {
				return entry.getKey();
			}		
		}
    
    	// 异常情况返回-1
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

package first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * Description : 实现整数排序，即先将从A输入的整型数序列进行排序，剔除重复整型数，输出得到的升序序列B；
 * Input       : array_A  输入参数，输入待排序整型数序列A
 * Return      : 排序后的整型数序列
 * */
public class IntegerSequenceOrder {
	
	// 排序
	public static int[] sort(int []array_A)
	{
		//	结果List
		List<Integer> res = new LinkedList<Integer>(); 
		int []array_B = null;
		
		// 先用集合保存去重后的数组元素
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array_A.length; i++) {
			// 添加成功，则表明不是重复元素，加入链表
			if(hashSet.add(array_A[i])){
				res.add(array_A[i]);
			}
		}
		
		// B数组初始化，且赋值
		array_B = new int[res.size()];
		for (int i = 0; i < array_B.length; i++) {
			array_B[i] = res.get(i);
		}
		
		// B数组排序
		Arrays.sort(array_B);
		
	    return array_B;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array_a[] = {32, 18, 74, 56, -16, 97, -50, -43, -80, 5, 87, 0};
//	    int expected[] = {-80, -50, -43, -16, 0, 5, 18, 32, 56, 74, 87, 97};
	

	    int[] actual = IntegerSequenceOrder.sort(array_a);
	    // 打印结果
	    for (int i = 0; i < actual.length; i++) {
			System.out.print(""+actual[i]+" ");
		}
	}

}

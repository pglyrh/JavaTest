package first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * Description : ʵ���������򣬼��Ƚ���A��������������н��������޳��ظ�������������õ�����������B��
 * Input       : array_A  ����������������������������A
 * Return      : ����������������
 * */
public class IntegerSequenceOrder {
	
	// ����
	public static int[] sort(int []array_A)
	{
		//	���List
		List<Integer> res = new LinkedList<Integer>(); 
		int []array_B = null;
		
		// ���ü��ϱ���ȥ�غ������Ԫ��
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array_A.length; i++) {
			// ��ӳɹ�������������ظ�Ԫ�أ���������
			if(hashSet.add(array_A[i])){
				res.add(array_A[i]);
			}
		}
		
		// B�����ʼ�����Ҹ�ֵ
		array_B = new int[res.size()];
		for (int i = 0; i < array_B.length; i++) {
			array_B[i] = res.get(i);
		}
		
		// B��������
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
	    // ��ӡ���
	    for (int i = 0; i < actual.length; i++) {
			System.out.print(""+actual[i]+" ");
		}
	}

}

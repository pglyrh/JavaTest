package first;

import java.util.Arrays;
import java.util.Comparator;

//���ܣ������������飬����Ԫ�ذ�����������������
// ���룺pIntegerArray ��Ҫ�������������
//       sortFlg 0:���� 1������
// ���أ�û���ظ����ֵ�����
public class SortAndFlag {

	public static void sortArray(Integer[] pIntegerArray, int sortFlg)
    {
        switch (sortFlg) {
		case 0:
			// ����
			Arrays.sort(pIntegerArray);
			break;
		case 1:
			// ������д�ȽϷ���
			Arrays.sort(pIntegerArray, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			break;
		default:
			break;
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] pIntArray = {5, 4, 7, 1, 3};       
        SortAndFlag.sortArray(pIntArray, 0);
        for (int i = 0; i < pIntArray.length; i++) {
			System.out.print(""+pIntArray[i]+" ");
		}
        System.out.println("");
//      Integer[] resultArray = {1, 3, 4, 5, 7};
		
        Integer[] pIntArray2 = {1, 3, 7, 4, 5};     
        SortAndFlag.sortArray(pIntArray2, 1);
        for (int i = 0; i < pIntArray2.length; i++) {
			System.out.print(""+pIntArray2[i]+" ");
		}
        System.out.println("");
//        Integer[] resultArray = {7, 5, 4, 3, 1};
		
	}

}

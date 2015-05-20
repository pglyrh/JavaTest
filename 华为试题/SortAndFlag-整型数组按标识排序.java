package first;

import java.util.Arrays;
import java.util.Comparator;

//功能：输入整型数组，对其元素按照升序或降序进行排序
// 输入：pIntegerArray 需要排序的整型数组
//       sortFlg 0:升序 1：降序
// 返回：没有重复数字的整型
public class SortAndFlag {

	public static void sortArray(Integer[] pIntegerArray, int sortFlg)
    {
        switch (sortFlg) {
		case 0:
			// 升序
			Arrays.sort(pIntegerArray);
			break;
		case 1:
			// 降序，重写比较方法
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

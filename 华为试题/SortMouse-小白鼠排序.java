package first;

import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;


/*����������������ñ����ɫ
 * ������	5ֻС���������ֱ�Ϊ15 30 5 9 30��
 * ñ����ɫ����ΪCL_RED, CL_BLUE, CL_BLUE, CL_YELLOW, CL_GRAY��
 * �������������ñ����ɫ����Ӧ��ΪCL_BLUE, CL_YELLOW, CL_RED, CL_BLUE, CL_GRAY��
	���û��С�������null��
���������С��������	
	
*/
// ��ɫö��
enum MOUSE_COLOR {
	CL_RED,
	CL_BLUE,
	CL_BLACK,
	CL_WHITE,
	CL_YELLOW,
	CL_PINK,
	CL_GRAY
}

// ������
class Mouse {
	public int weight;
	public MOUSE_COLOR color;	
	public Mouse()
	{
		
	}
	public Mouse(int weight,MOUSE_COLOR color)
	{
		this.weight =weight;
		this.color = color;
	}
}

public class SortMouse {

	// ��������
	Mouse[] mouses;
	
	SortMouse(Mouse[] mouses){
		this.mouses = mouses;
	}
	
    // ����
    public void sort(){
        // ���򣬽���
        Arrays.sort(mouses, new Comparator<Mouse>() {   
			@Override
			public int compare(Mouse o1, Mouse o2) {
				return o2.weight - o1.weight;
			}
        }); 
    }
    
    // ��ӡ
    public void printResult(){
    	// ����
    	sort();
    	// ��ӡ
    	for (int i = 0; i < mouses.length; i++) {
			System.out.print(""+mouses[i].color+" ");
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��������
		Mouse[] mouses = new Mouse[5];
		mouses[0] = new Mouse(15, MOUSE_COLOR.CL_RED);
		mouses[1] = new Mouse(30, MOUSE_COLOR.CL_BLUE);
		mouses[2] = new Mouse(5, MOUSE_COLOR.CL_BLUE);
		mouses[3] = new Mouse(9, MOUSE_COLOR.CL_YELLOW);
		mouses[4] = new Mouse(30, MOUSE_COLOR.CL_GRAY);
		
		SortMouse sortMouse = new SortMouse(mouses);
		sortMouse.printResult();
	}

}

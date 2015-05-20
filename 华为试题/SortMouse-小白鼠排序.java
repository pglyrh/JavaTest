package first;

import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;


/*根据重量排序后，输出帽子颜色
 * 举例：	5只小白鼠，重量分别为15 30 5 9 30，
 * 帽子颜色依次为CL_RED, CL_BLUE, CL_BLUE, CL_YELLOW, CL_GRAY，
 * 则排序后的输出的帽子颜色序列应该为CL_BLUE, CL_YELLOW, CL_RED, CL_BLUE, CL_GRAY。
	如果没有小白鼠，输出null。
输入参数：小白鼠数组	
	
*/
// 颜色枚举
enum MOUSE_COLOR {
	CL_RED,
	CL_BLUE,
	CL_BLACK,
	CL_WHITE,
	CL_YELLOW,
	CL_PINK,
	CL_GRAY
}

// 白鼠类
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

	// 白鼠数组
	Mouse[] mouses;
	
	SortMouse(Mouse[] mouses){
		this.mouses = mouses;
	}
	
    // 排序
    public void sort(){
        // 排序，降序
        Arrays.sort(mouses, new Comparator<Mouse>() {   
			@Override
			public int compare(Mouse o1, Mouse o2) {
				return o2.weight - o1.weight;
			}
        }); 
    }
    
    // 打印
    public void printResult(){
    	// 排序
    	sort();
    	// 打印
    	for (int i = 0; i < mouses.length; i++) {
			System.out.print(""+mouses[i].color+" ");
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 白鼠数组
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

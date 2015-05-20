package first;

/*
输入参数：

		int Month：整数，Redraiment到家的月数。
		int Day：整数，Redraiment到家的日期
输出参数：
		无
返回值：
		int  （返回Redraiment到家后遭遇停电的天数）
*/
public class Redraiment {

	// 一维数组，保存每个日子是否停电，1-无电，0-有电
	// 长度为31+31=62，其中0-30为7月，31-61为8月
	int[] flags = new int[62];
	
	// 构造函数
	public Redraiment() {
		// 停电间隔
		int i = 0;
		// 日期下标
		int j = 0;
		
		// 统计
		while (j < flags.length) {
			flags[j] = 1;
			i ++;
			j = j+i+1;
		}
		
//		// 打印结果，检测
//		for (int k = 0; k < flags.length; k++) {
//			System.out.print(""+flags[k]+" ");
//		}
	}
	
	public int getDayNum(int month, int day)
    {
		// 到家的那一天，对应的下标
		int start = 0;

		switch (month) {
		case 7:
			// 7月的下标从0开始
			start = day - 1;
			break;
		case 8:
			// 8月的下标从31开始
			start = 30 + day;
			break;
		default:
			break;
		}
		
		// 计数
		int count = 0;
		// 从start开始遍历数组，遇到标识为1，则计数加1
		for (int i = start; i < flags.length; i++) {
			if (flags[i] == 1) {
				count ++;
			}
		}
		
        return count;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Redraiment redraiment = new Redraiment();
		System.out.println("redraiment.getDayNum(7, 2): "
				+redraiment.getDayNum(7, 2));	// 9
		System.out.println("redraiment.getDayNum(8, 31): "
				+redraiment.getDayNum(8, 31)); 	// 0
	}

}

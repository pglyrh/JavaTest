package first;

/*
���������

		int Month��������Redraiment���ҵ�������
		int Day��������Redraiment���ҵ�����
���������
		��
����ֵ��
		int  ������Redraiment���Һ�����ͣ���������
*/
public class Redraiment {

	// һά���飬����ÿ�������Ƿ�ͣ�磬1-�޵磬0-�е�
	// ����Ϊ31+31=62������0-30Ϊ7�£�31-61Ϊ8��
	int[] flags = new int[62];
	
	// ���캯��
	public Redraiment() {
		// ͣ����
		int i = 0;
		// �����±�
		int j = 0;
		
		// ͳ��
		while (j < flags.length) {
			flags[j] = 1;
			i ++;
			j = j+i+1;
		}
		
//		// ��ӡ��������
//		for (int k = 0; k < flags.length; k++) {
//			System.out.print(""+flags[k]+" ");
//		}
	}
	
	public int getDayNum(int month, int day)
    {
		// ���ҵ���һ�죬��Ӧ���±�
		int start = 0;

		switch (month) {
		case 7:
			// 7�µ��±��0��ʼ
			start = day - 1;
			break;
		case 8:
			// 8�µ��±��31��ʼ
			start = 30 + day;
			break;
		default:
			break;
		}
		
		// ����
		int count = 0;
		// ��start��ʼ�������飬������ʶΪ1���������1
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

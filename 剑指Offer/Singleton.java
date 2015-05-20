/**
* ���һ���ֻ࣬�����ɸ����һ��ʵ����Singletonģʽ��
* �ؼ������캯����Ϊ˽��ģʽ��������һ��˽�о�̬ʵ�����������о�̬��������ʵ������
*       ���ǵ�ͬ���̰߳�ȫ������ʵ��ʱӦ��ͬ����
*/
class Singleton
{
	// ˽�б���
	private static Singleton instance = null;
	// test����
	private static int test = 0;

	// ���캯��
	private Singleton(){
		test ++;
		System.out.println("singleton: "+test);
	}

	// ����ʵ��
	public static Singleton getInstance(){
		// ��instanceΪnull�򴴽�����Ϊ�򷵻�
		if (instance == null)
		{
			// ͬ������
			synchronized(Singleton.class){
				// �ٴ��ж�
				if (instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	public static void main(String[] args) 
	{
		System.out.println("************Singleton************");
		for (int i = 0; i < 5; i++)
		{
			System.out.println("************"+i);
			Singleton.getInstance();
		}
	}
}

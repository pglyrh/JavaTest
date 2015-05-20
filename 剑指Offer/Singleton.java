/**
* 设计一个类，只能生成该类的一个实例（Singleton模式）
* 关键：构造函数设为私有模式，类中有一个私有静态实例变量，公有静态方法返回实例变量
*       考虑到同步线程安全，创建实例时应加同步锁
*/
class Singleton
{
	// 私有变量
	private static Singleton instance = null;
	// test变量
	private static int test = 0;

	// 构造函数
	private Singleton(){
		test ++;
		System.out.println("singleton: "+test);
	}

	// 返回实例
	public static Singleton getInstance(){
		// 若instance为null则创建，不为则返回
		if (instance == null)
		{
			// 同步加锁
			synchronized(Singleton.class){
				// 再次判断
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

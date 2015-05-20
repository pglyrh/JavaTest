/**
* 二维数组中的查找，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下的递增顺序排列
* 关键：将查找的数与右上角的数比较，若比右上角的数大，则删除所在行，若比右上角数小，则删除所在行
*		当行数或者列数小于1，则表明未找到
*/
class FindInPartiallySortedMatrix 
{
	// 要查找的数字
	int find;
	// 数组
	int [][]a;
	// 数组的纵横维度
	int row, col;

	// 构造函数
	public FindInPartiallySortedMatrix(int [][]a, int find){
		this.find = find;
		this.a = a;
		this.row = a.length;
		this.col = a[0].length;
	}

	// 查找，找到返回true
	public boolean findNum(){
		if (a != null && row > 0 && col > 0)
		{
			// 从右上角开始查找
			int i = 0;
			int j = col - 1;
			while (i < row && j >= 0)
			{
				if (a[i][j] == find)
				{
					// 找到
					System.out.println("i: "+i+" j: "+j);
					return true;
				}else if (a[i][j] > find)
				{
					// 右上角的数大于所查找的数，剔除所在列
					j --;
				}else{
					// 右上角的数小于所查找的数，剔除所在行
					i ++;
				}
			}
		}
		
		// 未找到
		System.out.println("未找到");
		return false;
	}

	public static void main(String[] args) 
	{
		System.out.println("***********二维数组中的查找***********");
		// 数组
		int [][]a = {{1,2,8,9},
							{2,4,9,12},
							{4,7,10,13},
							{6,8,11,15}};
		FindInPartiallySortedMatrix f = new FindInPartiallySortedMatrix(a, 7);
		f.findNum();
	}
}

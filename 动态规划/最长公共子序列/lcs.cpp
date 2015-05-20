/*
作者：余瑞寒
时间：2014/5/19
作用：利用动态规划实现矩阵链乘法
*/

#include <iostream>
#include <stdlib.h>
#include <limits.h>

//计算数组的长度
#define length(arr)  (sizeof(arr)/sizeof(arr[0]))

using namespace std;

//全局变量
int **c; //xi和yj的LCS长度
int **b; //最优解的构造
//int n = 6; //矩阵个数

void main(){
	cout <<"***************longest common sbusequence***************"<<endl;

	//定义两个子串序列
	char x[7] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
	char y[6] = {'B', 'D', 'C', 'A', 'B', 'A'};

	//声明函数，求出LCS的长度，参数为两个子序列数组以及数组的长度
	void lcsLength(char *, char *, int, int);

	//求出x和y的长度
	int m = length(x);
	int n = length(y);
	
	//打出x和y
	cout << "x: ";
	for(int i = 0; i < m; i++){
		cout<<x[i]<<" ";
	}
	cout<<endl;
	cout << "y: ";
	for(i = 0; i < n; i++){
		cout<<y[i]<<" ";
	}
	cout<<endl;

	//初始化
	c = new int *[m+1];
	//1表示向左，2表示斜向上，3表示向上
	b = new int *[m+1];
	for(i = 0; i <= m; i++){
		c[i] = new int[n+1];
		b[i] = new int[n+1];
	}

	lcsLength(x, y, m, n);

	cout <<"******************after******************"<<endl;
	
	//打出c
	cout<<"c: "<<endl;
	for(i = 0; i <= m; i++){
		for(int j = 0; j <= n; j++){
			//打出c[i][j]
			cout<<c[i][j]<<" ";
		}
		cout<<endl;
	}
	cout << endl;
	//打出b
	cout<<"b: "<<endl;
	for(i = 0; i <=m ; i++){
		for(int j = 0; j <= n; j++){
			//打出b[i][j]
			cout<<b[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

void lcsLength(char *x, char *y, int m, int n){
	//初始化i或j中含0的值为0
	for(int j = 0; j <= n; j++){
		c[0][j] = 0;
		b[0][j] = 0;
	}
	for(int i = 1; i <= m; i++){
		c[i][0] = 0;
		b[i][0] = 0;
	}

	//根据比较将值填入c表和b表
	for(i = 1; i <=m ; i++){ //i为行号
		for(j = 1; j <= n; j++){ //j为列号
			//判断
			if(x[i-1] == y[j-1]){//若匹配
				c[i][j] = c[i-1][j-1]+1;
				b[i][j] = 2;
			}else{ //不匹配
				if(c[i-1][j] >= c[i][j-1]){ //上方的值更大
					c[i][j] = c[i-1][j];
					b[i][j] = 3;
				}else{ //左方的值更大
					c[i][j] = c[i][j-1];
					b[i][j] = 1;
				}
			} 
		}
	}
}


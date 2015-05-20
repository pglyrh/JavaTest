/*
作者：余瑞寒
时间：2014/5/19
作用：利用动态规划实现矩阵链乘法
*/

#include <iostream>
#include <stdlib.h>
#include <limits.h>

//#define n 6

using namespace std;

//全局变量
int **m; //最优值
int **s; //分割点
int n = 6; //矩阵个数

void main(){
	cout <<"***************matrix-chain multiplication***************"<<endl;

	//声明函数，找出最优乘积顺序，参数为记录维度的数组
	void matrixChainOrder(int *);

	//定义一些参数
	//int n = 6; //矩阵个数
	//int *p; //记录维度的数组
	
	//初始化
	//p = new int[n+1];
	int p[7] = {30, 35, 15, 5, 10, 20, 25};

	m = new int *[n];
	for(int i = 0; i < n; i++){
		m[i] = new int[n];
	}

	s = new int *[n];
	for(i = 0; i < n; i++){
		s[i] = new int[n];
	}

	//对数组赋初值
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			s[i][j] = 0;
			m[i][j] = 0;
		}		
	}

	matrixChainOrder(p);

	cout <<"******************after******************"<<endl;
	//打出m
	cout<<"m: "<<endl;
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			//打出m[i][j]
			cout<<m[i][j]<<" ";
		}
		cout<<endl;
	}
	cout << endl;
	//打出s
	cout<<"s: "<<endl;
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			//打出s[i][j]
			cout<<s[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

void matrixChainOrder(int *p){
	//初始化m[i][i]的值
	for(int t = 0; t < n; t++){
		m[t][t] = 0;
	}

	//从对角线方向，依次填入每一个值
	for(int l = 2; l <=n ; l++){ //l为链长度
		for(int i = 0; i < n-l+1; i++){ //i为行号
			int j = i+l-1;                  //j为列号，由l来控制
			m[i][j] = INT_MAX;

			//试探k值
			for(int k = i; k < j; k++){
				int q = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1]; //q为当前k值的标量乘法数

				if(q<m[i][j]){
					//此k更好
					m[i][j] = q;
					s[i][j] = k+1;
				}
			}
		}
	}
}


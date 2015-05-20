/*
作者：余瑞寒
时间：2014/5/15
作用：利用动态规划实现装配线调度
*/

#include <iostream>
#include <stdlib.h>

#define n 6

using namespace std;

//全局变量
int f1[n], f2[n], l1[n], l2[n], _f, _l;

void main(){
	cout <<"***************assembly lines***************"<<endl;

	//声明函数，找出最快路径
	void fastestWay(int *,int *, int *,int *, int *,int *);

	//定义一些参数
	//int n = 6;
	int e[2] = {2,4};
	int x[2] = {3,2};
	int a1[n] = {7,9,3,4,8,4};
	int a2[n] = {8,5,6,4,5,7};
	int t1[n-1] = {2,3,1,3,4};
	int t2[n-1] = {2,1,2,2,1};

	fastestWay(a1, a2, t1, t2, e, x);

	cout <<"******************after******************"<<endl;
	//打出f1
	cout<<"f1: ";
	for(int i = 0; i < n; i++){
		//打出f1
		cout<<f1[i]<<" ";
	}
	cout << endl;
	//打出f2
	cout<<"f2: ";
	for(int j = 0; j < n; j++){
		//打出f2
		cout<<f2[j]<<" ";
	}
	cout << endl;
	//打出l1
	cout<<"l1: ";
	for(int k = 0; k < n; k++){
		//打出l1
		cout<<l1[k]<<" ";
	}
	cout << endl;
	//打出l2
	cout<<"l2: ";
	for(int y = 0; y < n; y++){
		//打出l1
		cout<<l2[y]<<" ";
	}
	cout << endl;
	
	//打出_f
	cout<<"_f: "<<_f<<endl;
	//打出_l
	cout<<"_l: "<<_l<<endl;
}

void fastestWay(int *a1,int *a2,int *t1,int *t2,int *e,int *x){
	//算出第一站的时间
	f1[0] = e[0] + a1[0];
	f2[0] = e[1] + a2[0];

	//算出两条线，每一站的最快时间
	for (int i = 1; i < n; i++){
		//第一条线
		if(f1[i-1]+a1[i] <= f2[i-1]+t2[i-1]+a1[i]){
			//上一站走第一条线更快
			f1[i] = f1[i-1]+a1[i];
			l1[i] = 1;
		}else{
			//上一站走第二条线更快
			f1[i] = f2[i-1]+t2[i-1]+a1[i];
			l1[i] = 2;
		}
		//第二条线
		if(f2[i-1]+a2[i] <= f1[i-1]+t1[i-1]+a2[i]){
			//上一站走第二条线更快
			f2[i] = f2[i-1]+a2[i];
			l2[i] = 2;
		}else{
			//上一站走第一条线更快
			f2[i] = f1[i-1]+t1[i-1]+a2[i];
			l2[i] = 1;
		}
	}

	//计算最终值
	if(f1[n-1]+x[0] <= f2[n-1]+x[1]){
		//从1号线出来较快
		_f = f1[n-1]+x[0];
		_l = 1;
	}else{
		//从2号线出来较快
		_f = f2[n-1]+x[1];
		_l = 2;
	}
}

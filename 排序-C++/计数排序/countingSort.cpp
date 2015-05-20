/*
作者：余瑞寒
时间：2014/4/15
作用：计数排序算法的实现
*/

#include <iostream>
#include <stdlib.h>

//定义求左右结点、父结点的函数
#define left(i) 2*i+1
#define right(i) 2*(i+1)
#define parent(i) (i-1)/2

#define length 7
//#define k 7

using namespace std;

//全局变量，当前待排序堆的大小
int heapsize = length;

void main(){
	cout <<"***************countingsort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//声明排序函数，参数为一个整型数组，起始位置和结束位置
	void countingsort(int *,int *, int);

	//定义数组
	//int a[length] = {2,4,3,7,6,1,5};
	int a[length] = {2,2,0,7,0,1,2};

	int b[length];
	int k = 7;
	//int a[length] = {2,4,1};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//调用排序函数
	countingsort(a, b, k);	

	cout <<"***************after***************"<<endl;
	//打出排序后的数据
	for(int l=0; l < length; l++){
		cout << b[l];
	}
	cout<<endl;
}

//堆排序函数，a为数组
void countingsort(int *a, int *b, int k){
	//动态申请一个数组
	int *c;
	c = new int[k+1];

	//给统计数组赋值
	for(int i= 0; i <= k; i++){
		//初始化为0
		c[i] = 0;
	}

	//统计每个数据的值
	for(int j= 0; j < length; j++){
		//初始化为0
		c[a[j]] ++;
	}
	
	//更新c数组的值
	for(int l= 1; l <= k; l++){
		//初始化为0
		c[l] = c[l]+c[l-1];
	}

	//调用排序
	for(int r= length-1; r >= 0; r--){
		b[c[a[r]]-1] = a[r];
		c[a[r]] --;
	}
}
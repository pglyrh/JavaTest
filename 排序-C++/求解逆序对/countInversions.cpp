/*
作者：余瑞寒
时间：2014/3/31
作用：求解逆序对的实现
*/

#include <iostream>
#include <stdlib.h>

#define length 7
/* maximum (signed) int value */
#define INT_MAX 2147483647 

using namespace std;

int count = 0;

void main(){
	cout <<"***************mergesort***************"<<endl;
	cout <<"***************before***************"<<endl;
	//声明排序函数，参数为一个整型数组
	void mergesort(int *,int, int);
	//定义数组
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};
	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;
	//调用排序函数
	mergesort(a,0,length-1);
	cout <<"***************after***************"<<endl;
	//打出原始数据
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl<<endl;
	//count = count+1;
	cout<<"逆序对数量："<<endl;
	cout<<"count: "<<count<<endl;
}

//归并排序函数，a为数组，p为起始位置，r为结束位置
void mergesort(int *a, int p, int r){
	//声明归并函数
	void merge(int *, int, int, int);
	//判断条件
	if(p < r){
		//计算中点位置
		int q = (p+r)/2;
		//递归
		mergesort(a, p, q);
		mergesort(a, q+1, r);
		merge(a,p,q,r);
	}
}

//归并函数
void merge(int *a, int p, int q, int r){
	//左边长度
	int nl = q - p + 1;
	//右边长度
	int rl = r - q;

	//int *arr = new int[变量或数值];
	//声明新的数组
	int *larr = new int[nl+1];
	int *rarr = new int[rl+1];
	for(int i=0; i < nl; i++){
		larr[i] = a[p+i];
	}
	for(int j=0; j < rl; j++){
		rarr[j] = a[q+1+j];
	}
	larr[nl] = INT_MAX;
	rarr[rl] = INT_MAX;

	//i,j置0
	i = 0;
	j = 0;
	//归并主体
	for(int k = p; k <= r; k ++){
		if(larr[i]<=rarr[j]){
			a[k] = larr[i];
			i ++;
		}else{
			a[k] = rarr[j];
			j ++;
			//cout<<"i: "<<i<<endl;
			//求解逆序对，只需添加这一句话
			if(i != nl){
				//cout<<"i != nl"<<endl;
				//count = count+nl-i;
				count += nl-i;
			}
		}
	}
}
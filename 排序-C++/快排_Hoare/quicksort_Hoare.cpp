/*
作者：余瑞寒
时间：2014/4/1
作用：快速排序_Hoare划分算法的实现
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 12

using namespace std;

void main(){
	cout <<"***************hoare_quicksort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//声明排序函数，参数为一个整型数组，起始位置和结束位置
	void hoare_quicksort(int *, int, int);

	//定义数组
	int a[length] = {13,19,9,5,12,8,7,4,11,2,6,21};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r]<<" ";
	}
	cout<<endl;

	cout <<"***************after***************"<<endl;
	//q = hoarePartition(a, 0, length-1);
	//cout<<"q: "<<q<<endl;
	//调用排序函数
	hoare_quicksort(a,0,length-1);
	
	//打出排序后的数据
	for(int l=0; l < length; l++){
		cout << a[l]<<" ";
	}
	cout<<endl<<endl;

}

void hoare_quicksort(int *a, int p, int r){
	int hoarePartition(int *, int, int);
	
	//判断条件
	if(p < r){
		//计算中点位置
		int q = hoarePartition(a,p,r);
		//cout << "q: "<<q;
		//cout << endl;

		//递归
		hoare_quicksort(a, p, q);
		hoare_quicksort(a, q+1, r);
	}

}

//Hoare划分函数，返回分割位置，指向最后一个小于pivot数的下标
int hoarePartition(int *a, int p, int r){
	//设第一个数为pivot
	int x = a[p];

	//设置i和j的初始位置
	int i = p-1;
	int j = r+1;
	//cout<<"x: "<<x<<" i: "<<i<<" j: "<<j<<endl;

	//进入循环体
	while(true){
		do{
			//j逐渐左移
			j --;
		}while(a[j] > x);
		
		do{
			//i逐渐右移
			i ++;
		}while(a[i] < x);
		
		//cout<<"i: "<<i<<" j: "<<j<<endl;

		if(i<j){
			//交换a[i]和a[j]
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}else{
			//返回位置
			return j;
		}
	}
}

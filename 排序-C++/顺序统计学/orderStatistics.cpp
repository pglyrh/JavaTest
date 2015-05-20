/*
作者：余瑞寒
时间：2014/5/15
作用：用快速排序中的划分函数实现顺序统计量
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 7

using namespace std;

void main(){
	cout <<"***************orderstatistics***************"<<endl;
	cout <<"***************before***************"<<endl;

	//声明划分函数，参数为一个整型数组，起始位置和结束位置
	void randomPartition(int *a, int p, int r);
	//声明选择函数，参数为一个整型数组，起始位置，结束位置和查找顺序位
	//返回第i小的数
	int randomizedSelect(int *a, int p, int r, int i);

	//定义数组
	int a[length] = {2,4,3,7,6,1,5};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	cout <<"***************randomizedSelect***************"<<endl;
	//打出第三个数
	int i = randomizedSelect(a, 0, length-1, 3);
	cout <<"打出第三个数: "<< i<<endl;

	//打出第六个数
	int j = randomizedSelect(a, 0, length-1, 6);
	cout <<"打出第六个数: "<< j<<endl;
}

//分割函数，返回分割位置
int partition(int *a, int p, int r){
	//设最后一个数为标识数
	int pivot = a[r];
	int i = p-1;

	//循环体
	for(int j = p; j < r; j ++){
		//若a[j]较小
		if(a[j] < pivot){
			i ++;
			//a[i]与a[j]交换
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
	}
	//循环体结束，将标识数放在合适的位置，交换
	int temp = a[i+1];
	a[i+1] = pivot;
	a[r] = temp;

	//返回位置
	return i+1;
}

//随机数版的分割函数
int randomPartition(int *a, int p, int r){
	int partition(int *, int, int);

	//生成随机数
	srand(unsigned(time(0)));
	int i = rand()%length;
	
	//交换
	int temp = a[i];
	a[i] = a[r];
	a[r] = temp;

	return partition(a, p, r);

	//cout << "i: "<<i<<endl;
}

int randomizedSelect(int *a, int p, int r, int i){
	//若待查序列长度为1，则返回此数
	if(p == r){
		return a[p];
	}
	//划分pivot的位置
	//int q = randomPartition(a, p, r);
	int q = partition(a, p, r);

	//计算q的顺序位
	int k = q-p+1;

	//检查k是否就是目标i
	if(k == i){
		return a[q];
	}else if(i < k){
		//目标在左边
		return randomizedSelect(a, p, q-1, i);
	}else{
		//目标在右边
		return randomizedSelect(a, q+1, r, i-k);
	}
}
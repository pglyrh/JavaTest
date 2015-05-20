/*
作者：余瑞寒
时间：2014/4/1
作用：快速排序算法之尾递归版本的实现
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 7

using namespace std;

void main(){
	cout <<"***************quicksort_tail_recursion***************"<<endl;
	cout <<"***************before***************"<<endl;

	//声明排序函数，参数为一个整型数组，起始位置和结束位置
	void quicksortIteration(int *,int, int);

	//定义数组
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//调用排序函数
	quicksortIteration(a,0,length-1);

	cout <<"***************after***************"<<endl;
	//打出原始数据
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl<<endl;
}

//快排函数，第二个递归采用迭代方式，a为数组，p为起始位置，r为结束位置
void quicksortIteration(int *a, int p, int r){
	//声明分割函数
	int partition(int *, int, int);

	//判断条件
	while(p < r){
		//计算中点位置
		int q = partition(a,p,r);

		//递归
		quicksortIteration(a, p, q-1);

		//quicksort(a, q+1, r);
		p = q+1;
	}
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
}
/*
作者：余瑞寒
时间：2014/4/14
作用：堆排序算法的实现
*/

#include <iostream>
#include <stdlib.h>

//定义求左右结点、父结点的函数
#define left(i) 2*i+1
#define right(i) 2*(i+1)
#define parent(i) (i-1)/2

#define length 7

using namespace std;

//全局变量，当前待排序堆的大小
int heapsize = length;

void main(){
	cout <<"***************heapsort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//声明排序函数，参数为一个整型数组，起始位置和结束位置
	void heapsort(int *);
	void maxHeapify(int *a, int i);
	void buildMaxHeap(int *a);

	//定义数组
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//调用排序函数
	heapsort(a);

	//maxHeapify(a,2);
	//buildMaxHeap(a);
	

	cout <<"***************after***************"<<endl;
	//打出原始数据
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl;
}

//堆排序函数，a为数组
void heapsort(int *a){
	//声明建堆函数
	void buildMaxHeap(int *);
	//声明保持函数
	void maxHeapify(int *, int);
	//声明交换函数
	void exchange(int *, int *);

	//建堆
	buildMaxHeap(a);

	//调用排序
	for(int i= length-1; i >=1; i--){
		//交换第一个和最后一个元素，第一个元素为当前待排定序列中的最大值
		exchange(&a[i], &a[0]);
		//堆大小更新
		heapsize --;
		//调整堆
		maxHeapify(a, 0);
	}
}

//交换函数
void exchange(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

//保持堆性质的函数
void maxHeapify(int *a, int i){
	int l = left(i);
	int r = right(i);
	int largest;

	//获得较大数的位置
	if(l < heapsize && a[l] > a[i]){
		largest = l;	
	}else{
		largest = i;
	}
	if(r < heapsize && a[r] > a[largest]){
		largest = r;
	}
	//cout<<"largest"<<largest<<endl;
	
	//当前父结点不为最大，调整堆
	if(largest != i){
		exchange(&a[i],&a[largest]);
		maxHeapify(a, largest);
	}
}

//建堆
void buildMaxHeap(int *a){
	heapsize = length;
	
	//从最后一个内部结点开始调整堆
	for(int i = length/2-1; i>=0; i--){
		maxHeapify(a,i);
	}
}

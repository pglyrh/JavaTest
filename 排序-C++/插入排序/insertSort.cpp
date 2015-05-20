/*
作者：余瑞寒
时间：2014/3/30
作用：插入排序的实现
*/

#include <iostream>
#include <stdlib.h>

//定义数组大小
#define length 7

using namespace std;

void main(){
	//声明排序函数，参数为一个整型数组
	void insertsort(int *);
	//定义数组
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {4,2,1,};
	//调用排序函数
	insertsort(a);
}

//插入排序函数
void insertsort(int *a){
	cout <<"***************insertsort***************"<<endl;
	cout <<"***************before***************"<<endl;
	//打出原始数据
	for(int k=0; k < length; k++){
		cout << a[k];
	}
	cout<<endl;
	//排序
	//i为排第i个数
	for(int i=1; i < length; i++){
		int key = a[i];
		//j为当前趟的小光标，作为比较
		for(int j=i-1; j>=0; j--){
			//若要排的数比较小，则大数往后移动
			if(key < a[j]){
				a[j+1] = a[j];
				//找到目标位置，插入
				a[j] = key;
			}
		}
	}
	cout <<"***************after***************"<<endl;
	//打出排序之后的数据
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl;
}
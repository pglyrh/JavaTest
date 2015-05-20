/*
作者：余瑞寒
时间：2014/5/14
作用：基数排序算法的实现
*/

#include <iostream>
#include <stdlib.h>

#define length 7
//数的长度
#define dig 3

using namespace std;

void main(){
	cout <<"***************radixsort***************"<<endl;
	cout <<"*****************before****************"<<endl;

	//声明排序函数，参数为一个整型数组，和数值的长度
	void radixsort(int *, int );

	//定义数组
	int a[length] = {720,457,657,839,329,436,355};

	//打出原始数据
	for(int r=0; r < length; r++){
		cout << a[r] << " ";
	}
	cout<<endl;

	//调用排序函数
	radixsort(a, dig);	

	cout <<"*****************after*****************"<<endl;
	//打出排序后的数据
	for(int l=0; l < length; l++){
		cout << a[l]<<" ";
	}
	cout<<endl;
}

//改良后的计数排序函数，专为服务于基数排序，a为数组，i为当前要排序的位数
void countsortForRadix(int *a, int i){
	//动态申请一个数组
	int c[10];
	//暂时存放结果的数组
	int b[length];
	//当前待排序的位数上的数值
	int cd;

	//给统计数组赋值
	for(int k= 0; k < 10; k++){
		//初始化为0
		c[k] = 0;
	}

	//统计每个数据的值
	for(int j= 0; j < length; j++){
		//获得cd的值
		switch(i){
			case 1 : cd = (a[j]%100)%10;
				break;
			case 2 : cd = (a[j]%100)/10;
				break;
			case 3 : cd = a[j]/100;
				break;
		}
		//cout << "cd: "<<cd<<endl;
		//初始化为0
		c[cd] ++;
	}

	//更新c数组的值
	for(int l= 1; l < 10; l++){
		//初始化为0
		c[l] = c[l]+c[l-1];
	}

	//调用排序
	for(int r= length-1; r >= 0; r--){
		//获得cd的值
		switch(i){
			case 1 : cd = (a[r]%100)%10;
				break;
			case 2 : cd = (a[r]%100)/10;
				break;
			case 3 : cd = a[r]/100;
				break;
		}
		//cout << "cd: "<<cd<<endl;
		b[c[cd]-1] = a[r];
		c[cd] --;
	}

	//将数组b的值赋给a
	for(int e=0; e < length; e++){
		a[e] = b[e];
	}
}

void radixsort(int *a, int d){
	//从小到大依次排序
	for (int i = 1; i <= d; i++){
		countsortForRadix(a, i);
	}
}
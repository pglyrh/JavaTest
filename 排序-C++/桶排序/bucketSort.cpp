/*
作者：余瑞寒
时间：2014/5/14
作用：桶排序的实现
*/

#include <iostream>
#include <stdlib.h>
#include <list>

//定义数组大小
#define length 7

using namespace std;

void main(){
	//声明排序函数，参数为一个整型数组
	void bucketsort(float *);
	//void insertsort(int *);
	//定义数组
	float a[length] = {0.25,0.44,0.23,0.74,0.56,0.21,0.05};
	
	cout <<"***************bucketsort***************"<<endl;
	cout <<"*****************before*****************"<<endl;
	//打出原始数据
	for(int k=0; k < length; k++){
		cout << a[k] << " ";
	}
	cout<<endl;

	//调用排序函数
	bucketsort(a);

	cout <<"*****************after******************"<<endl;
	//打出排序之后的数据
	for(int l=0; l < length; l++){
		cout << a[l] << " ";
	}
	cout<<endl;
}

//桶排序
void bucketsort(float *a){
	list<float> b[length];
	//桶，链表
	//list<float> b;

	//将数组a放入b相应的桶中
	for(int i = 0; i < length; i++){
		int index = length*a[i];
		//cout<<"index: "<<index<<" ";
		b[index].push_back(a[i]);	
	}
	//cout << endl;
	
	//对每个桶（链表）进行插入排序
	for(int j = 0; j < length ; j++){
		//若不为空，排序
		if(!b[j].empty()){
			b[j].sort();
		}
	}

	//记录原数组下一个空位
	int l = 0;

	//将每个桶的数据放入原数组中
	for(int k = 0; k < length ; k++){
		//若不为空，则取出每一个数
		if(!b[k].empty()){
			list<float>::iterator itor;
			itor=b[k].begin();
			while(itor!=b[k].end())
			{
				//放入原数组
				a[l] = *itor;
				itor ++;
				l ++;
			} 
		}
	}
}
/*
���ߣ�����
ʱ�䣺2014/4/15
���ã����������㷨��ʵ��
*/

#include <iostream>
#include <stdlib.h>

//���������ҽ�㡢�����ĺ���
#define left(i) 2*i+1
#define right(i) 2*(i+1)
#define parent(i) (i-1)/2

#define length 7
//#define k 7

using namespace std;

//ȫ�ֱ�������ǰ������ѵĴ�С
int heapsize = length;

void main(){
	cout <<"***************countingsort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//����������������Ϊһ���������飬��ʼλ�úͽ���λ��
	void countingsort(int *,int *, int);

	//��������
	//int a[length] = {2,4,3,7,6,1,5};
	int a[length] = {2,2,0,7,0,1,2};

	int b[length];
	int k = 7;
	//int a[length] = {2,4,1};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//����������
	countingsort(a, b, k);	

	cout <<"***************after***************"<<endl;
	//�������������
	for(int l=0; l < length; l++){
		cout << b[l];
	}
	cout<<endl;
}

//����������aΪ����
void countingsort(int *a, int *b, int k){
	//��̬����һ������
	int *c;
	c = new int[k+1];

	//��ͳ�����鸳ֵ
	for(int i= 0; i <= k; i++){
		//��ʼ��Ϊ0
		c[i] = 0;
	}

	//ͳ��ÿ�����ݵ�ֵ
	for(int j= 0; j < length; j++){
		//��ʼ��Ϊ0
		c[a[j]] ++;
	}
	
	//����c�����ֵ
	for(int l= 1; l <= k; l++){
		//��ʼ��Ϊ0
		c[l] = c[l]+c[l-1];
	}

	//��������
	for(int r= length-1; r >= 0; r--){
		b[c[a[r]]-1] = a[r];
		c[a[r]] --;
	}
}
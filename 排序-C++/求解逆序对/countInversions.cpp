/*
���ߣ�����
ʱ�䣺2014/3/31
���ã��������Ե�ʵ��
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
	//����������������Ϊһ����������
	void mergesort(int *,int, int);
	//��������
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};
	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;
	//����������
	mergesort(a,0,length-1);
	cout <<"***************after***************"<<endl;
	//���ԭʼ����
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl<<endl;
	//count = count+1;
	cout<<"�����������"<<endl;
	cout<<"count: "<<count<<endl;
}

//�鲢��������aΪ���飬pΪ��ʼλ�ã�rΪ����λ��
void mergesort(int *a, int p, int r){
	//�����鲢����
	void merge(int *, int, int, int);
	//�ж�����
	if(p < r){
		//�����е�λ��
		int q = (p+r)/2;
		//�ݹ�
		mergesort(a, p, q);
		mergesort(a, q+1, r);
		merge(a,p,q,r);
	}
}

//�鲢����
void merge(int *a, int p, int q, int r){
	//��߳���
	int nl = q - p + 1;
	//�ұ߳���
	int rl = r - q;

	//int *arr = new int[��������ֵ];
	//�����µ�����
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

	//i,j��0
	i = 0;
	j = 0;
	//�鲢����
	for(int k = p; k <= r; k ++){
		if(larr[i]<=rarr[j]){
			a[k] = larr[i];
			i ++;
		}else{
			a[k] = rarr[j];
			j ++;
			//cout<<"i: "<<i<<endl;
			//�������ԣ�ֻ�������һ�仰
			if(i != nl){
				//cout<<"i != nl"<<endl;
				//count = count+nl-i;
				count += nl-i;
			}
		}
	}
}
/*
���ߣ�����
ʱ�䣺2014/4/1
���ã����������㷨֮β�ݹ�汾��ʵ��
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 7

using namespace std;

void main(){
	cout <<"***************quicksort_tail_recursion***************"<<endl;
	cout <<"***************before***************"<<endl;

	//����������������Ϊһ���������飬��ʼλ�úͽ���λ��
	void quicksortIteration(int *,int, int);

	//��������
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//����������
	quicksortIteration(a,0,length-1);

	cout <<"***************after***************"<<endl;
	//���ԭʼ����
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl<<endl;
}

//���ź������ڶ����ݹ���õ�����ʽ��aΪ���飬pΪ��ʼλ�ã�rΪ����λ��
void quicksortIteration(int *a, int p, int r){
	//�����ָ��
	int partition(int *, int, int);

	//�ж�����
	while(p < r){
		//�����е�λ��
		int q = partition(a,p,r);

		//�ݹ�
		quicksortIteration(a, p, q-1);

		//quicksort(a, q+1, r);
		p = q+1;
	}
}

//�ָ�������طָ�λ��
int partition(int *a, int p, int r){
	//�����һ����Ϊ��ʶ��
	int pivot = a[r];
	int i = p-1;

	//ѭ����
	for(int j = p; j < r; j ++){
		//��a[j]��С
		if(a[j] < pivot){
			i ++;
			//a[i]��a[j]����
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
	}
	//ѭ�������������ʶ�����ں��ʵ�λ�ã�����
	int temp = a[i+1];
	a[i+1] = pivot;
	a[r] = temp;

	//����λ��
	return i+1;
}

//�������ķָ��
int randomPartition(int *a, int p, int r){
	int partition(int *, int, int);

	//���������
	srand(unsigned(time(0)));
	int i = rand()%length;
	
	//����
	int temp = a[i];
	a[i] = a[r];
	a[r] = temp;

	return partition(a, p, r);
}
/*
���ߣ�����
ʱ�䣺2014/5/15
���ã��ÿ��������еĻ��ֺ���ʵ��˳��ͳ����
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 7

using namespace std;

void main(){
	cout <<"***************orderstatistics***************"<<endl;
	cout <<"***************before***************"<<endl;

	//�������ֺ���������Ϊһ���������飬��ʼλ�úͽ���λ��
	void randomPartition(int *a, int p, int r);
	//����ѡ����������Ϊһ���������飬��ʼλ�ã�����λ�úͲ���˳��λ
	//���ص�iС����
	int randomizedSelect(int *a, int p, int r, int i);

	//��������
	int a[length] = {2,4,3,7,6,1,5};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	cout <<"***************randomizedSelect***************"<<endl;
	//�����������
	int i = randomizedSelect(a, 0, length-1, 3);
	cout <<"�����������: "<< i<<endl;

	//�����������
	int j = randomizedSelect(a, 0, length-1, 6);
	cout <<"�����������: "<< j<<endl;
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

	//cout << "i: "<<i<<endl;
}

int randomizedSelect(int *a, int p, int r, int i){
	//���������г���Ϊ1���򷵻ش���
	if(p == r){
		return a[p];
	}
	//����pivot��λ��
	//int q = randomPartition(a, p, r);
	int q = partition(a, p, r);

	//����q��˳��λ
	int k = q-p+1;

	//���k�Ƿ����Ŀ��i
	if(k == i){
		return a[q];
	}else if(i < k){
		//Ŀ�������
		return randomizedSelect(a, p, q-1, i);
	}else{
		//Ŀ�����ұ�
		return randomizedSelect(a, q+1, r, i-k);
	}
}
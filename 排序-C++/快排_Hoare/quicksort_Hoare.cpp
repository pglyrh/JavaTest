/*
���ߣ�����
ʱ�䣺2014/4/1
���ã���������_Hoare�����㷨��ʵ��
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>

#define length 12

using namespace std;

void main(){
	cout <<"***************hoare_quicksort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//����������������Ϊһ���������飬��ʼλ�úͽ���λ��
	void hoare_quicksort(int *, int, int);

	//��������
	int a[length] = {13,19,9,5,12,8,7,4,11,2,6,21};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r]<<" ";
	}
	cout<<endl;

	cout <<"***************after***************"<<endl;
	//q = hoarePartition(a, 0, length-1);
	//cout<<"q: "<<q<<endl;
	//����������
	hoare_quicksort(a,0,length-1);
	
	//�������������
	for(int l=0; l < length; l++){
		cout << a[l]<<" ";
	}
	cout<<endl<<endl;

}

void hoare_quicksort(int *a, int p, int r){
	int hoarePartition(int *, int, int);
	
	//�ж�����
	if(p < r){
		//�����е�λ��
		int q = hoarePartition(a,p,r);
		//cout << "q: "<<q;
		//cout << endl;

		//�ݹ�
		hoare_quicksort(a, p, q);
		hoare_quicksort(a, q+1, r);
	}

}

//Hoare���ֺ��������طָ�λ�ã�ָ�����һ��С��pivot�����±�
int hoarePartition(int *a, int p, int r){
	//���һ����Ϊpivot
	int x = a[p];

	//����i��j�ĳ�ʼλ��
	int i = p-1;
	int j = r+1;
	//cout<<"x: "<<x<<" i: "<<i<<" j: "<<j<<endl;

	//����ѭ����
	while(true){
		do{
			//j������
			j --;
		}while(a[j] > x);
		
		do{
			//i������
			i ++;
		}while(a[i] < x);
		
		//cout<<"i: "<<i<<" j: "<<j<<endl;

		if(i<j){
			//����a[i]��a[j]
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}else{
			//����λ��
			return j;
		}
	}
}

/*
���ߣ�����
ʱ�䣺2014/4/14
���ã��������㷨��ʵ��
*/

#include <iostream>
#include <stdlib.h>

//���������ҽ�㡢�����ĺ���
#define left(i) 2*i+1
#define right(i) 2*(i+1)
#define parent(i) (i-1)/2

#define length 7

using namespace std;

//ȫ�ֱ�������ǰ������ѵĴ�С
int heapsize = length;

void main(){
	cout <<"***************heapsort***************"<<endl;
	cout <<"***************before***************"<<endl;

	//����������������Ϊһ���������飬��ʼλ�úͽ���λ��
	void heapsort(int *);
	void maxHeapify(int *a, int i);
	void buildMaxHeap(int *a);

	//��������
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {2,4,1};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r];
	}
	cout<<endl;

	//����������
	heapsort(a);

	//maxHeapify(a,2);
	//buildMaxHeap(a);
	

	cout <<"***************after***************"<<endl;
	//���ԭʼ����
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl;
}

//����������aΪ����
void heapsort(int *a){
	//�������Ѻ���
	void buildMaxHeap(int *);
	//�������ֺ���
	void maxHeapify(int *, int);
	//������������
	void exchange(int *, int *);

	//����
	buildMaxHeap(a);

	//��������
	for(int i= length-1; i >=1; i--){
		//������һ�������һ��Ԫ�أ���һ��Ԫ��Ϊ��ǰ���Ŷ������е����ֵ
		exchange(&a[i], &a[0]);
		//�Ѵ�С����
		heapsize --;
		//������
		maxHeapify(a, 0);
	}
}

//��������
void exchange(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

//���ֶ����ʵĺ���
void maxHeapify(int *a, int i){
	int l = left(i);
	int r = right(i);
	int largest;

	//��ýϴ�����λ��
	if(l < heapsize && a[l] > a[i]){
		largest = l;	
	}else{
		largest = i;
	}
	if(r < heapsize && a[r] > a[largest]){
		largest = r;
	}
	//cout<<"largest"<<largest<<endl;
	
	//��ǰ����㲻Ϊ��󣬵�����
	if(largest != i){
		exchange(&a[i],&a[largest]);
		maxHeapify(a, largest);
	}
}

//����
void buildMaxHeap(int *a){
	heapsize = length;
	
	//�����һ���ڲ���㿪ʼ������
	for(int i = length/2-1; i>=0; i--){
		maxHeapify(a,i);
	}
}

/*
���ߣ�����
ʱ�䣺2014/3/30
���ã����������ʵ��
*/

#include <iostream>
#include <stdlib.h>

//���������С
#define length 7

using namespace std;

void main(){
	//����������������Ϊһ����������
	void insertsort(int *);
	//��������
	int a[length] = {2,4,3,7,6,1,5};
	//int a[length] = {4,2,1,};
	//����������
	insertsort(a);
}

//����������
void insertsort(int *a){
	cout <<"***************insertsort***************"<<endl;
	cout <<"***************before***************"<<endl;
	//���ԭʼ����
	for(int k=0; k < length; k++){
		cout << a[k];
	}
	cout<<endl;
	//����
	//iΪ�ŵ�i����
	for(int i=1; i < length; i++){
		int key = a[i];
		//jΪ��ǰ�˵�С��꣬��Ϊ�Ƚ�
		for(int j=i-1; j>=0; j--){
			//��Ҫ�ŵ����Ƚ�С������������ƶ�
			if(key < a[j]){
				a[j+1] = a[j];
				//�ҵ�Ŀ��λ�ã�����
				a[j] = key;
			}
		}
	}
	cout <<"***************after***************"<<endl;
	//�������֮�������
	for(int l=0; l < length; l++){
		cout << a[l];
	}
	cout<<endl;
}
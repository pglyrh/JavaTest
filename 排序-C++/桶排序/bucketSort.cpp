/*
���ߣ�����
ʱ�䣺2014/5/14
���ã�Ͱ�����ʵ��
*/

#include <iostream>
#include <stdlib.h>
#include <list>

//���������С
#define length 7

using namespace std;

void main(){
	//����������������Ϊһ����������
	void bucketsort(float *);
	//void insertsort(int *);
	//��������
	float a[length] = {0.25,0.44,0.23,0.74,0.56,0.21,0.05};
	
	cout <<"***************bucketsort***************"<<endl;
	cout <<"*****************before*****************"<<endl;
	//���ԭʼ����
	for(int k=0; k < length; k++){
		cout << a[k] << " ";
	}
	cout<<endl;

	//����������
	bucketsort(a);

	cout <<"*****************after******************"<<endl;
	//�������֮�������
	for(int l=0; l < length; l++){
		cout << a[l] << " ";
	}
	cout<<endl;
}

//Ͱ����
void bucketsort(float *a){
	list<float> b[length];
	//Ͱ������
	//list<float> b;

	//������a����b��Ӧ��Ͱ��
	for(int i = 0; i < length; i++){
		int index = length*a[i];
		//cout<<"index: "<<index<<" ";
		b[index].push_back(a[i]);	
	}
	//cout << endl;
	
	//��ÿ��Ͱ���������в�������
	for(int j = 0; j < length ; j++){
		//����Ϊ�գ�����
		if(!b[j].empty()){
			b[j].sort();
		}
	}

	//��¼ԭ������һ����λ
	int l = 0;

	//��ÿ��Ͱ�����ݷ���ԭ������
	for(int k = 0; k < length ; k++){
		//����Ϊ�գ���ȡ��ÿһ����
		if(!b[k].empty()){
			list<float>::iterator itor;
			itor=b[k].begin();
			while(itor!=b[k].end())
			{
				//����ԭ����
				a[l] = *itor;
				itor ++;
				l ++;
			} 
		}
	}
}
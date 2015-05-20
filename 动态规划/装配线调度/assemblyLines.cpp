/*
���ߣ�����
ʱ�䣺2014/5/15
���ã����ö�̬�滮ʵ��װ���ߵ���
*/

#include <iostream>
#include <stdlib.h>

#define n 6

using namespace std;

//ȫ�ֱ���
int f1[n], f2[n], l1[n], l2[n], _f, _l;

void main(){
	cout <<"***************assembly lines***************"<<endl;

	//�����������ҳ����·��
	void fastestWay(int *,int *, int *,int *, int *,int *);

	//����һЩ����
	//int n = 6;
	int e[2] = {2,4};
	int x[2] = {3,2};
	int a1[n] = {7,9,3,4,8,4};
	int a2[n] = {8,5,6,4,5,7};
	int t1[n-1] = {2,3,1,3,4};
	int t2[n-1] = {2,1,2,2,1};

	fastestWay(a1, a2, t1, t2, e, x);

	cout <<"******************after******************"<<endl;
	//���f1
	cout<<"f1: ";
	for(int i = 0; i < n; i++){
		//���f1
		cout<<f1[i]<<" ";
	}
	cout << endl;
	//���f2
	cout<<"f2: ";
	for(int j = 0; j < n; j++){
		//���f2
		cout<<f2[j]<<" ";
	}
	cout << endl;
	//���l1
	cout<<"l1: ";
	for(int k = 0; k < n; k++){
		//���l1
		cout<<l1[k]<<" ";
	}
	cout << endl;
	//���l2
	cout<<"l2: ";
	for(int y = 0; y < n; y++){
		//���l1
		cout<<l2[y]<<" ";
	}
	cout << endl;
	
	//���_f
	cout<<"_f: "<<_f<<endl;
	//���_l
	cout<<"_l: "<<_l<<endl;
}

void fastestWay(int *a1,int *a2,int *t1,int *t2,int *e,int *x){
	//�����һվ��ʱ��
	f1[0] = e[0] + a1[0];
	f2[0] = e[1] + a2[0];

	//��������ߣ�ÿһվ�����ʱ��
	for (int i = 1; i < n; i++){
		//��һ����
		if(f1[i-1]+a1[i] <= f2[i-1]+t2[i-1]+a1[i]){
			//��һվ�ߵ�һ���߸���
			f1[i] = f1[i-1]+a1[i];
			l1[i] = 1;
		}else{
			//��һվ�ߵڶ����߸���
			f1[i] = f2[i-1]+t2[i-1]+a1[i];
			l1[i] = 2;
		}
		//�ڶ�����
		if(f2[i-1]+a2[i] <= f1[i-1]+t1[i-1]+a2[i]){
			//��һվ�ߵڶ����߸���
			f2[i] = f2[i-1]+a2[i];
			l2[i] = 2;
		}else{
			//��һվ�ߵ�һ���߸���
			f2[i] = f1[i-1]+t1[i-1]+a2[i];
			l2[i] = 1;
		}
	}

	//��������ֵ
	if(f1[n-1]+x[0] <= f2[n-1]+x[1]){
		//��1���߳����Ͽ�
		_f = f1[n-1]+x[0];
		_l = 1;
	}else{
		//��2���߳����Ͽ�
		_f = f2[n-1]+x[1];
		_l = 2;
	}
}

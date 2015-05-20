/*
���ߣ�����
ʱ�䣺2014/5/19
���ã����ö�̬�滮ʵ�־������˷�
*/

#include <iostream>
#include <stdlib.h>
#include <limits.h>

//#define n 6

using namespace std;

//ȫ�ֱ���
int **m; //����ֵ
int **s; //�ָ��
int n = 6; //�������

void main(){
	cout <<"***************matrix-chain multiplication***************"<<endl;

	//�����������ҳ����ų˻�˳�򣬲���Ϊ��¼ά�ȵ�����
	void matrixChainOrder(int *);

	//����һЩ����
	//int n = 6; //�������
	//int *p; //��¼ά�ȵ�����
	
	//��ʼ��
	//p = new int[n+1];
	int p[7] = {30, 35, 15, 5, 10, 20, 25};

	m = new int *[n];
	for(int i = 0; i < n; i++){
		m[i] = new int[n];
	}

	s = new int *[n];
	for(i = 0; i < n; i++){
		s[i] = new int[n];
	}

	//�����鸳��ֵ
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			s[i][j] = 0;
			m[i][j] = 0;
		}		
	}

	matrixChainOrder(p);

	cout <<"******************after******************"<<endl;
	//���m
	cout<<"m: "<<endl;
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			//���m[i][j]
			cout<<m[i][j]<<" ";
		}
		cout<<endl;
	}
	cout << endl;
	//���s
	cout<<"s: "<<endl;
	for(i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			//���s[i][j]
			cout<<s[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

void matrixChainOrder(int *p){
	//��ʼ��m[i][i]��ֵ
	for(int t = 0; t < n; t++){
		m[t][t] = 0;
	}

	//�ӶԽ��߷�����������ÿһ��ֵ
	for(int l = 2; l <=n ; l++){ //lΪ������
		for(int i = 0; i < n-l+1; i++){ //iΪ�к�
			int j = i+l-1;                  //jΪ�кţ���l������
			m[i][j] = INT_MAX;

			//��̽kֵ
			for(int k = i; k < j; k++){
				int q = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1]; //qΪ��ǰkֵ�ı����˷���

				if(q<m[i][j]){
					//��k����
					m[i][j] = q;
					s[i][j] = k+1;
				}
			}
		}
	}
}


/*
���ߣ�����
ʱ�䣺2014/5/19
���ã����ö�̬�滮ʵ�־������˷�
*/

#include <iostream>
#include <stdlib.h>
#include <limits.h>

//��������ĳ���
#define length(arr)  (sizeof(arr)/sizeof(arr[0]))

using namespace std;

//ȫ�ֱ���
int **c; //xi��yj��LCS����
int **b; //���Ž�Ĺ���
//int n = 6; //�������

void main(){
	cout <<"***************longest common sbusequence***************"<<endl;

	//���������Ӵ�����
	char x[7] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
	char y[6] = {'B', 'D', 'C', 'A', 'B', 'A'};

	//�������������LCS�ĳ��ȣ�����Ϊ���������������Լ�����ĳ���
	void lcsLength(char *, char *, int, int);

	//���x��y�ĳ���
	int m = length(x);
	int n = length(y);
	
	//���x��y
	cout << "x: ";
	for(int i = 0; i < m; i++){
		cout<<x[i]<<" ";
	}
	cout<<endl;
	cout << "y: ";
	for(i = 0; i < n; i++){
		cout<<y[i]<<" ";
	}
	cout<<endl;

	//��ʼ��
	c = new int *[m+1];
	//1��ʾ����2��ʾб���ϣ�3��ʾ����
	b = new int *[m+1];
	for(i = 0; i <= m; i++){
		c[i] = new int[n+1];
		b[i] = new int[n+1];
	}

	lcsLength(x, y, m, n);

	cout <<"******************after******************"<<endl;
	
	//���c
	cout<<"c: "<<endl;
	for(i = 0; i <= m; i++){
		for(int j = 0; j <= n; j++){
			//���c[i][j]
			cout<<c[i][j]<<" ";
		}
		cout<<endl;
	}
	cout << endl;
	//���b
	cout<<"b: "<<endl;
	for(i = 0; i <=m ; i++){
		for(int j = 0; j <= n; j++){
			//���b[i][j]
			cout<<b[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

void lcsLength(char *x, char *y, int m, int n){
	//��ʼ��i��j�к�0��ֵΪ0
	for(int j = 0; j <= n; j++){
		c[0][j] = 0;
		b[0][j] = 0;
	}
	for(int i = 1; i <= m; i++){
		c[i][0] = 0;
		b[i][0] = 0;
	}

	//���ݱȽϽ�ֵ����c���b��
	for(i = 1; i <=m ; i++){ //iΪ�к�
		for(j = 1; j <= n; j++){ //jΪ�к�
			//�ж�
			if(x[i-1] == y[j-1]){//��ƥ��
				c[i][j] = c[i-1][j-1]+1;
				b[i][j] = 2;
			}else{ //��ƥ��
				if(c[i-1][j] >= c[i][j-1]){ //�Ϸ���ֵ����
					c[i][j] = c[i-1][j];
					b[i][j] = 3;
				}else{ //�󷽵�ֵ����
					c[i][j] = c[i][j-1];
					b[i][j] = 1;
				}
			} 
		}
	}
}


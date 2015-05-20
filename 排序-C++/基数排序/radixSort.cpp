/*
���ߣ�����
ʱ�䣺2014/5/14
���ã����������㷨��ʵ��
*/

#include <iostream>
#include <stdlib.h>

#define length 7
//���ĳ���
#define dig 3

using namespace std;

void main(){
	cout <<"***************radixsort***************"<<endl;
	cout <<"*****************before****************"<<endl;

	//����������������Ϊһ���������飬����ֵ�ĳ���
	void radixsort(int *, int );

	//��������
	int a[length] = {720,457,657,839,329,436,355};

	//���ԭʼ����
	for(int r=0; r < length; r++){
		cout << a[r] << " ";
	}
	cout<<endl;

	//����������
	radixsort(a, dig);	

	cout <<"*****************after*****************"<<endl;
	//�������������
	for(int l=0; l < length; l++){
		cout << a[l]<<" ";
	}
	cout<<endl;
}

//������ļ�����������רΪ�����ڻ�������aΪ���飬iΪ��ǰҪ�����λ��
void countsortForRadix(int *a, int i){
	//��̬����һ������
	int c[10];
	//��ʱ��Ž��������
	int b[length];
	//��ǰ�������λ���ϵ���ֵ
	int cd;

	//��ͳ�����鸳ֵ
	for(int k= 0; k < 10; k++){
		//��ʼ��Ϊ0
		c[k] = 0;
	}

	//ͳ��ÿ�����ݵ�ֵ
	for(int j= 0; j < length; j++){
		//���cd��ֵ
		switch(i){
			case 1 : cd = (a[j]%100)%10;
				break;
			case 2 : cd = (a[j]%100)/10;
				break;
			case 3 : cd = a[j]/100;
				break;
		}
		//cout << "cd: "<<cd<<endl;
		//��ʼ��Ϊ0
		c[cd] ++;
	}

	//����c�����ֵ
	for(int l= 1; l < 10; l++){
		//��ʼ��Ϊ0
		c[l] = c[l]+c[l-1];
	}

	//��������
	for(int r= length-1; r >= 0; r--){
		//���cd��ֵ
		switch(i){
			case 1 : cd = (a[r]%100)%10;
				break;
			case 2 : cd = (a[r]%100)/10;
				break;
			case 3 : cd = a[r]/100;
				break;
		}
		//cout << "cd: "<<cd<<endl;
		b[c[cd]-1] = a[r];
		c[cd] --;
	}

	//������b��ֵ����a
	for(int e=0; e < length; e++){
		a[e] = b[e];
	}
}

void radixsort(int *a, int d){
	//��С������������
	for (int i = 1; i <= d; i++){
		countsortForRadix(a, i);
	}
}
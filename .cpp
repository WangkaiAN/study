#include<iostream>
#include<fstream>
#include<string>
using namespace std;
void main()
{
	FILE *fp;  //����һ���ļ�ָ��*fp
	char ch;
	fp=fopen("D:\\ѧ��.txt","r");   //��ֻ����ʽ��D��\data.txt�ļ�
	if(fp==NULL)    
		cout<<"can not open!"<<endl;  //���fpָ��ָ��Ϊ�գ����ļ�Ϊ�գ������can not open
	else{
		                       //��ȡ�ַ���fscanf(fp,"%c",&ch)��ch=fgetc(fp);
		fscanf(fp,"%c",&ch);   //��ȡ�ַ�
		while(!feof(fp)){      //feof������������������ж�ָ���Ƿ��Ѿ������ļ�β����,�˴������û�е���ĩβѭ��
		cout<<ch;           //���
		fscanf(fp,"%c",&ch);   //�ٴζ�ȡ�ַ�
		}
		fclose(fp);   //�ر��ļ�
	 }
cout<<endl;
}


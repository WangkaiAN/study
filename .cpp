#include<iostream>
#include<fstream>
#include<string>
using namespace std;
void main()
{
	FILE *fp;  //创建一个文件指针*fp
	char ch;
	fp=fopen("D:\\学生.txt","r");   //以只读方式打开D：\data.txt文件
	if(fp==NULL)    
		cout<<"can not open!"<<endl;  //如果fp指针指向为空，即文件为空，则输出can not open
	else{
		                       //读取字符：fscanf(fp,"%c",&ch)，ch=fgetc(fp);
		fscanf(fp,"%c",&ch);   //读取字符
		while(!feof(fp)){      //feof（）这个函数是用来判断指针是否已经到达文件尾部的,此处即如果没有到达末尾循环
		cout<<ch;           //输出
		fscanf(fp,"%c",&ch);   //再次读取字符
		}
		fclose(fp);   //关闭文件
	 }
cout<<endl;
}


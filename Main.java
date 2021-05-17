package day25;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            int[] arr = new int[]{1,10,100,1000,10000};
            //int[] result = new int[n];
            for(int i=0;i<arr.length;i++){
                int a=help(arr[i]);
                if(a>9999){
                    int b = a%10000;
                    System.out.print(b);
                }
                if(a<10000 && a>999){
                    System.out.print(a);
                }
                if(a<1000 && a>99){
                    System.out.print("0"+a);
                }
                if(a<100 && a>9){
                    System.out.print("00"+a);
                }
                if(a<10){
                    System.out.print("000"+a);
                }
            }
            System.out.println();
    }
    public static int help(int n){
        int a =1;
        int b =2;
        int c =a;
        while(n>2){
            c=a+b;
            a=b;
            b=c;
            n--;
        }
        return c;
    }
}
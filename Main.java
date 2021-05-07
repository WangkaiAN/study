package day17;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        String s1 = "999";
        String s2 = "1";
        StringBuffer s3 = new StringBuffer();
        int x1=0;
        int x2=0;
        int flag =0;
        int cur =0;
        int index1 = s1.length()-1;
        int index2 = s2.length()-1;
        while(index1>=0 || index2>=0){
            if(index1>=0){
                x1 = s1.charAt(index1)-'0';
                index1--;
            }
            if(index2>=0){
                x2 = s2.charAt(index2)-'0';
                index2--;
            }
            cur = x1+x2+flag;
            x1=0;
            x2=0;
            if(cur>9){
                flag=1;
                cur = cur%10;
            }
            else{
                flag=0;
            }
            s3.append(cur+"");
        }
        if(flag==1){
            s3.append("1");
        }
        s3.reverse();
        System.out.println(s3);
    }
}

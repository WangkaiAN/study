package day27;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            if(Mycompare(StringAdd(a,b),c) && Mycompare(StringAdd(a,c),b) && Mycompare(StringAdd(b,c),a)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static String StringAdd(String s1,String s2){
        String res = "";
        int i,j,t = 0;
        for(i=s1.length()-1,j=s2.length()-1; i>=0&& j>=0;i--,j--){
            t += ((s1.charAt(i)-'0')+(s2.charAt(j)-'0'));
            res = (char)(t%10+'0')+res;
            t/=10;
        }
        while(i>=0){
            t +=((s1.charAt(i))-'0');
            res = (char)(t+'0')+res;
            t/=10;
            i--;
        }
        while(j>=0){
            t+=(s2.charAt(j)-'0');
            res = (char)(t + '0')+res;
            t/=10;
            j--;
        }
        if(t>0){
            res = (char)(t+'0')+res;
        }
        return res;
    }
    public static boolean Mycompare(String s1, String s2){
        if(s1.length() > s2.length()){
            return true;
        }else if(s1.length()<s2.length()){
            return false;
        }else if(s1.compareTo(s2)>0){
            return true;
        }else{
            return false;
        }
    }
}

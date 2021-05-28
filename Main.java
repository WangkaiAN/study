package day35;

import java.util.Scanner;
import java.util.TreeSet;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeSet<String> set = null;
        while(sc.hasNext()){
            set = new TreeSet<>();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int flag=0;
            for(int i =0;i<s1.length();){
                StringBuffer s3 = new StringBuffer();
                if(s1.charAt(i)=='"'){
                    i++;
                    flag=1;
                }
                if(flag==0){
                    while(i<s1.length() && s1.charAt(i)!=','){
                        s3.append(s1.charAt(i));
                        i++;
                    }
                }else{
                    while(i<s1.length() && s1.charAt(i)!='"'){
                        s3.append(s1.charAt(i));
                        i++;
                    }
                    flag=0;
                    i++;
                }
                i++;
                set.add(String.valueOf(s3));
            }
            if(set.contains(s2)){
                System.out.println("Ignore");
            }else{
                System.out.println("Important!");
            }
        }
        sc.close();
    }
}
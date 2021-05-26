package day33;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            //System.out.println(s1);
            //System.out.println(s2);
            int count=0;
            for(int i =0;i<s1.length();){
                if(s1.charAt(i) == s2.charAt(0)){
                    int j=i+1;
                    int index=1;
                    for(;j<s1.length() && index<s2.length();j++,index++){
                        if(s1.charAt(j)!= s2.charAt(index)){
                            break;
                        }
                    }
                    if(index==s2.length()){
                        i=i+s2.length();
                        count++;
                        continue;
                    }
                }
                i++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}

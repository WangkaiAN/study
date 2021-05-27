package day34;

import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] as = new String[n];
            for(int i=0;i<as.length;i++){
                as[i] = sc.nextLine();
            }
            for(int i =0;i<as.length;i++){
                if(as[i].contains(" ") || as[i].contains(",")){
                    as[i] = help(as[i]);
                }
            }
            for(int i =0;i<n;i++){
                System.out.print(as[i]);
                if(i!=n-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
    public static String help(String s){
        char[] ac = new char[s.length()+2];
        ac[0] = '"';
        for(int i=1;i<=s.length();i++){
            ac[i] = s.charAt(i-1);
        }
        ac[ac.length-1] = '"';
        String s1 = new String(ac);
        return s1;
    }
}

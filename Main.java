package day11;

import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        int n=28;
        int count=0;
            ArrayList<Integer> list = null;
            while(n>0){
                list = ChangList(n);
                int sum = addList(list);
                if(sum == n){
                    count++;
                }
                n--;
            }
            System.out.println(count);
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int count=0;
//            ArrayList<Integer> list = null;
//            while(n>0){
//                list = ChangList(n);
//                int sum = addList(list);
//                if(sum == n){
//                    count++;
//                }
//                n--;
//            }
//            System.out.println(count);
//        }
    }
    public static ArrayList ChangList(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1;i<=n/2;i++){
            if(n%i==0)
                list.add(i);
        }
        return list;
    }
    public static int addList(ArrayList list){
        int sum =0;
        for(int i=0;i<list.size();i++){
            sum= sum+(int)list.get(i);
        }
        return sum;
    }
}
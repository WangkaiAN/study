package day37;

import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] as = new String[n];
            boolean[] ab = new boolean[n];
            for(int i =0;i<n;i++){
                as[i] = sc.nextLine();
            }
            Arrays.sort(as);
            for(int i = 0;i<n-1;i++){
                if(as[i] == as[i+1]){
                    ab[i] = true;
                }else if(as[i].length() < as[i+1].length() &&
                        as[i].equals(as[i+1].substring(0,as[i].length()))&&
                        as[i+1].charAt(as[i].length())=='/'){
                    ab[i] = true;
                }
            }
            for(int i =0;i<n;i++){
                if(!ab[i]){
                    System.out.println("mkdir -p "+as[i]);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

//数据库连接池
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int[] arr = null;
//        while(sc.hasNext()){
//            int n = Integer.parseInt(sc.nextLine());
//            arr = new int[n];
//            for(int i =0;i<n;i++){
//                String[] as= sc.nextLine().split(" ");
//                if("connect".equals(as[1])){
//                    arr[i] = 1;
//                }else{
//                    arr[i] = -1;
//                }
//            }
//            //System.out.println(Arrays.toString(arr));
//            System.out.println(help(arr));;
//        }
//        sc.close();
//    }
//
//    private static int help(int[] arr) {
//        int sum =0;
//        int max = arr[0];
//        for(int i =0;i<arr.length;i++){
//            sum += arr[i];
//            if(sum>max){
//                max = sum;
//            }
//            if(sum<0){
//                sum = 0;
//            }
//        }
//        return max;
//    }
//}
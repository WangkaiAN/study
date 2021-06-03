package day40;

import java.util.Scanner;

//最长上升子序列
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] ar = new int[n];
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
            }
            System.out.println(help(ar));
        }
        sc.close();
    }
    public static int help(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = 1;
        for(int i =1;i<arr.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
//发邮件
//import java.util.Scanner;
//public class Main{
//    public static v7oid main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            System.out.println(help(n));
//        }
//        sc.close();
//    }
//    public static long help(int n){
//        long[] dp = new long[n+1];
//        dp[1] = 0;
//        dp[2] = 1;
//        if(n == 2){
//            return dp[2];
//        }
//        for(int i=3;i<=n;i++){
//            dp[i] = (i-1)*(dp[i-1]+dp[i-2]);
//        }
//        return dp[n];
//    }
//}

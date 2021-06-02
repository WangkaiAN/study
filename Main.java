package day39;

//最长公共子序列（动态规划）
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1 = sc.next();
//            String s2 = sc.next();
//            //System.out.println(s1+" "+s2);
//            System.out.println(find(s1,s1.length(),s2,s2.length()));
//        }
//        sc.close();
//    }
//    public static int find(String s1,int n,String s2,int m){
//        int[][] dp = new int[n+1][m+1];
//        for(int i =1;i<=n;i++){
//            for(int j = 1;j<=m;j++){
//                if(s1.charAt(i-1) == s2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                }else{
//                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j]:dp[i][j-1];
//                }
//            }
//        }
//        return dp[n][m];
//    }
//}

//字符串计数
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1 = sc.next();
//            String s2 = sc.next();
//            int len1 = sc.nextInt();
//            int len2 = sc.nextInt();
//            char[] ch1 = s1.toCharArray();
//            char[] ch2 = s2.toCharArray();
//            int res = 0;
//            int[] dp = new int[len2+1];
//            for(int i = 1;i<= len2;i++){
//                dp[i] = (dp[i-1]*26)%1000007;
//                if(i<=s1.length()) dp[i] = dp[i]-(ch1[i-1]-96);
//                if(i<=s2.length()) dp[i] = dp[i]+(ch2[i-1]-96);
//                if(i>=len1) res+=dp[i];
//            }
//            System.out.println((res-1)%1000007);
//        }
//        sc.close();
//    }
//}
package day38;
//蘑菇阵
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int num = sc.nextInt();
            double[][] dp = new double[n+1][m+1];
            boolean[][] flag = new boolean[n+1][m+1];
            for(int k=0;k<num;k++){
                int i = sc.nextInt();
                int j = sc.nextInt();
                flag[i][j] = true;
            }
            dp[1][1] = 1.0;
            for(int i =1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(!(i==1&&j==1)){
                        if(flag[i][j] == true){
                            dp[i][j] = 0;
                        }else{
                            dp[i][j] = dp[i-1][j]*(j==m? 1: 0.5)+dp[i][j-1]*(i==n? 1: 0.5);
                        }
                    }
                }
            }
            System.out.println(String.format("%.2f",dp[n][m]));
        }
        sc.close();
    }
}

//红与黑，广度优先遍历，bps
//import java.util.Scanner;
//public class Main{
//    static char[][] g = new char[20][20];
//    static int[] dx = {-1,0,1,0};
//    static int[] dy = {0,1,0,-1};
//    static int n,m,x,y;
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            m = sc.nextInt();
//            n = sc.nextInt();
//            if(n == 0 && m == 0){
//                return;
//            }
//            for(int i=0;i<m;i++){
//                String s = sc.next();
//                g[i] = s.toCharArray();
//                for(int j =0;j<n;j++){
//                    if(g[i][j] == '@'){
//                        x = i;
//                        y = j;
//                        g[i][j] = '1';
//                    }
//                }
//            }
//            dfs(x,y);
//            int ans = 0;
//            for(int i = 0;i<m;i++){
//                for(int j =0;j<n;j++){
//                    if(g[i][j] == '1'){
//                        ans++;
//                    }
//                }
//            }
//            System.out.println(ans);
//        }
//        sc.close();
//    }
//    public static void dfs(int x,int y){
//        g[x][y] = '1';
//        for(int i =0;i<4;i++){
//            int a = x+dx[i];
//            int b = y+dy[i];
//            if(a>=0 && a<m &&b>=0 && b<n && g[a][b] == '.'){
//                dfs(a,b);
//            }
//        }
//    }
//}

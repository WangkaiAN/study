package day42;

//走迷宫
import java.util.Scanner;
public class Main{
    public static int[][] fd = {{1,0},{0,1},{-1,0},{0,-1}};
    public static char[][] c = new char[10][10];
    public static int[][] num = new int[10][10];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            for(int i =0;i<10;i++){
                c[i] = sc.next().toCharArray();
            }
            for(int i =0;i<10;i++){
                for(int j =0;j<10;j++){
                    num[i][j] = Integer.MAX_VALUE;
                }
            }
            num[0][1] = 0;
            dfs(0,1);
            System.out.println(num[9][8]);
        }
        sc.close();
    }
    public static void dfs(int x,int y){
        int x1,y1;
        for(int i =0;i<4;i++){
            x1 = x+fd[i][0];
            y1 = y+fd[i][1];
            if(0<=x1 && x1<10 && y1<10 && y1>=0 && c[x1][y1] == '.'){
                if(num[x1][y1] > num[x][y]+1){
                    num[x1][y1] = num[x][y]+1;
                    dfs(x1,y1);
                }
            }
        }
    }
}

//解读密码
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            //System.out.println(s);
//            StringBuffer s1 = new StringBuffer();
//            for(int i =0;i<s.length();i++){
//                if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
//                    s1.append(s.charAt(i));
//                }
//            }
//            System.out.println(s1);
//        }
//        sc.close();
//    }
//}

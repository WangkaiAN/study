package day41;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Stack<Integer> stack = new Stack<>();
            int n=in.nextInt();
            for (int i = 0; i < n; i++) {
                String s=in.next();
                if (s.equals("+")){
                    stack.add((stack.pop()+stack.pop()));
                }else if(s.equals("-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b-a);
                }else if(s.equals("*")){
                    stack.add((stack.pop()*stack.pop()));
                }else if(s.equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    if (a!=0) {
                        stack.add(b / a);
                    }else {
                        stack.add(0);
                    }
                }else {
                    stack.add(Integer.parseInt(s));
                }

            }
            System.out.println(stack.peek());
        }

    }
}




//五子棋判断输赢
//import java.util.Scanner;
//import java.util.Arrays;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            char[][] ac = new char[20][20];
//            int i=0;
//            int j =0;
//            for(i =0;i<20;i++){
//                String s = sc.next();
//                char[] c2 = s.toCharArray();
//                for(j =0;j<20;j++){
//                    ac[i][j] = c2[j];
//                }
//            }
//            //for(int i =0;i<20;i++){
//            //   System.out.println(Arrays.toString(ac[i]));
//            //}
//            int flag=0;
//            for(i =0;i<20;i++){
//                if(flag==1){
//                    break;
//                }
//                for(j =0;j<20;j++){
//                    if(ac[i][j]!='.' && isWin(ac,i,j)){
//                        System.out.println("Yes");
//                        flag=1;
//                        break;
//                    }
//                }
//            }
//            if(i==20 && j==20){
//                System.out.println("No");
//            }
//        }
//        sc.close();
//    }
//    public static boolean isWin(char[][] ac,int x,int y){
//        char c = ac[x][y];
//        boolean win=false;
//        //列
//        int i =x;;
//            if(i<20-4 && ac[i][y]==c &&
//                    ac[i+1][y]==c &&
//                    ac[i+2][y]==c &&
//                    ac[i+3][y]==c &&
//                    ac[i+4][y]==c ){
//                win = true;
//                return win;
//            }
//        //行
//         i =y;
//            if(i<20-4 &&ac[x][i]==c &&
//                    ac[x][i+1]==c &&
//                    ac[x][i+2]==c &&
//                    ac[x][i+3]==c &&
//                    ac[x][i+4]==c ){
//                win = true;
//                return win;
//            }
//        int j=y;i=x;
//        if(i<20-4&& j<20-4 && ac[i][j]==c &&
//                ac[i+1][j+1]==c &&
//                ac[i+2][j+2]==c &&
//                ac[i+3][j+3]==c &&
//                ac[i+4][j+4]==c ){
//            win =true;
//            return win;
//        }
//        i=x;j=y;
//        if(i>3 && j<20-4 && ac[i][j]==c &&
//                ac[i-1][j+1]==c &&
//                ac[i-2][j+2]==c &&
//                ac[i-3][j+3]==c &&
//                ac[i-4][j+4]==c ){
//            win =true;
//            return win;
//        }
//        return win;
//    }
//}

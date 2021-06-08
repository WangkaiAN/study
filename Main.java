package day43;
//求和
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            dfs(1,0,m,n);
            for(ArrayList<Integer> l :res){
                for(int i =0;i<l.size();i++){
                    System.out.print(l.get(i));
                    if(i != l.size()-1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        sc.close();
    }
    public static void dfs(int index,int sum,int target,int n){
        if(sum>=target){
            if(sum==target){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = index;i<=n;i++){
            if(i>target) {
                continue;
            }
            list.add(i);
            dfs(i+1,sum+i,target,n);
            list.remove(list.size()-1);
        }
    }
}

//电话号码
//import java.util.Scanner;
//import java.util.Collections;
//import java.util.ArrayList;
//public class Main{
//    public static void main(String[] args){
//        String sy = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//        String nu = "222333444555666777788899991234567890";
//        ArrayList<String> list = null;
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            list = new ArrayList<>();
//            int n = Integer.parseInt(sc.nextLine());
//            for(int i = 0;i<n;i++){
//                String str = sc.nextLine();
//                str = str.replace("-","");
//                String result = "";
//                for(int j=0;j<7;j++){
//                    result += nu.charAt(sy.indexOf(str.charAt(j)+""));
//                }
//                result = result.substring(0,3)+"-"+result.substring(3,7);
//                if(!list.contains(result)){
//                    list.add(result);
//                }
//            }
//            Collections.sort(list);
//            for(int j = 0;j<list.size();j++){
//                System.out.println(list.get(j));
//            }
//            System.out.println();
//        }
//        sc.close();
//    }
//}
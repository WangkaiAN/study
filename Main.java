package day44;

/*
/单词倒排
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = null;
        while(sc.hasNext()){
            String s = sc.nextLine();
            list = new ArrayList<>();
            int i = 0;
            while(i<s.length()){
                if((s.charAt(i)<='z'&& s.charAt(i)>='a')||(s.charAt(i)<='Z'&& s.charAt(i)>='A')){
                    int j=i+1;
                    while(j<s.length() && ((s.charAt(j)<='z'&& s.charAt(j)>='a')||(s.charAt(j)<='Z'&& s.charAt(j)>='A'))){
                        j++;
                    }
                    list.add(s.substring(i,j));
                    i=j;
                }else{
                    i++;
                }
            }
            for(int k = list.size()-1;k>=0;k--){
                System.out.print(list.get(k));
                if(k!=0){
                    System.out.print(" ");
                }
            }
        }
        sc.close();
    }
}

/*
* 驼峰命名法
* */
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            char[] ac = s.toCharArray();
//            for(int i=0,j=1;j<s.length();i++,j++){
//                if(ac[i]=='_'){
//                    ac[j]=(char)(ac[j]-32);
//                }
//            }
//            String s1 = new String(ac);
//            s1 = s1.replaceAll("_","");
//            System.out.println(s1);
//        }
//        sc.close();
//    }
//}

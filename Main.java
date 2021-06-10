package day45;

//查找兄弟单词
//题目的坑在于没有说出输入格式，自测不通过的格式，提交时可以通过的
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] str = new String[n];//存放输入的字符串
            String[] result = new String[n+1];//存放字典排序后的兄弟字符串，
            // 这里假设输入的字符串都是目标单词的兄弟单词，看题目可以知道，返回的不是下标，而是+1
            for(int i = 0;i<n;i++){
                str[i] = sc.next();
            }
            Arrays.sort(str);
            String s = sc.next();
            int x = sc.nextInt();
            int count = 0,k=1;
            boolean flag = false;
            for(int i = 0;i<n;i++){//依次遍历字符串数组，核目标字符串作比较
                if(!s.equals(str[i])){
                    flag = help(s,str[i]);
                    if(flag){
                        count++;
                        result[k++] = str[i];
                    }
                }
            }
            System.out.println(count);
            if(count >= x){
                System.out.println(result[x]);
            }
        }
        sc.close();
    }
    public static boolean help(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return new String(c1).equals(new String(c2));
    }
}
//乒乓球筐
//import java.util.Scanner;
//import java.util.HashMap;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        HashMap<Character,Integer> map1 = null;
//        HashMap<Character,Integer> map2 = null;
//        while(sc.hasNext()){
//            String s1 = sc.next();
//            String s2 = sc.next();
//            map1 = new HashMap<>();
//            map2 = new HashMap<>();
//            map1 = help(s1);
//            map2 = help(s2);
//            //System.out.println(map1);
//            //System.out.println(map2);
//            int flag=0;
//            for(Character key : map2.keySet()){
//                if(map2.get(key)>map1.getOrDefault(key,0)){
//                    System.out.println("No");
//                    flag = 1;
//                    break;
//                }
//            }
//            if(flag==0){
//                System.out.println("Yes");
//            }
//        }
//        sc.close();
//    }
//    public static HashMap<Character,Integer> help(String s){
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i =0;i<s.length();i++){
//            char c = s.charAt(i);
//            int value = map.getOrDefault(c,0);
//            map.put(c,value+1);
//        }
//        return map;
//    }
//}
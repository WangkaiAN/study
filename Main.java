package day46;

//错误简单的记录
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            String str = sc.next();
            int line = sc.nextInt();
            String[] arr = str.split("\\\\");
            String s = arr[arr.length-1];
            if(s.length()>16){
                s = s.substring(s.length()-16);
            }
            String key = s + " "+line;
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        int count = 0;
        for(String string : map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)){
                System.out.println(string + " " + map.get(string));
            }
        }
    }
}

//数据中出现次数超过一半的数字

//import java.util.Arrays;
//
//public class Main {
//    public static void main(String[] args) {
//        int[] ar = new int[]{1,2,3,2,2,2,5,4,2};
//        System.out.println(MoreThanHalfNum_Solution(ar));
//    }
//    public static int MoreThanHalfNum_Solution(int [] array) {
//        int n = array.length/2;
//        Arrays.sort(array);
//        int x = array[n];
//        int count=1;
//        for(int i =0;i<array.length;i++){
//            if(array[i] == x){
//                count++;
//            }
//        }
//        if(count>n){
//            return x;
//        }
//        return 0;
//    }
//}

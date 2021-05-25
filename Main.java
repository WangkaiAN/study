package day32;

import java.util.Scanner;
public class Main{
    private static int[] leapYds = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    private static int[] nleapYds = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static int[] p={0,2,1,1,2,1,2,1,2,2,2,1,2};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year1 = sc.nextInt();
            int month1 = sc.nextInt();
            int day1 = sc.nextInt();
            int year2 = sc.nextInt();
            int month2 = sc.nextInt();
            int day2 = sc.nextInt();

            int sum=0;
            if(year1 == year2){
                sum = commonYear(year1,month1,day1,year2,month2,day2);
            }else{
                sum = NotCommonYear(year1,month1,day1,year2,month2,day2);
            }
            System.out.println(sum);
        }
        sc.close();
    }
    public static boolean isLeapYear(int year){
        return year % 400==0 || (year %4==0 && year %100 !=0);
    }
    public static int commonYear(int year1,int month1,int day1,int year2,int month2,int day2){
        int sum=0;
        if(month1 == month2){
            for(int i = day1;i<=day2;i++){
                sum += p[month1];
            }return sum;
        }
        if(isLeapYear(year1)){
            for(int i=day1;i<= leapYds[month1];i++){
                sum += p[month1];
            }
        }else{
            for(int i=day1;i<=nleapYds[month1];i++){
                sum += p[month1];
            }
        }
        month1++;
        while(month1 < month2){
            if(isLeapYear(year1)){
                sum += leapYds[month1] * p[month1];
            }else{
                sum += nleapYds[month1] * p[month1];
            }
        }
        for(int i=1;i<=day2;i++){
            sum +=p[month2];
        }
        return sum;
    }
    public static int NotCommonYear(int year1,int month1,int day1,int year2,int month2,int day2){
        int sum = 0;
        if(isLeapYear(year1)){
            for(int i=day1;i<=leapYds[month1];i++){
                sum += p[month1];
            }
        }else{
            for(int i=day1;i<=nleapYds[month1];i++){
                sum += p[month1];
            }
        }
        month1++;
        for(;month1 <13;month1++){
            if(isLeapYear(year1)){
                sum += leapYds[month1] * p[month1];
            }else{
                sum += nleapYds[month1] * p[month1];
            }
        }
        int year = year1+1;
        while(year<year2){
            int month = 1;
            while(month <13){
                if(isLeapYear(year1)){
                    sum += leapYds[month] * p[month];
                }else{
                    sum += nleapYds[month] * p[month];
                }
                month++;
            }
            year++;
        }
        if(isLeapYear(year2)){
            for(int i=1 ;i<= month2 ;i++){
                sum +=leapYds[i] * p[i];
            }
        }else{
            for(int i=1 ;i<= month2 ;i++){
                sum += nleapYds[i] * p[i];
            }
        }
        for(int i =1;i<=day2;i++){
            sum +=p[month2];
        }
        return sum;
    }
    //斐波那切凤尾数
//        public static void main(String[] args){
//            Scanner sc = new Scanner(System.in);
//            int[] result = new int[100001];
//            result[0] = 1;
//            result[1] = 1;
//            for(int i =2;i<100001;i++){
//                result[i] = (result[i-1] + result[i-2])%1000000;
//            }
//            while(sc.hasNext()){
//                int n = sc.nextInt();
//                System.out.printf(n<25 ? "%d\n":"%06d\n",result[n]);
//            }
//            sc.close();
//        }
}

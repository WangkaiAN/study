package day31;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.print(n+" = ");
            for(int i=2;i<=n/2;i++){//6=2*3
                while(n%i==0 && n!=i){
                    System.out.print(i+" * ");
                    n/=i;
                }
            }
            System.out.println(n);
        }
        sc.close();
    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int y = sc.nextInt();
//            NewYear(y);
//            Martin(y);
//            President(y);
//            Memorident(y);
//            Independence(y);
//            Labor(y);
//            Thanks(y);
//            Christmas(y);
//            System.out.println();
//        }
//        sc.close();
//    }
    public static int dayOfWeek(int year,int month,int day){
        if(month ==1 || month==2){
            month+=12;
            year-=1;
        }
        int cent = year/100;
        year %= 100;
        int week = year+(year/4)+(cent/4)-2*cent +26*(month+1)/10+day-1;
        week = (week%7 + 7)%7;
        if(week == 0){
            week =7;
        }
        return week;
    }
    public static int dayOfDemand(int year,int month,int count,int d){
        int week = dayOfWeek(year,month,1);
        int day = 1 + (count-1) * 7+(7+d-week)%7;
        return day;
    }
    public static void NewYear(int year){
        System.out.println(year+"-01-01");
    }
    public static void Martin(int year){
        System.out.printf(year+"-01-%02d\n",dayOfDemand(year,1,3,1));
    }
    public static void President(int year){
        System.out.printf(year+"-02-%02d\n",dayOfDemand(year,2,3,1));
    }
    public static void Memorident(int year){
        int week = dayOfWeek(year,6,1);
        int day = 31 -((week == 1) ? 6:(week-2));
        System.out.println(year+"-05-"+day);
    }
    public static void Independence(int year){
        System.out.println(year+"-07-04");
    }
    public static void Labor(int year){
        System.out.printf(year+"-09-%02d\n",dayOfDemand(year,9,1,1));
    }
    public static void Thanks(int year){
        System.out.printf(year+"-11-%02d\n",dayOfDemand(year,11,4,4));
    }
    public static void Christmas(int year){
        System.out.println(year+"-12-25");
    }
}

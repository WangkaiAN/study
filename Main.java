package day52;

public class Main {
    public static void main(String[] args) {
        System.out.println(help(10));
    }
    public static int help(int n){
        if(n==0){
            return 0;
        }
        int num=0;
        while(n!=0){
            num+=n%10;
            n=n/10;
        }
        return num;
    }
}


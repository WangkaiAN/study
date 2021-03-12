package test2021_3_10;

public class Test {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int ret = 0;
        ret = recentCounter.ping(1);
        System.out.println(ret);
        ret = recentCounter.ping(100);
        System.out.println(ret);
        ret = recentCounter.ping(3001);
        System.out.println(ret);
        ret = recentCounter.ping(3002);
        System.out.println(ret);
    }
}

package MyPriorityQueue;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{9,5,6,4,10,11,23,8};
        MyPQ pq = new MyPQ(arr,arr.length);
        System.out.println("变成堆之前"+ Arrays.toString(arr));
        System.out.println("编程堆之后"+pq.createUp(arr,arr.length));

        //插入
        pq.offer(3);
        System.out.println("插入之后"+pq);
        System.out.println("取堆顶元素"+pq.peek());
        pq.poll();
        System.out.println("删除堆顶元素之后"+pq);

    }
}

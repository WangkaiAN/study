package TopK;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class priorityQueueUse {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        PriorityQueue priorityQueue = new PriorityQueue<>();
        for(int j= 0;j<10;j++){
            priorityQueue.add(arr[j]);
        }
        System.out.println(priorityQueue);
        for(int i=10;i<arr.length;i++){
            if(arr[i] > (int)priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        System.out.println(priorityQueue);
    }
}

package MyPriorityQueue;

import java.util.PriorityQueue;

public class TestPQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(20);
        priorityQueue.offer(3);
        priorityQueue.offer(9);
        priorityQueue.offer(2);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        priorityQueue.offer(1);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
    }
}

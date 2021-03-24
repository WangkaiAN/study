package MyPriorityQueue;

import java.util.Arrays;

public class MyPQ {
    private int Max = 100;
    private  int[] data =new int[Max];
    private int size = 0;

    public MyPQ(int[] data, int size) {
        this.size = size;
        for(int i =0;i<size;i++){
            this.data[i] = data[i];
        }
    }
    public  void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2*parent +1;
        while(child<size){
            if(child+1<size && array[child+1]<array[child]){
                child = child+1;
            }
            if(array[parent]>array[child]){
                int tem = array[parent];
                array[parent] = array[child];
                array[child] = tem;
            }else{
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }
    public static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[parent] > array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public  MyPQ createUp(int[] array,int size) {

        //从左右孩子节点不为空的节点开始换，直接找到最后一个节点的父节点。
        //从下往上依次来进行更换
        for (int i = 0; i <= size-1; i++) {
            shiftUp(array, i);

        }
        MyPQ pq = new MyPQ(array,array.length);
        return pq;
    }
//    public  MyPQ createDown(int[] array) {
//
//        //从左右孩子节点不为空的节点开始换，直接找到最后一个节点的父节点。
//        //从下往上依次来进行更换
//        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
//            shiftDown(array, array.length, i);
//        }
//        MyPQ pq = new MyPQ(array,array.length);
//        return pq;
//    }
    private void realloc(){
        Max*=2;
        int[] arr=new int[Max];
        for(int i=0;i<data.length;i++){
            arr[i]=data[i];
        }
        data=arr;
    }
    public void offer(int val){
        if(size >= Max){
            realloc();
        }
        data[size] = val;
        size++;
        createUp(data,size);
    }

    //取堆顶元素
    public Integer peek(){
        if(size < 0){
            return null;
        }
        return data[0];
    }
    //删除堆顶元素
    public void poll(){
        if(size <0){
            return;
        }
        data[0] = data[size-1];
        size--;
        shiftDown(data,size,0);
    }
}

package Sort;

import java.util.Arrays;

public class MySort {
    public static void swep(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //插入排序
    public static void InsertSort(int[] arr){
        //无序区间
        for(int i = 1;i < arr.length;i++){
            int v = arr[i];
            int j= i-1;//有序区间
            for (;j>=0;j--){
                if(arr[j]>v){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }//内层循环退出时，相当于找到了，v要插入的位置
            arr[j+1] = v;
        }
    }
    //希尔排序
    public  static void shellSort(int[] arr){
        int gap = arr.length/2;
        while(gap>=1){
            SinsertSort(arr,gap);
            gap = gap/2;
        }
    }

    private static void SinsertSort(int[] arr, int gap) {
        for(int i = gap;i < arr.length;i++){
            int v = arr[i];
            int j= i-gap;//有序区间
            for (;j>=0;j-=gap){
                if(arr[j]>v){
                    arr[j+gap] = arr[j];
                }else{
                    break;
                }
            }//内层循环退出时，相当于找到了，v要插入的位置
            arr[j+gap] = v;
        }
    }
    //堆排序
    public static void heapSort(int[] arr){
        GreatHeap(arr);
        int leng = arr.length;
        for (int i =0;i<arr.length;i++){
            swep(arr,0,leng-1);
            leng--;
            shiftDown(arr,leng,0);
        }
    }

    private static void GreatHeap(int[] arr) {
        for(int i = (arr.length-1-1)/2;i>=0;i--){
            shiftDown(arr,arr.length,i);
        }
    }

    private static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2*parent+1;
        while(child<size){
            if(child+1<size && arr[child+1]>arr[child]){
                child = child+1;
            }
            if(arr[parent]<arr[child]){
                swep(arr,parent,child);
            }else{
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }
    //选择排序
    public static void selectSort(int[] arr){
        //有序区间在前，无序区间在后
        for (int i= 0;i<arr.length;i++){
            int max = i;
            for (int j= i+1;j<arr.length;j++){
                // 擂台就是i位置的元素.
                // 取 j 位置的元素和擂台进行比较.
                if(arr[j]<arr[max]){
                    max = j;
                }
            }
            swep(arr,max,i);
        }
    }
    //冒泡排序
    public static void bulleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //待排区间在前面，已排在后面
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swep(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={4,2,1,7,5,8,6,9,3};
//        InsertSort(arr);
//        shellSort(arr);
//        heapSort(arr);
        selectSort(arr);
//        bulleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package Map;

class HashNode{
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class HashMap {
    private HashNode[] array = new HashNode[4];
    private int size = 0;

    //加入
    public void put(int key,int value){
        int index = key % array.length;
        for (HashNode cur = array[index];cur!=null;cur=cur.next){
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        HashNode newNode = new HashNode(key,value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;

        //判断是否需要扩容
        if(loadFactor()>0.75){
            resize();
        }
    }

    private void resize() {
        HashNode[] newArray = new HashNode[array.length*2];
        for(int i = 0;i< array.length;i++){
            HashNode next = null;//这里cur就会去新的地方，
            // 但是他的后面节点不一定也去哪儿了
            //因为我们选择的是头插，所以说cur的后续节点也会发生改变
            for(HashNode cur = array[i];cur != null;cur = next){
                next = cur.next;
                int indexNew = cur.key % newArray.length;

                cur.next = newArray[indexNew];
                newArray[indexNew] = cur;
            }
        }
        array = newArray;
    }

    private double loadFactor() {
        return (double) size / array.length;
    }
    //得到
    public Integer get(int key){
        int index = key % array.length;
        for(HashNode cur = array[index];cur != null;cur =cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return null;
    }
    public int getSize(){
        return array.length;
    }
}






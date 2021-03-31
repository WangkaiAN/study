package Set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("二狗");
        set.add("大狗");
        set.add("小黑");
        set.add("大黄");
        System.out.println(set);

        System.out.println(set.contains("二狗"));
        for (String key : set){
            System.out.print(key+" ");
        }
        System.out.println();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
//        1. Set是继承自Collection的一个接口类
//        2. Set中只存储了key，并且要求key一定要唯一
//        3. Set的底层是使用Map来实现的，其使用key与Object的一个默认对象作为键值对插入到Map中的
//        4. Set最大的功能就是对集合中的元素进行去重
//        5.  实现Set接口的常用类有TreeSet和HashSet，还有一个LinkedHashSet，   LinkedHashSet是在HashSet的基础上维护了一个双向链表来记录元素的插入次序。
//        6. Set中的Key不能修改，如果要修改，先将原来的删除掉，然后再重新插入
//        7. Set中不能插入null的key。
//        8. TreeSet和HashSet的区别
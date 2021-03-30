package BinarySearchTree;

import java.util.Stack;

class BinaryNode{
    public int key;
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key +":"+ value+")" ;
    }
}
public class BinSeTree {
    private BinaryNode root = null;

    //插入
    public void put(int key,int value){
        if(root == null){
            root = new BinaryNode(key,value);
            return;
        }
        //不为空时，从根节点出发，找到合适的插入位置，
        //这里插入的位置肯定是一个空的，那么就需要一个父节点，
        // 来指向插入位置的父节点，进行插入
        BinaryNode cur = root;
        BinaryNode parent = null;
        while(cur !=null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                cur.value = value;
                return;
            }
        }
        //没有相同节点，这里直接到插入位置
        BinaryNode newN = new BinaryNode(key,value);
        if(newN.key < parent.key){
            parent.left = newN;
        }else{
            parent.right = newN;
        }
    }
    //获取
    public Integer get(int key){
        BinaryNode cur = root;
        while(cur != null){
            if(key < cur.key){
                cur = cur.left;
            }else if(key > cur.key){
                cur = cur.right;
            }else{
                return cur.value;
            }
        }
        return null;
    }
    //删除
    public void remove(int key){
        BinaryNode cur = root;
        BinaryNode parent = null;
        //先找到要删除的节点的位置
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                removeNode(parent,cur);
                return;
            }
        }
    }

    private void removeNode(BinaryNode parent, BinaryNode cur) {
        if(cur.left == null){
            //1
            if(cur == root){
                root = cur.right;
            }
            //2
            else if(cur == parent.left){
                parent.left = cur.right;
            }
            //3
            else if(cur == parent.right){
                parent.right = cur.right;
            }
        }
        else if(cur.right == null){
            //4
            if(cur == root){
                root = cur.left;
            }
            //5
            else if(cur == parent.left){
                parent.left = cur.left;
            }
            //6
            else if(cur == parent.right){
                parent.right = cur.left;
            }
        }
        else{
            //在右子树中找到最小值，来替换这个节点，
            // 顺便删掉找到的最小值的那个节点
            BinaryNode goat = cur.right;
            BinaryNode goatParent = cur;
            while(goat.left !=null){
                goatParent =goat;
                goat =goat.left;
            }
            cur.key = goat.key;
            cur.value = goat.value;
            //7
            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }else{ //8
                goatParent.right = goat.right;
            }
        }
    }
    //非递归的中序遍历
    public void InOderTraversal(){
        Stack<BinaryNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        BinaryNode cur =root;
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            BinaryNode t = stack.pop();
            System.out.print(t);
            cur = t.right;
        }
        System.out.println();
    }
}

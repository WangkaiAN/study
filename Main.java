package day48;

import java.util.ArrayList;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {

    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
                if(pNode == null) return null;
                if(pNode.right != null){//有右子树，则找到右子树的最左侧结点
                    pNode = pNode.right;
                    while(pNode.left != null){
                        pNode = pNode.left;
                    }
                    return pNode;
                }
                while(pNode.next != null){//没有右子树，找到当前节点满足自己是父结点的左孩子的结点
                    if(pNode.next.left == pNode){
                        return pNode.next;
                    }
                    pNode = pNode.next;
                }
                //遇到了根节点还是没有找到，
                return null;

        }

}

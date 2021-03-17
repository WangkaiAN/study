package LeveLorderT;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static TreeNode great() {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");

        A.left = B;
        A.right = C;
        B.left = D;
        C.left = E;
        E.right = F;

        return A;
    }

    public static void main(String[] args) {
        TreeNode root = great();
        levelOrderTraversal(root);
        System.out.println();
        System.out.println(isComleteTree(root));
    }

    public static boolean isComleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean isLevel = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(true){
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            if(!isLevel){
                if(cur.left != null && cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                if(cur.left != null && cur.right==null){
                    isLevel = true;
                    queue.offer(cur.left);
                }
                if(cur.left == null && cur.right != null){
                    return false;
                }
                else{
                    isLevel = true;
                }
            }else{
                if(cur.left !=null || cur.right != null){
                    return false;
                }
            }
        }return true;
    }

    private static void levelOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(true){
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            System.out.print(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
